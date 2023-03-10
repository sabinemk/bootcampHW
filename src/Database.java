
import java.sql.*;

public class Database {

    private static final String dbURL = "jdbc:mysql://localhost:3306";
    private static final String user = "root";
    private static final String password = "Spiegoshana";

    public static void registerUser (Connection connection, String username, String password, String name) throws SQLException {

        String sql = "INSERT INTO bankUsers (username, password, name) VALUES (?, ?, ?)";
        PreparedStatement statement = connection.prepareStatement(sql);
        statement.setString(1, username);
        statement.setString(2, password);
        statement.setString(2, name);

        int rowInserted = statement.executeUpdate();

        if (rowInserted > 0) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Sorry, something went wrong...");
        }
    }

    public static boolean logIn(Connection connection, String existingUserName, String existingPassword) throws SQLException {

        String sqlUN;
        String sqlP;
        try (Connection connection1 = DriverManager.getConnection(dbURL, user, password)) {
            sqlUN = "SELECT username FROM bankUsers WHERE username = '"+ existingUserName+ "'";
            sqlP = "SELECT password FROM bankUsers WHERE password = '"+ existingPassword+ "'";

            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sqlUN);
            ResultSet resultSetP = statement.executeQuery(sqlP);

            if(resultSet.next()){

                if (resultSetP.next()) {
                    return true;
                } else {
                    System.out.println("wrong username/password");
                }
            } else {
                System.out.println("wrong username/password");
            }


        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
