package data_structures;

import databases.SharedStepsDatabase;

import java.io.*;
import java.sql.*;
import java.util.*;

public class UseMap {

    /** INSTRUCTIONS
     *
     * Implement code to demonstrate how to interact with a database connection, using a Map
     * You must insert the map into a table, and then you must submit & execute a query to retrieve
     * all the submitted data (retrieval does not need to be stored as a map - you can use any data structure)
     *
     * Use For-Each loop and While-loop with Iterator to retrieve data.
     */

    public static void main(String[] args) throws Exception {

        HashMap<Object, Object> map = new HashMap<>();
        map.put(8454, "lamia");
        map.put(4567, "azar");
        map.put(7898, "rahim");

        // Retrieving "Keys" & "Values" using an Iterator
        Iterator<Object> mapIter = map.keySet().iterator();
        Object key;
        while (mapIter.hasNext()) {
            key = mapIter.next();
            System.out.println("KEY: " + key);
            System.out.println("VALUE: " + map.get(key));
        }

        String tableName = "`test_hash_map`";
        SharedStepsDatabase sql = new SharedStepsDatabase();
        sql.insertData(tableName, map);
        //sql.retrieveData(tableName);
    }

    static class SharedStepsDatabase {
        private String url = "jdbc:mysql://localhost/midterm_java?serverTimezone=UTC&useSSL=false";
        private String username = "root";
        private String password = "AydenLiam1213$";
        private Connection connection=null;

        public void insertData(String tableName, HashMap<Object, Object> map) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                String insertQuery = "INSERT INTO " + tableName + " (key_column, value_column) VALUES (8454, \"lamia\")";
                PreparedStatement statement = connection.prepareStatement(insertQuery);

                for (Map.Entry<Object, Object> entry : map.entrySet()) {
                    Object key = entry.getKey();
                    Object value = entry.getValue();
                    statement.setObject(1, key);
                    statement.setObject(2, value);
                    statement.executeUpdate();
                }

                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        public void retrieveData(String tableName) {
            try {
                connection = DriverManager.getConnection(url, username, password);
                String selectQuery = "SELECT * FROM " + tableName;
                Statement statement = connection.createStatement();
                ResultSet resultSet = statement.executeQuery(selectQuery);

                while (resultSet.next()) {
                    Object key = resultSet.getObject("key_column");
                    Object value = resultSet.getObject("value_column");
                    System.out.println("KEY: " + key);
                    System.out.println("VALUE: " + value);
                }

                resultSet.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}