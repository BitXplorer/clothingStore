import java.sql.*;

public interface DatabaseConnection {

    String url = "jdbc:mysql://localhost/newton_store?serverTimezone=UTC";
    String username = "root";
    String password = "dann3Newt0n";

    Connection conn = null;
     Statement statement = null;
     ResultSet rs = null;
     ResultSetMetaData rsmd = null;
    String labelAs = "";

    static void connect() throws SQLException {
        Connection conn = DriverManager.getConnection(url, username, password);
    }

    static void createOrder (Integer cust_id, Integer paymentMethod, Integer product, Integer amount) {

        var sql = "{CALL create_order (?, ?, ?, ?)}";
        try (CallableStatement cs = conn.prepareCall(sql)) {
            //DatabaseConnection.connect();
            /*
            statement = conn.createStatement();
            statement.execute(sql);
            rs = statement.getResultSet();
             */

            cs.setInt(1, cust_id);
            cs.setInt(2, paymentMethod);
            cs.setInt(3, product);
            cs.setInt(4, amount);

            System.out.println("Order created!");

        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }
    }
}

