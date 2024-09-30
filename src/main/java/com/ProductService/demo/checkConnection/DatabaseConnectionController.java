package com.ProductService.demo.checkConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DatabaseConnectionController {

    @Autowired
    private DatabaseConnectionService databaseConnectionService;

    @GetMapping("/check-db-connection")
    public String checkDatabaseConnection() {
        return databaseConnectionService.checkConnection();
    }
}

