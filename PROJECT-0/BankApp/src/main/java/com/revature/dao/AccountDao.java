package com.revature.dao;

import com.revature.model.Account;
import com.revature.model.Client;
import com.revature.utility.ConnectionUtility;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AccountDao {

    //get all account with clientid
    public List<Account> getAllaccounts(int clientid) throws SQLException {

        List<Account> accounts = new ArrayList<>();

        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "select * from accounts where client_id=?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, clientid);
            ResultSet rs = pstmt.executeQuery(); // executeQuery() is used with SELECT
            while (rs.next()) {

                int id = rs.getInt("id");
                String account_name = rs.getString("account_name");
                Double account_bal = rs.getDouble("account_bal");
                int client_id = rs.getInt("client_id");
                accounts.add(new Account(id, account_name, account_bal, client_id));
            }

        }
        return accounts;
    }
    //get all account with amtgt and amtls
    public List<Account> getAllaccountsWithCond(int clientid ,int amtgt,int amtls) throws SQLException {
        List<Account> accounts = new ArrayList<>();
        try (Connection con = ConnectionUtility.getConnection()) {
                String sql1="select * from accounts where client_id =? and account_bal<? and account_bal >?;";
                PreparedStatement pstmt = con.prepareStatement(sql1);
                pstmt.setInt(1, clientid);
                pstmt.setInt(2, amtls);
                pstmt.setInt(3, amtgt);
                ResultSet rs = pstmt.executeQuery();
                // executeQuery() is used with SELECT
                while (rs.next()) {

                    int id = rs.getInt("id");
                    String account_name = rs.getString("account_name");
                    Double account_bal = rs.getDouble("account_bal");
                    int client_id = rs.getInt("client_id");
                    accounts.add(new Account(id, account_name, account_bal, client_id));
                }


        return accounts;
    }
    }
    //add ACCOUNT
    public Account addAccounts(Account account) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "INSERT INTO ACCOUNTS(account_name,account_bal,client_id)VALUES(?,?,?)";

            PreparedStatement pstmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, account.getAccount_name());
            pstmt.setDouble(2, account.getAccount_bal());
            pstmt.setInt(3, account.getClient_id());

            pstmt.executeUpdate();

            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int generatedId = rs.getInt(1); // 1st column of the ResultSet

            return new Account(generatedId, account.getAccount_name(), account.getAccount_bal(), account.getClient_id());
        }
    }

    //get account with accountid and clientid
    public Account getAccountById(int client_id,int acct_id) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "select accounts.id,accounts.account_name ,accounts .account_bal ,accounts.client_id  from accounts inner join clients \n" +
                    "on accounts.client_id =clients.id  where accounts.client_id =? and accounts.id =? group by accounts.id ";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, client_id);
            pstmt.setInt(2, acct_id);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {

                int acctId = rs.getInt("id");
                String account_name = rs.getString("account_name");
                Double account_bal = rs.getDouble("account_bal");
                int clientId = rs.getInt("client_id");
                return new Account(acctId, account_name, account_bal, clientId);
            }
        }

        return null;
    }
//update account
    public Account updateAccount(int client_id ,int acct_id ,Account account) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "update accounts set account_name =?," +
                    "                        account_bal = ?," +
                    "                        client_id = ? " +
                    "                         where id =?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, account.getAccount_name());
            pstmt.setDouble(2, account.getAccount_bal());
            pstmt.setInt(3, client_id);
            pstmt.setInt(4, acct_id);


        }
        return account;
    }
    //delete account
    public boolean deleteAccounttByid(int id) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()){
            String sql1 ="delete  from accounts where id = ?";
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