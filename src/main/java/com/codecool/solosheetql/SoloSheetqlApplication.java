package com.codecool.solosheetql;

import com.codecool.solosheetql.tables.TableLoader;
import com.codecool.solosheetql.tables.TablesController;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class SoloSheetqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloSheetqlApplication.class, args);
    }

    @Bean
    public CommandLineRunner clr(ApplicationContext ctx) {
        return args -> {
            TablesController tablesController = ctx.getBean(TablesController.class);
            System.out.println(tablesController.getTable("table"));

        };
    }

}
