package connexion;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbConnect {

    
    // private String mySqlUrl = "jdbc:mysql://localhost:3306/exam_web_dynamique";
    // private String mySqlUsername = "root";
    // private String mySqlPassword = "";

    private String mySqlUrl = "jdbc:mysql://localhost:3306/db_s2_ETU003087";
    private String mySqlUsername = "ETU003087";
    private String mySqlPassword = "jbCdWS3h";
    public Connection connection = null;

    public void openConnetion() throws SQLException{
        this.connection = null;
        try {
            this.connection = DriverManager.getConnection(mySqlUrl, mySqlUsername, mySqlPassword);
        } catch (SQLException e) {
            throw new SQLException("Erreur de connexion :"+e.getMessage());
        }
    }
    public Connection getConnection() throws SQLException {
        return this.connection;
    }
    public void closeConnetion() throws SQLException{
        try {
            if (this.connection == null) {
                return;
            }
            connection.close();
        } catch (Exception e) {
            throw new SQLException("Erreur de fermeture de connexion :"+e.getMessage());
        }
    }
}