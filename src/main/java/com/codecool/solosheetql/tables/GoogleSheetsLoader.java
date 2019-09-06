package com.codecool.solosheetql.tables;

import com.google.api.client.auth.oauth2.Credential;
import com.google.api.client.googleapis.auth.oauth2.GoogleCredential;
import com.google.api.client.googleapis.javanet.GoogleNetHttpTransport;
import com.google.api.client.http.javanet.NetHttpTransport;
import com.google.api.client.json.JsonFactory;
import com.google.api.client.json.jackson2.JacksonFactory;
import com.google.api.services.sheets.v4.Sheets;
import com.google.api.services.sheets.v4.SheetsScopes;
import com.google.api.services.sheets.v4.model.ValueRange;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.io.InputStream;
import java.security.GeneralSecurityException;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class GoogleSheetsLoader implements TableLoader {
    private static final String APPLICATION_NAME = "SheetQL";
    private static final JsonFactory JSON_FACTORY = JacksonFactory.getDefaultInstance();
    private static final String TOKENS_DIRECTORY_PATH = "tokens";

    /**
     * Global instance of the scopes required by this quickstart.
     * If modifying these scopes, delete your previously saved tokens/ folder.
     */
    private static final List<String> SCOPES = Collections.singletonList(SheetsScopes.SPREADSHEETS_READONLY);
    private static final String SERVICE_ACCOUNT_FILE_PATH = "/google_credentials.json";
    private final String worksheetName = "Class Data";
    private TablesRepository tablesRepository;

    @Autowired
    GoogleSheetsLoader(TablesRepository tablesRepository) {
        this.tablesRepository = tablesRepository;
    }

    public String loadTableContent(String spreadsheetName) throws TableNotFoundException{
        try {
            return String.join("\n", getSpreadsheetContent(spreadsheetName)).replaceAll("\\[|]", "");
        } catch (IOException | GeneralSecurityException e) {
            throw new TableNotFoundException("Cannot load google sheet by table name = " + spreadsheetName);
        }
    }

    private ValueRange getResponse(String spreadsheetName) throws IOException, GeneralSecurityException, TableNotFoundException {
        String spreadsheetId = tablesRepository.getSpreadsheetId(spreadsheetName);
        final NetHttpTransport HTTP_TRANSPORT = GoogleNetHttpTransport.newTrustedTransport();
        Sheets service = new Sheets.Builder(HTTP_TRANSPORT, JSON_FACTORY, getServiceAccountCredentials())
                .setApplicationName(APPLICATION_NAME)
                .build();
        return service.spreadsheets().values()
                .get(spreadsheetId, worksheetName)
                .execute();
    }

    private List<String> getSpreadsheetContent(String spreadsheetName) throws IOException, GeneralSecurityException, TableNotFoundException {
        List<List<Object>> values = getResponse(spreadsheetName).getValues();
        return values.stream()
                .map(Object::toString)
                .collect(Collectors.toList());
    }

    private Credential getServiceAccountCredentials() throws IOException {
        InputStream is = GoogleSheetsLoader.class
                .getResourceAsStream(SERVICE_ACCOUNT_FILE_PATH);

        Credential credential = GoogleCredential.fromStream(is)
                .createScoped(SCOPES);

        return credential;
    }
}
