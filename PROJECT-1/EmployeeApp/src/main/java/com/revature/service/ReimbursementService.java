package com.revature.service;

import com.revature.dao.ReimbursementDao;
import com.revature.dto.ReimburseDTO;
import com.revature.dto.ResponseRemDTO;
import com.revature.model.Reimbursement;

import java.sql.SQLException;

public class ReimbursementService {
    private ReimbursementDao reimbursementDao;
    public ReimbursementService() {
        this.reimbursementDao = new ReimbursementDao();
    }
    public ResponseRemDTO addReimbursement(int userId, ReimburseDTO rdto) throws SQLException {

        Reimbursement reimbursementAdded = this.reimbursementDao.addReimbursement(userId, rdto);

        return new ResponseRemDTO(reimbursementAdded.getId(), reimbursementAdded.getReimb_amount(),
                                reimbursementAdded.getReimb_date(),reimbursementAdded.getReimb_desc(),
                                reimbursementAdded.getReimb_type(), reimbursementAdded.getReimb_status(),
                                reimbursementAdded.getReimb_author().getFirstName(),reimbursementAdded.getReimb_author().getLastName(),
                              reimbursementAdded.getReimb_author().getEmail(),reimbursementAdded.getReimb_author().getUserRole());
    }


    }

