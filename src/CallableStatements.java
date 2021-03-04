import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public interface CallableStatements extends DatabaseConnection {

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
        } finally {
            // it is a good idea to release
            // resources in a finally{} block
            // in reverse-order of their creation
            // if they are no-longer needed
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException sqlEx) {
                } // ignore

                rs = null;
            }
            if (statement != null) {
                try {
                    statement.close();
                } catch (SQLException sqlEx) {
                } // ignore

                statement = null;
            }
        }
    }
}
