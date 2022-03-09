package com.revature.dao;

import com.revature.utility.ConnectionUtility;
import com.revature.model.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    public List<Client>getAllClients() throws SQLException {

        List<Client> clients = new ArrayList<>();

        try(Connection con = ConnectionUtility.getConnection()){
            String sql1  ="select * from clients";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            ResultSet rs = pstmt.executeQuery(); // executeQuery() is used with SELECT
            while(rs.next())
            {

                int id  =rs.getInt("id");
                String firstname =rs.getString("first_name");
                String lastname =rs.getString("last_name");
                int age = rs.getInt("age");
                clients.add(new Client(id,firstname,lastname,age));
            }

        }
        return clients;
    }
}
