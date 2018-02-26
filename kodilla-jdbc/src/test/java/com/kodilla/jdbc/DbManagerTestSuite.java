package com.kodilla.jdbc;

import org.junit.Assert;
import org.junit.Test;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DbManagerTestSuite {
    private int countResultSet(final ResultSet resultSet) throws SQLException {
        resultSet.beforeFirst();
        int counter = 0;
        while (resultSet.next()) {
            counter++;
        }
        return counter;
    }

    private ResultSet searchForUsersWithFirstName(final String firstName) throws SQLException {
        String selectString = "select * " +
                "from users " +
                "where firstname = ?";

        PreparedStatement searchForUsers = DbManager.getInstance().getConnection().prepareStatement(selectString);
        searchForUsers.setString(1, firstName);
        return searchForUsers.executeQuery();
    }

    @Test
    public void testConnect() throws SQLException {
        //Given
        //When
        DbManager dbManager = DbManager.getInstance();
        //Then
        Assert.assertNotNull(dbManager.getConnection());
    }

    @Test
    public void testSelectUsers() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "SELECT * FROM USERS";
        try (Statement statement = dbManager.getConnection().createStatement();
        ResultSet rs = statement.executeQuery(sqlQuery)) {

            //Then
            while (rs.next()) {
                System.out.println(rs.getInt("ID") + ", " +
                        rs.getString("FIRSTNAME") + ", " +
                        rs.getString("LASTNAME"));
            }
            Assert.assertEquals(5, countResultSet(rs));
        }
    }

    @Test
    public void testSelectUsersAndPosts() throws SQLException {
        //Given
        DbManager dbManager = DbManager.getInstance();

        //When
        String sqlQuery = "select u.FIRSTNAME, u.LASTNAME\n" +
                "from users u\n" +
                "join posts p on p.USER_ID = u.ID\n" +
                "group by p.USER_ID\n" +
                "having count(p.USER_ID) > 1;";
        try (final Statement statement = dbManager.getConnection().createStatement();
             final ResultSet resultSet = statement.executeQuery(sqlQuery)) {
            //Then
            while (resultSet.next()) {
                System.out.println(resultSet.getString("FIRSTNAME") + ", " +
                        resultSet.getString("LASTNAME"));
            }
            Assert.assertEquals(2, countResultSet(resultSet));
        }
    }

    @Test
    public void testPreparedStatementsForJohn() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        ResultSet resultSet = searchForUsersWithFirstName("John");

        //then
        Assert.assertEquals(2, countResultSet(resultSet));
    }

    @Test
    public void testPreparedStatementsForThomas() throws SQLException {
        //given
        DbManager dbManager = DbManager.getInstance();

        //when
        ResultSet resultSet = searchForUsersWithFirstName("Thomas");

        //then
        Assert.assertEquals(1, countResultSet(resultSet));
    }
}
