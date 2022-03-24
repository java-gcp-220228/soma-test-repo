package com.revature.dao;

import com.revature.dto.ReimburseDTO;
import com.revature.model.Reimbursement;
import com.revature.model.User;
import com.revature.utility.ConnectionUtility;

import java.sql.*;

public class ReimbursementDao {

    public Reimbursement addReimbursement(int userId, ReimburseDTO rdto) throws SQLException {
        try(Connection con = ConnectionUtility.getConnection()) {
            con.setAutoCommit(false);
          int sId = getStatusId("PENDING");
          int typeId =getType(rdto.getReimb_type());
          Long datetime = System.currentTimeMillis();
          Timestamp curdate = new Timestamp(datetime);
          String sql1="insert into  ERS_REIMB (REIMB_AMOUNT,REIMB_SUBMITTED,REIMB_DESC,REIMB_AUTHOR,REIMB_STATUS_ID,REIMB_TYPE_ID)\n" +
                  "VALUES(?,?,?,?,?,?)";
            PreparedStatement pstmt = con.prepareStatement(sql1, Statement.RETURN_GENERATED_KEYS);
            pstmt.setInt(1,rdto.getReimb_amount());
            pstmt.setTimestamp(2,curdate);
            pstmt.setString(3,rdto.getReimb_desc());
            pstmt.setInt(4,userId);
            pstmt.setInt(5,sId);
            pstmt.setInt(6,typeId);
            pstmt.executeUpdate();
            ResultSet rs = pstmt.getGeneratedKeys();
            rs.next();
            int remb_id = rs.getInt(1);
            User user =getUser(userId);
            String status="PENDING";
            Reimbursement reimbursement =new Reimbursement(remb_id,rdto.getReimb_amount(),curdate.toString(),rdto.getReimb_desc(),rdto.getReimb_type(),status,user);
            return  reimbursement;
        }
    }
    /*-----------get user-------------------------*/
    public User getUser (int userId) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "select ers_users.id ,ers_users.user_firstname ,ers_users.user_lastname ,ers_users.user_email ,ers_user_roles.user_role \n" +
                    "from  ers_users  inner join  ers_user_roles  on ers_users.user_role_id =ers_user_roles.id where ers_users.id =?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setInt(1, userId);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int usrid =rs.getInt("id");
            String firstname = rs.getString("user_firstname");
            String lastname = rs.getString("user_lastname");
            String email = rs.getString("user_email");
            String userrole=rs.getString("user_role");
            User user= new User(usrid,firstname,lastname,email,userrole);
            return user;

        }
    }


    /*-----------get statusid-------------------------*/
    public int getStatusId (String reimb_status) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {
            String sql1 = "select id from ers_reimb_status ers where REIMB_STATUS=?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, reimb_status);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int sId = rs.getInt("id");
            return sId;

        }
    }
    /*-----------get Typeid-------------------------*/
    public int getType (String reimb_Type) throws SQLException {
        try (Connection con = ConnectionUtility.getConnection()) {

            String sql1 = "select * from ers_reimb_type  where REIMB_TYPE=?";
            PreparedStatement pstmt = con.prepareStatement(sql1);
            pstmt.setString(1, reimb_Type);

            ResultSet rs = pstmt.executeQuery();
            rs.next();
            int typeId = rs.getInt("id");
            return typeId;

        }
    }
        /*-----------get Username-------------------------*/
        public String userCheck(int sId) throws SQLException {
            try (Connection con = ConnectionUtility.getConnection()) {

                String sql1 = "select * from ers_users  where id=?";
                PreparedStatement pstmt = con.prepareStatement(sql1);
                pstmt.setInt(1, sId);

                ResultSet rs = pstmt.executeQuery();
                rs.next();
                String username = rs.getString("user_firstname");
                return username;

            }
    }




}
