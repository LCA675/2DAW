package org.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    private static DatabaseConnection instance;
    private Connection connection;

    private final String url = "jdbc:mariadb://localhost:3336/excusa_entrega";
    private final String user = "root";
    private final String password = "1234";

    private DatabaseConnection() {
        try {
            Class.forName("org.mariadb.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión a la base de datos establecida con éxito!");
        } catch (ClassNotFoundException e) {
            System.err.println("No se encontró el driver de MariaDB: " + e.getMessage());
        } catch (SQLException e) {
            System.err.println("No se pudo conectar a la base de datos: " + e.getMessage());
        }
    }

    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else {
            try {
                if (instance.connection == null || instance.connection.isClosed()) {
                    instance = new DatabaseConnection();
                }
            } catch (SQLException e) {
                System.err.println("Error al verificar el estado de la conexión: " + e.getMessage());
            }
        }
        return instance;
    }

    public Connection getConnection() {
        return connection;
    }
}
