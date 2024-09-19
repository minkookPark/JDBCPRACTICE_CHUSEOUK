import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DataSource {
    private DataSource(){init();}
    private static DataSource instance = null;


    private static final String DRIVER = "oracle.jdbc.driver.OracleDriver";
    private static final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
    private static final String USERNAME = "gymprj";
    private static final String PASSWORD = "a1234";
    private Connection connection = null;

    public static DataSource getInstance()
    {
        if (instance == null)
            instance = new DataSource();

        return instance;
    }

    private void init()
    {
        try
        {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USERNAME, PASSWORD);
        }
        catch (SQLException e)
        {
            e.printStackTrace();
        }
        catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        }
    }

    public Connection getConnection()
    {
        if (connection != null)
            return connection;
        else
        {
            System.out.println("connection is null");
            return null;
        }
    }

}
