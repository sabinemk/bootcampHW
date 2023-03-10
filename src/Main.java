
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        String dbURL = "jdbc:mysql://localhost:3306/java34";
        String username = "root";
        String password = "Spiegoshana";
        Scanner scanner = new Scanner(System.in);
        char again = 'y';

        try (Connection connection = DriverManager.getConnection(dbURL, username, password)) {
            System.out.println("Welcome to the SL bank!");


            while (again == 'y') {
                System.out.println("Press '1' to register or '2' to log in");

                String action = scanner.nextLine().toLowerCase().trim();


                String existingUserName;
                if (action == "1") {
                    System.out.println("Enter a new username");
                    String newUserName = scanner.nextLine();

                    System.out.println("Enter a new password");
                    String newPassword = scanner.nextLine();

                    System.out.println("Enter your full name");
                    String newFullName = scanner.nextLine();

                    Database.registerUser(connection, newUserName, newPassword, newFullName);

                } else if (action == "2") {

                    System.out.println("Please, input your username");

                    existingUserName = scanner.nextLine();

                    System.out.println("please, input your password");
                    String existingPassword = scanner.nextLine();

                    Database.logIn(connection, existingUserName,existingPassword);


                    if(Database.logIn(connection, existingUserName, existingPassword)) {
                        System.out.println("You have successfully logged in \n What would you like to do?");

                        try {

                        } catch (IndexOutOfBoundsException e) {
                            System.out.println("invalid input, please, try again");
                        }

                        menu();







                    }else {
                        System.out.println("Not an existing user");
                    }
                } else {
                    System.out.println("Not an existing user");
                }
            }

        } catch (SQLException ex) {
            throw new RuntimeException(ex);
        }





    }

    private static void menu() {
        System.out.println("Press 1 to view user information");
        System.out.println("Press 2 to view current balance");
        System.out.println("Press 3 to debit your account");
        System.out.println("Press 3 to credit your account");
        System.out.println("Press 5 to delete your account");
    }
}

/**
 * Main task: Write a program for a bank where:
 *
 *     Users can register,
 *     User class should have basic information like account number, balance, name, gender etc.
 *     Bank class should be able to accept a single user at a time, and have methods to credit and debit the user as well as show the user balance.
 *     Should be a method to replace existing users with new one in the bank.
 *
 * All classes should be used from main classAdd any other functionality you feel should be included :slightly_smiling_face:
 */