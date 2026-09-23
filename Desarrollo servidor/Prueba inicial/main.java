import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        // Obtenemos la primera instancia de la conexión
        DatabaseConnection db1 = DatabaseConnection.getInstance();
        Connection conn1 = db1.getConnection();

        // Intentamos obtener otra "instancia"
        DatabaseConnection db2 = DatabaseConnection.getInstance();
        Connection conn2 = db2.getConnection();

        // Comprobamos si ambos apuntan exactamente al mismo objeto en memoria
        if (db1 == db2) {
            System.out.println("¡Comprobación exitosa! db1 y db2 son exactamente la misma instancia.");
        } else {
            System.out.println("Son instancias diferentes (esto no debería pasar en un Singleton).");
        }
    }
}
