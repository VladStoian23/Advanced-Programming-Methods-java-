package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import Settings.Settings;
public class DatabaseConnector {
    private static Connection connection;

    public static Connection getConnection() throws SQLException
    {
        if(connection == null || connection.isClosed()){
            String url="jdbc:sqlite:D:/a4-vladthegod/src/src/Data/data.db";
            connection=DriverManager.getConnection(url);
        }
        return connection;
    }

}
