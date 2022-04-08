package com.revature.Track2gether.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.service.TransactionService;
import com.revature.Track2gether.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Profile;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@Profile("prod")
@CrossOrigin(originPatterns = "*", exposedHeaders = "*", allowedHeaders = "*")
public class ProductionController {

    @Autowired
    private UserService userservice;

    @Autowired
    private TransactionService transactionservice;

    @PostMapping("/transaction")
    public ResponseEntity<?> Transaction(@RequestBody Transaction t) {
        System.out.println( t);
        Transaction transaction = transactionservice.addTransaction(t);
        return ResponseEntity.ok().body(transaction);
    }
}
