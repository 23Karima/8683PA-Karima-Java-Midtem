package databases;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class UnitTestConnectDB {

    public static void main(String[] args) throws Exception {
        // Database connection details
        String url = "jdbc:mysql://localhost:3306/sakila";
        String username = "your_username";
        String password = "your_password";

        // Establish the connection
        Connection connection = null;
        SharedStepsDatabase ssdb = null;

        try {
            Connection connect = DriverManager.getConnection("jdbc:mysql://localhost:3306/sakila", "root", "admin");
            ssdb = new SharedStepsDatabase(connect);

  // region ExecuteQueryReadOne ,me here I'm changing the queries because I'm used sakila DB.
            String query = "SELECT * FROM sakila.actor LIMIT 10";
            String result = ssdb.executeQueryReadOne(query);

            System.out.println(result);
            // endregion

            // region executeQueryReadAllSingleColumn
            String queryTwo = "SELECT * FROM sakila.actor LIMIT 10";
            List<String> results = ssdb.executeQueryReadAllSingleColumn(queryTwo, "last_name");

            for (String s : results) {
                System.out.println(s);
            }

            // endregion

            // region executeQueryReadAll
            String queryThree = "SELECT * FROM sakila.actor WHERE first_name LIKE 'Al%'";
            List<List<String>> data = ssdb.executeQueryReadAll(queryThree);

            if (data != null) {
                for (List<String> row : data) {
                    for (String cell : row) {
                        System.out.print(cell + "\t\t");
                    }
                    System.out.println();
                }
            }
            // endregion

            // region InsertString
            ssdb.insertString("test_insert_string", "test_string", "Testing String Insertion");
            System.out.println(ssdb.executeQueryReadAllSingleColumn("SELECT * FROM test_insert_string", 2).get(0));
            // endregion

            // region insertList
            List<Object> names = new ArrayList<>();
            names.add("Actor1");
            names.add("Actor2");

            ssdb.insertList("test_insert_list", "test_list", names);

            String queryFour = "SELECT * FROM test_insert_list";
            List<String> resultsList = ssdb.executeQueryReadAllSingleColumn(queryFour, "test_list");

            for (String s : resultsList) {
                System.out.println(s);
            }
            // endregion

            // region insertMap
            HashMap<Object, Object> map = new HashMap<>();
            map.put("Actor1", 7934);
            map.put("Actor2", 6319);

            ssdb.insertMap("test_insert_map", map);

            String queryFive = "SELECT * FROM test_insert_map";
            List<List<String>> resultsMap = ssdb.executeQueryReadAll(queryFive);

            for (List<String> row : resultsMap) {
                for (String cell : row) {
                    System.out.print(cell + "\t\t");
                }
                System.out.println();
            }
            // endregion

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Close the connection and resources
            if (ssdb != null) {
                ssdb.closeResources();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
