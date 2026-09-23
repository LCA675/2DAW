import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnection {

    // 1. Variable estática privada que almacena la única instancia de la clase
    private static DatabaseConnection instance;
    
    // Objeto Connection de Java SQL
    private Connection connection;

    // Datos de configuración de la base de datos (ejemplo con MySQL)
    private final String url = "jdbc:mysql://localhost:3306/tu_base_de_datos";
    private final String user = "root";
    private final String password = "tu_password";

    // 2. Constructor privado para evitar que se creen objetos con 'new'
    private DatabaseConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            this.connection = DriverManager.getConnection(url, user, password);
            System.out.println("¡Conexión a la base de datos establecida con éxito!");
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Error al conectar a la base de datos: " + e.getMessage());
        }
    }

    // 3. Método público estático para obtener la única instancia disponible
    public static synchronized DatabaseConnection getInstance() {
        if (instance == null) {
            instance = new DatabaseConnection();
        } else {
            try {
                // Si la conexión se cerró por alguna razón, la reconectamos
                if (instance.connection == null || instance.connection.isClosed()) {
                    instance = new DatabaseConnection();
                }
            } catch (SQLException e) {
                System.err.println("Error al verificar el estado de la conexión: " + e.getMessage());
            }
        }
        return instance;
    }

    // Método para obtener el objeto Connection y hacer consultas
    public Connection getConnection() {
        return connection;
    }
}
