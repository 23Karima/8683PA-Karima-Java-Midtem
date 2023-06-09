package databases;

import java.io.*;
import java.sql.*;
import java.util.*;

/**
 * A class to establish a connection to local or remote JDBC and provide methods to interact with that connection.
 * The object can be used to execute queries, retrieve query results and various other methods
 *
 * Database configurations are set in the `secret.properties` file
 *
 * @author Sami Sheikh
 */
public class SharedStepsDatabase {

    private static Properties prop;
    public static Connection connect = null;

    public SharedStepsDatabase(Connection connect) {
        this.connect = connect;
    }
    public static Statement statement = null;
    public static PreparedStatement ps = null;
    public static ResultSet resultSet = null;
    static String systemPath = System.getProperty("user.dir");
    static String propPath = File.separator + "src" + File.separator + "secret.properties";
    private static final File file = new File(systemPath + propPath);

    public SharedStepsDatabase() {

        prop = loadProperties();

        if (prop != null) {
            String driverClass = prop.getProperty("MYSQLJDBC.driver");
            String host = prop.getProperty("MYSQLJDBC.host");
            String user = prop.getProperty("MYSQLJDBC.userName");
            String password = prop.getProperty("MYSQLJDBC.password");

            try {
                Class.forName(driverClass);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }

            try {
                connect = DriverManager.getConnection(host, user, password);
                System.out.println("CONNECTED TO DATABASE!");
            } catch (SQLException sql) {
                System.out.println("\nUNABLE TO ESTABLISH CONNECTION TO DATABASE:\n" + sql.getMessage() + "\n");
            }
        } else {
            System.out.println("UNABLE TO LOAD PROPERTIES FILE");
        }
    }

    private static Properties loadProperties() {
        prop = new Properties();

        try (InputStream ism = new FileInputStream(file)) {
            prop.load(ism);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println("FILE IS NOT AVAILABLE AT: " + systemPath + propPath);
            fileNotFoundException.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return prop;
    }

    /**
     * Submits and executes a database query and returns the resultSet
     * @param query The SQL query to be executed
     * @return The resultSet
     */
    private ResultSet executeQuery(String query) {
        try {
            statement = connect.createStatement();
            resultSet = statement.executeQuery(query);
        } catch (SQLException sql) {
            System.out.println("UNABLE TO RETRIEVE RESULTS FROM QUERY: " + query);
            System.out.println(sql.getMessage());
        }

        return resultSet;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & returns the first cell in the first row in the first column
     *
     * @param query The query to be executed
     * @return Single cell value resulting from the query's execution
     */
    public String executeQueryReadOne(String query) throws SQLException {
        String result = null;
        resultSet = executeQuery(query);

        if (resultSet.next()) {
            result = resultSet.getString(1);
        }

        return result;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the entire resultSet and returns a List containing each row of data as a list.
     * (The inner lists represent each row of data)
     *
     * @return Entire result set as a List<List<String>>
     */
    public List<List<String>> executeQueryReadAll(String query) throws SQLException {
        resultSet = executeQuery(query);
        ResultSetMetaData metaData = resultSet.getMetaData();
        int columnCount = metaData.getColumnCount();

        List<List<String>> data = new ArrayList<>();

        while (resultSet.next()) {
            List<String> row = new ArrayList<>();

            for (int i = 1; i <= columnCount; i++) {
                row.add(resultSet.getString(i));
            }
            data.add(row);
        }

        return data;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the resultSet specified by column name and returns a List containing each cell
     * value in that column
     *
     * @param query The query to be executed
     * @param columnName Identifies the column to read data_structures.data from
     * @return All cell values within the specified column, resulting from the query's execution
     */
    public List<String> executeQueryReadAllSingleColumn(String query, String columnName) throws SQLException {
        resultSet = executeQuery(query);
        List<String> dataList = new ArrayList<>();
        String item;

        while (resultSet.next()) {
            item = resultSet.getString(columnName);
            dataList.add(item);
        }

        return dataList;
    }

    /**
     * @throws SQLException
     *
     * Executes a query, reads & parses the resultSet specified by column number and returns a List containing each cell
     * value in that column.
     *
     * Database columns start at 1
     *
     * @param query The query to be executed
     * @param columnNumber Identifies the column to read data_structures.data from (e.g. - 1 = 1st column, 2 = 2nd column...)
     * @return All cell values within the specified column, resulting from the query's execution
     */
    public List<String> executeQueryReadAllSingleColumn(String query, int columnNumber) throws Exception {
        resultSet = executeQuery(query);
        List<String> dataList = new ArrayList<>();
        String item;

        while (resultSet.next()) {
            item = resultSet.getString(columnNumber);
            dataList.add(item);
        }

        return dataList;
    }

    /**
     * Inserts a String to a database table
     *
     * @param tableName Name of the table
     * @param columnName Name of the column
     * @param string The String to be inserted
     */
    public void insertString(String tableName, String columnName, String string) {
        dropTable(tableName);
        createTableSingleColumn(tableName, columnName, false);

        try {
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setString(1, string);
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * @throws SQLException
     *
     * Inserts an int[] array to a database table
     *
     * @param tableName Name of the table
     * @param columnName Name of the column
     * @param array The array to be inserted
     */
    public void insertIntegerArray(String tableName, String columnName, int[] array) throws SQLException {
        dropTable(tableName);
        createTableSingleColumn(tableName, columnName, true);

        for (int i : array) {
            ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
            ps.setInt(1, i);
            ps.executeUpdate();
        }
    }

    /**
     * Inserts a list of Strings to a database table in a specified column
     *
     * @param tableName Name of the table
     * @param columnName Name of the column
     * @param list The list to be inserted
     */
    public void insertList(String tableName, String columnName, List<Object> list) {
        dropTable(tableName);
        boolean isNumericalData = false;

        if (list.get(0) instanceof Integer) {
            isNumericalData = true;
        }
        createTableSingleColumn(tableName, columnName, isNumericalData);

        try {
            for (Object obj : list) {
                ps = connect.prepareStatement("INSERT INTO " + tableName + " ( " + columnName + " ) VALUES(?)");
                ps.setObject(1, obj);
                ps.executeUpdate();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Inserts a map to a database table
     *
     * @param tableName Name of the table
     * @param map The map to be inserted
     */
    public void insertMap(String tableName, Map<Object, Object> map) {
        try {
            ps = connect.prepareStatement("DROP TABLE IF EXISTS " + tableName + ";");
            ps.executeUpdate();
            ps = connect.prepareStatement("CREATE TABLE " + tableName + " (`key` VARCHAR(45) DEFAULT 1 NOT NULL, `value` VARCHAR(45) NULL);");
            ps.executeUpdate();

            StringBuilder sql = new StringBuilder("INSERT INTO ").append(tableName).append(" (`key`, `value`)").append(" VALUES (");

            for (Object key : map.keySet()) {
                sql.append("'").append(key).append("', '").append(map.get(key)).append("'), (");
            }
            String sqlString = sql.toString();
            sqlString = sqlString.substring(0, sqlString.length() - 3);;

            ps = connect.prepareStatement(sqlString);
            ps.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    private void dropTable(String tableName) {
        try {
            ps = connect.prepareStatement("DROP TABLE IF EXISTS `" + tableName + "`;");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    private void createTableSingleColumn(String tableName, String columnName, boolean areIntegerValues) {
        String cellDataType;

        if (areIntegerValues) {
            cellDataType = "bigint(20)";
        } else {
            cellDataType = "VARCHAR(45)";
        }

        try {
            ps = connect.prepareStatement("CREATE TABLE `" + tableName + "` (`ID` int(11) NOT NULL AUTO_INCREMENT,`"
                    + columnName + "` " + cellDataType + " DEFAULT NULL,  PRIMARY KEY (`ID`) );");
            ps.executeUpdate();
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    /**
     * Closes all static resources
     */

    public void closeResources() {
        try {
            if (resultSet != null) {
                resultSet.close();
            }
            if (statement != null) {
                statement.close();
            }
            if (connect != null) {
                connect.close();
            }
        } catch (SQLException sql) {
            System.out.println("UNABLE TO CLOSE RESOURCES");
            System.out.println(sql.getMessage());
        }
    }
}
