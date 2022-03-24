package com.revature.controller;

import com.revature.dto.ReimburseDTO;
import com.revature.dto.ResponseRemDTO;
import com.revature.service.JWTService;
import com.revature.service.ReimbursementService;
import io.javalin.Javalin;
import io.javalin.http.Handler;


public class ReimbursementController implements Controller {
    private JWTService jwtservice;
    private ReimbursementService reimbursementservice;

    public ReimbursementController() {
        this.jwtservice =new JWTService();
        this.reimbursementservice =new ReimbursementService();
    }

    private Handler addReimbursement=(ctx)->{
        int userid= Integer.parseInt(ctx.pathParam("user_id"));
        ReimburseDTO rdto= ctx.bodyAsClass(ReimburseDTO.class);
        ResponseRemDTO getDto =this.reimbursementservice.addReimbursement(userid,rdto);
        ctx.status(201);
        ctx.json(getDto);

    };

    @Override
    public void mapEndpoints(Javalin app) {
        app.post("/users/{user_id}/reimbursement", addReimbursement); // specific user
    }
}
