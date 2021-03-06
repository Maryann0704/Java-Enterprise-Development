package by.pvt.service;

import org.dbunit.DBTestCase;
import org.dbunit.PropertiesBasedJdbcDatabaseTester;
import org.dbunit.dataset.IDataSet;
import org.dbunit.dataset.xml.FlatXmlDataSetBuilder;
import org.dbunit.operation.DatabaseOperation;
import org.junit.Test;
import java.sql.*;

public class HelloMysqlTest extends DBTestCase{

    public HelloMysqlTest() {
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_DRIVER_CLASS
                , "com.mysql.jdbc.Driver" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_CONNECTION_URL
                , "jdbc:mysql://localhost:3306/hello_mysql_junit" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_USERNAME
                , "root" );
        System.setProperty(
                PropertiesBasedJdbcDatabaseTester.DBUNIT_PASSWORD
                , "root" );
    }

    @Override
    protected IDataSet getDataSet() throws Exception {
        return new FlatXmlDataSetBuilder().build(
                HelloMysqlTest.class.getResourceAsStream("system_users.xml"));
    }

    @Override
    protected DatabaseOperation getTearDownOperation() throws Exception {
        return DatabaseOperation.DELETE;
    }

    @Test
    public void testConnection() {

        try (
                Connection connection =
                        DriverManager.getConnection(
                                "jdbc:mysql://localhost:3306/hello_mysql_junit"
                                ,"root"
                                ,"root");

                PreparedStatement ps = connection.prepareStatement("select * from system_users");
                ResultSet resultSet = ps.executeQuery()
         ){
            assertNotNull(resultSet);

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
