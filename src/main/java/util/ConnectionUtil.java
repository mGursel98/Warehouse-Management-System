package util;

import java.sql.*;

public class ConnectionUtil {


    private static final String DATABASE_URL = "jdbc:mysql://localhost:3306/skladove";
    private static final String DATABASE_USERNAME = "root";
    private static final String DATABASE_PASSWORD = "hazard";
    private static final String SELECT_QUERY = "SELECT * FROM potrebitel WHERE username = ? and password = ?";

    public static String USERTYPE;
    public static String ID_POTREBITEL;
    public static String FIRSTNAME_POTREBITEL;
    public static String LASTNAME_POTREBITEL;
    public static String PASSWORD;
    public static String POTREBITEL_USERNAME;

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(DATABASE_URL, DATABASE_USERNAME, DATABASE_PASSWORD);
    }


    public static boolean validate(String User_name, String password) throws SQLException, ClassNotFoundException {
        Class.forName("com.mysql.cj.jdbc.Driver");

        try (Connection connection = getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_QUERY);) {
            preparedStatement.setString(1, User_name);
            preparedStatement.setString(2, password);



            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                ID_POTREBITEL = resultSet.getString("id");
                FIRSTNAME_POTREBITEL = resultSet.getString("FirstName");
                LASTNAME_POTREBITEL = resultSet.getString("LastName");
                POTREBITEL_USERNAME = resultSet.getString("username");
                USERTYPE = resultSet.getString("usertype");
                PASSWORD = resultSet.getString("password");

                if (POTREBITEL_USERNAME.equals(User_name) && PASSWORD.equals(password)) {
                    return true;
                } else {
                    return false;
                }
            }

        } catch (SQLException e) {

            printSQLException(e);
        }
        return false;
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

}
