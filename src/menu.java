import java.sql.CallableStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class menu {

    public static int getInt() {
        int value = -1;
        Scanner in = new Scanner(System.in);
        System.out.print("Enter a number: ");

        if (in.hasNextInt()) { // If input is a valid Integer
            value = in.nextInt();
        }
        else{ // Else input is not an Integer, error message
            System.out.println("Input is not an Integer.");
        }
        return value;
    }

    public static void printMenu() throws SQLException {
        System.out.println("Welcome, please choose one of the options: " +
                "\n 1. Create order." +
                "\n 2. View order." +
                "\n 3. Create transaction." +
                "\n 4. View Transaction.");

        int input = getInt();

        if (input > 5 || input < 1) { // If input is not a valid Int
            System.out.println("Enter a Integer between 1-4: ");
            printMenu();
        }

        if (input == 1) {
            System.out.println("1. Create order.\n");
            System.out.println("Choose customer ID: ");
            int cust_id = getInt();
            System.out.println("Choose payment method: " +
                    "\n 1. Card" +
                    "\n 2. Swish" +
                    "\n 3. Invoice" +
                    "\n 4. Points ");
            int paymentMethod = getInt();
            System.out.println("Choose product ID: ");
            int product = getInt();
            System.out.println("Choose product amount: ");
            int amount = getInt();
            DatabaseConnection.createOrder(cust_id, paymentMethod, product,amount);

        } else if (input == 2) {
            System.out.println("2. View order.\n");


        } else if (input == 3) {
            System.out.println("3. Create transaction.\n");


        } else if (input == 4) {
            System.out.println("4. View Transaction. \n");


        }


    }
}
