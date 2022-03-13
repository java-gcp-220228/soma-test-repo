package com.revature.dao;

import com.revature.utility.ConnectionUtility;
import com.revature.model.Client;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class ClientDao {
    //get all client
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
    //get client by id
    public Client getClientById(int id) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection())
        {
            String sql1 ="select * from clients where id=?";
            PreparedStatement pstmt =con.prepareStatement(sql1);
            pstmt.setInt(1,id);
            ResultSet rs =pstmt.executeQuery();
            if(rs.next()){

                String firstname =rs.getString("first_name");
                String lastname =rs.getString("last_name");
                int age = rs.getInt("age");
                return new Client(id,firstname,lastname,age);
            }
        }

      return  null;
    }
    //add client
    public Client addClient(Client client) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "INSERT INTO clients (first_name, last_name, age) VALUES (?, ?, ?)";

            PreparedStatement pstmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, client.getFirst_name());
            pstmt.setString(2, client.getLast_name());
            pstmt.setInt(3, client.getAge());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt(1); // 1st column of the ResultSet

            return new Client(generatedId, client.getFirst_name(), client.getLast_name(), client.getAge());
        }
    }
    //Update client

    public Client updateClient(String s, Client client) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()){
            String sql1 ="update clients set first_name =?," +
                    "                        last_name = ?," +
                    "                        age = ? " +
                    "                         where id =?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setString(1,client.getFirst_name());
            pstmt.setString(2,client.getLast_name());
            pstmt.setInt(3,client.getAge());
            pstmt.setInt(4,client.getId());
            pstmt.executeUpdate();
        }
        return client;
    }
    //Delete client
    public boolean deleteClientByid(int id) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()){
            String sql1 ="delete  from clients where id = ?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1,id);
            int noRecordDeleted =pstmt.executeUpdate();
            if (noRecordDeleted==1)
            {
                return true;
            }
        }
        return false;
    }
}
