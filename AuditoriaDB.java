import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;

public class AuditoriaDB {

    public static void registrarOperacion(String cliente, double monto, String tipoOperacion) {
       
        try (Connection conexion = ConexionDB.conectar()) {
            
         
            Statement stmt = conexion.createStatement();
            String sqlTabla = "CREATE TABLE IF NOT EXISTS transacciones (" +
                              "id_transaccion INT AUTO_INCREMENT PRIMARY KEY, " +
                              "cliente VARCHAR(50), " +
                              "monto DOUBLE, " +
                              "tipo_operacion VARCHAR(50), " +
                              "fecha TIMESTAMP DEFAULT CURRENT_TIMESTAMP)";
            stmt.execute(sqlTabla);
            
            
            String sqlInsert = "INSERT INTO transacciones (cliente, monto, tipo_operacion) VALUES (?, ?, ?)";
            PreparedStatement pstmt = conexion.prepareStatement(sqlInsert);
            

            pstmt.setString(1, cliente);
            pstmt.setDouble(2, monto);
            pstmt.setString(3, tipoOperacion);
            
            
            pstmt.executeUpdate();
            System.out.println("💾 [SISTEMA] Transaccion guardada permanentemente en MySQL.");

        } catch (SQLException e) {
            System.out.println("❌ Error al guardar en la base de datos: " + e.getMessage());
        }
    }
}
