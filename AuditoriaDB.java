import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class AuditoriaDB {

    public static void registrarOperacion(String cliente, double monto, String tipoOperacion) {
        // El bloque try-with-resources cierra la conexión automáticamente al terminar
        try (Connection conexion = ConexionDB.conectar()) {
            
            // 1. Nos aseguramos de que la tabla exista en MySQL
            Statement stmt = conexion.createStatement();
            String sqlTabla = "CREATE TABLE IF NOT EXISTS transacciones (" +
                              "id_transaccion INT AUTO_INCREMENT PRIMARY KEY, " +
                              "cliente VARCHAR(50), " +
                              "monto DOUBLE, " +
                              "tipo_operacion VARCHAR(50), " +
                              "fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.execute(sqlTabla);
            
            // 2. Preparamos el comando INSERT de forma segura (los signos ? son los espacios a rellenar)
            String sqlInsert = "INSERT INTO transacciones (cliente, monto, tipo_operacion) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sqlInsert);
            
            // 3. Rellenamos los datos de forma segura
            pstmt.setString(1, cliente);
            pstmt.setDouble(2, monto);
            pstmt.setString(3, tipoOperacion);
            
            // 4. Ejecutamos el envío a la base de datos
            pstmt.executeUpdate();
            System.out.println("💾 [SISTEMA] Transaccion guardada permanentemente en MySQL.");

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar en la base de datos: " + e.getMessage());
        }
    }
}