package Util;

import java.sql.*;

public class DBUtil {

    private static Connection connection;

    private void dbConnect() {

        try{
            String url = "jdbc:mysql://localhost:3306/mydb?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                connection= DriverManager.getConnection(url, username, password);
                System.out.println("Connection to  DB succesfull");
                Statement statement= connection.createStatement();
                }
            catch(Exception  ex){
                System.out.println("Connection failed...");
                System.out.println(ex);
            }
        }
         catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void dbDisconnect() throws SQLException {
        if (connection != null && !connection.isClosed()) {
            connection.close();
        }
    }


    //select from table
    public ResultSet dbExecuteQuery(String query) throws SQLException {

        dbConnect();
        Statement statement = connection.createStatement();
        ResultSet set = statement.executeQuery(query);
        dbDisconnect();
        return set;
    }

    //update,insert,delete in table
    public  void dbUpdate(String query) throws SQLException {

        dbConnect();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);
        dbDisconnect();

    }
}

