import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, NullPointerException {
        menu.printMenu();

        sqlHandler.labelAs = "largerTotalThen10000During2020";
        /*
        sqlHandler.sqlQuery("INSERT INTO bilhandlare.kunder (CustomerName, ContactName, Address, City, PostalCode, Country, RetailValue) " +
                "VALUES ('ICA', 'Anna Johansson', 'Kungsgatan 5', 'Stockholm', '112 77', 'Sverige', 200945.00), " +
                "('Smorrebrod International', 'Preben Bjerregaard', 'Ströget 28', 'Köpenhamn', '050 23', 'Danmark', 96567.00), " +
                "('Around the Horn', 'Gunther Beck', '120 Hanover strasse', 'Berlin', '888 42', 'Tyskland', 12745.00), " +
                "('Berglund Snabbköp', 'Gunilla Berglund', 'Berguvsvägen 8', 'Göteborg', '211 23', 'Sverige', 73545.00), " +
                "('Dans Partybuss', 'Dan Danielsson', 'Björkvägen 30', 'Stockholm', '154 52', 'Sverige', 897752.00); ");

        sqlHandler.setSqlCreateTable("CREATE TABLE kunder (CustomerID int, CustomerName varchar(255), ContactName varchar(255), Address varchar(255), City varchar(255), PostalCode varchar(255), Country varchar(255), RetailValue double);");


        sqlHandler.sqlQuery("DELETE FROM bilhandlare.kunder WHERE CustomerId > 6");

         */


        //sqlHandler.sqlQuery("SELECT * FROM bilhandlare.kunder WHERE RetailValue >1");

        //sqlHandler.sqlQuery("SELECT SUM(RetailValue) AS totalSum FROM bilhandlare.kunder WHERE CustomerId > 0"); //Gets the totalSum of RetailValue. Use value totalSum in print function.
        //sqlHandler.sqlQuery("SELECT CustomerName, Address, PostalCode AS gbAsIntials FROM bilhandlare.kunder WHERE ContactName LIKE 'G% B%';"); //Gets the Address and Postal Code for customer contacts with initials GB. Use CustomerName in print function.
        //sqlHandler.sqlQuery("SELECT kunder.CustomerName, kunder.ContactName, transaktioner.Total, transaktioner.Date AS largestTransactionDate FROM bilhandlare.transaktioner INNER JOIN kunder ON kunder.CustomerID=transaktioner.CustomerID WHERE kunder.ContactName = 'Anna Johansson';");
        //sqlHandler.sqlQuery("SELECT kunder.CustomerName, kunder.ContactName, kunder.PhoneNo, kunder.Email, transaktioner.Total, transaktioner.Date AS largerTotalThen10000During2020 FROM bilhandlare.transaktioner INNER JOIN kunder ON kunder.CustomerID=transaktioner.CustomerID WHERE Total >10000 AND year(Date) = 2020;");

    }
}
