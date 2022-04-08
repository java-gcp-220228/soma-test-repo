package com.revature.Track2gether.service;

import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;

import java.util.List;

public interface TransactionService {
    public Transaction addTransaction(Transaction transaction);

    public List<Transaction> getAllTransaction();

    public Transaction UpdateTransaction(Transaction transaction);

    public void deleteTransactionById(int id);
}
