package com.codecool.solosheetql.tables;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
public class TableTest {

    Table myTable;

    @BeforeEach
    public void setup() {
        myTable = new Table();
        myTable.setName("My Table");

        List<String> headers = Arrays.asList("id", "name", "age");
        myTable.setHeaders(headers);

        List<List<String>> records = Arrays.asList(
                Arrays.asList("1", "Jarek", "33"),
                Arrays.asList("2", "Darek", "22"),
                Arrays.asList("3", "Marek", "44"),
                Arrays.asList("4", "Czarek", "11"),
                Arrays.asList("5", "Arek", "15"),
                Arrays.asList("6", "Komarek", "51")
        );
        myTable.setRecords(records);
    }

    @Test
    public void testDisplay() {
        String expected = "id , name , age\n" +
                "1 , Jarek , 33\n" +
                "2 , Darek , 22\n" +
                "3 , Marek , 44\n" +
                "4 , Czarek , 11\n" +
                "5 , Arek , 15\n" +
                "6 , Komarek , 51";

        String result = myTable.display();

        assertEquals(expected, result);
    }

    @Test
    public void testDisplayHead() {
        String expected = "id , name , age\n" +
                "1 , Jarek , 33\n" +
                "2 , Darek , 22\n" +
                "3 , Marek , 44\n" +
                "4 , Czarek , 11\n" +
                "5 , Arek , 15";

        String result = myTable.displayHead();

        assertEquals(expected, result);
    }

}