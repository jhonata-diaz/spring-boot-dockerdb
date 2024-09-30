package com.ProductService.demo.checkConnection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

@Service
public class DatabaseConnectionService {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    public String checkConnection() {
        try {
            // Realiza una consulta simple para verificar la conexión.
            jdbcTemplate.execute("SELECT 1");
            return "Conexión exitosa a la base de datos";
        } catch (Exception e) {
            return "Error en la conexión a la base de datos: " + e.getMessage();
        }
    }
}
