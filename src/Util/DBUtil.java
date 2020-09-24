package Util;

import com.sun.rowset.CachedRowSetImpl;

import java.sql.*;

public class DBUtil {

    private static Connection connection;

    private void dbConnect() {

        try{
            String url = "jdbc:mysql://localhost:3306/repair?serverTimezone=Europe/Moscow&useSSL=false";
            String username = "root";
            String password = "1234";
            Class.forName("com.mysql.cj.jdbc.Driver").getDeclaredConstructor().newInstance();
            try {
                connection= DriverManager.getConnection(url, username, password);
                System.out.println("Connection to  DB succesfull");
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

        CachedRowSetImpl cachedRowSet = null;
        Statement statement =null;
        ResultSet set = null;

        try {
            dbConnect();
            cachedRowSet = new CachedRowSetImpl();
            statement = connection.createStatement();
            set = statement.executeQuery(query);
            cachedRowSet.populate(set);
        }
        catch (SQLException e) {
            System.out.println("Problem occurred at executeQuery operation : " + e);
            throw e;
        }
        finally {
            if (set != null) {
                set.close();
            }
            if (statement != null) {
                statement.close();
            }
            dbDisconnect();
        }

        return cachedRowSet;
    }

    //update,insert,delete in table
    public  void dbUpdate(String query) throws SQLException {

        dbConnect();
        Statement statement= connection.createStatement();
        statement.executeUpdate(query);
        dbDisconnect();

    }
}

