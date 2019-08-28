package com.codecool.solosheetql;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SoloSheetqlApplication {

    public static void main(String[] args) {
        SpringApplication.run(SoloSheetqlApplication.class, args);
    }

//    @Bean
//    public CommandLineRunner clr(ApplicationContext ctx) {
//        return args -> {
//            TablesController tablesController = ctx.getBean(TablesController.class);
//            System.out.println(tablesController.getTable("table").display());
//
//        };
//    }

}
