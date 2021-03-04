import java.sql.*;

public interface DatabaseConnection {

    static final String url = "jdbc:mysql://localhost/newton_store?serverTimezone=UTC";
    static final String username = "root";
    static final String password = "dann3Newt0n";

    static Connection conn = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static ResultSetMetaData rsmd = null;
    public static String labelAs;

    protected static void connect(){
        Connection conn = DriverManager.getConnection(url, username, password);
    }
}
