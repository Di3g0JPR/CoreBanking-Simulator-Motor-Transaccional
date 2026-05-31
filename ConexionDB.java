import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionDB {
    
    // Ruta hacia tu contenedor Docker
    private static final String URL = "jdbc:mysql://localhost:3306/portfolio_db";
    private static final String USUARIO = "root";
    private static final String CLAVE = "admin"; // La clave que configuramos en Docker

    public static Connection conectar() {
        Connection conexion = null;
        try {
            // Le pedimos a Java que use el traductor (Driver) que acabas de instalar
            Class.forName("com.mysql.cj.jdbc.Driver");
            
            // Intentamos cruzar el puente hacia la base de datos
            conexion = DriverManager.getConnection(URL, USUARIO, CLAVE);
            System.out.println("✅ ¡Exito absoluto! Java y MySQL en Docker estan conectados.");
            
        } catch (ClassNotFoundException e) {
            System.out.println("❌ Error: No se encontro el archivo .jar (el Driver).");
        } catch (SQLException e) {
            System.out.println("❌ Error fatal: No se pudo conectar a la base de datos.");
            System.out.println("Detalle: " + e.getMessage());
        }
        return conexion;
    }

    public static void main(String[] args) {
        System.out.println("Iniciando prueba de conexion...");
        conectar();
    }
}