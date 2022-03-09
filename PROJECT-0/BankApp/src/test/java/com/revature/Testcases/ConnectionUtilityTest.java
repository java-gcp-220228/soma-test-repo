package com.revature.Testcases;

import com.revature.utility.ConnectionUtility;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class ConnectionUtilityTest {
    @Test
    public void test_getConnection() throws SQLException, SQLException {
        ConnectionUtility.getConnection();

    }
}


