import java.sql.*;
import java.util.Scanner;

public class sqlHandler {
    static final String url = "jdbc:mysql://localhost/newton_store?serverTimezone=UTC";
    static final String username = "root";
    static final String password = "dann3Newt0n";

    static Connection conn = null;
    static Statement statement = null;
    static ResultSet rs = null;
    static ResultSetMetaData rsmd = null;
    public static String labelAs;




    public static void setSqlCreateTable(String sqlCommand) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement.executeUpdate(sqlCommand);
            rs = statement.getResultSet();


            /*
            while (rs.next()) {
                System.out.println("ID: " + rs.getString());
            }

             */
            System.out.println("Table Created...");
            rs.close();
            statement.close();
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

    public static void sqlQuery(String sqlCommand) {
        try {
            Connection conn = DriverManager.getConnection(url, username, password);
            statement = conn.createStatement();
            statement.executeQuery(sqlCommand);
            rs = statement.getResultSet();
            rsmd = rs.getMetaData();
            int columnCount = rsmd.getColumnCount();


            while (rs.next()) {
                System.out.println("\n----------");
                System.out.println(rs.getString(labelAs));
                System.out.println("----------");
                for (int i = 1; i <= columnCount; i++) {
                    String columnName = rsmd.getColumnName(i);
                    System.out.format("%s:%s\n", columnName, rs.getString(i));
                }
            }
            System.out.println("\t Query finished...");
            rs.close();
            statement.close();
        } catch(SQLException ex){
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        } finally{
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

