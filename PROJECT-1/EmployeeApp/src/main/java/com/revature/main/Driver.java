package com.revature.main;

import com.revature.utility.ConnectionUtility;

import java.sql.SQLException;

public class Driver {
    public static void main(String[] args) throws SQLException {
        System.out.println(ConnectionUtility.getConnection());

    }
}
