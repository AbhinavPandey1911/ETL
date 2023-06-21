import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    static Connection conn;
    public static Connection getJdbcConnection()
    {
        try
        {
            Class.forName("com.mysql.jdbc.Driver");
            String user="root";
            String password="abhinav1234";
            String url="jdbc:mysql://localhost:3306/ETL";
            conn= DriverManager.getConnection(url,user,password);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return conn;
    }

}
