package com.codecool.solosheetql.http_controller;

import com.codecool.solosheetql.runner.QueryRunner;
import com.codecool.solosheetql.tables.Table;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/query")
public class QueryController {

    private QueryRunner queryRunner;

    @Autowired
    public QueryController(QueryRunner queryRunner) {
        this.queryRunner = queryRunner;
    }

    @PostMapping
    public ResponseEntity<Table> runQuery(@RequestBody Query query){
        return new ResponseEntity<>(queryRunner.getResultTableFromQuery(query.getText()), HttpStatus.OK);
    }
}
