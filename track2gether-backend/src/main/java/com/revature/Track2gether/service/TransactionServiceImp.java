package com.revature.Track2gether.service;

import com.revature.Track2gether.model.Transaction;
import com.revature.Track2gether.model.Users;
import com.revature.Track2gether.repositories.TransactionRepository;
import com.revature.Track2gether.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
@Service
public class TransactionServiceImp implements TransactionService {
    @Autowired
    private TransactionRepository transactionrepo;
    @Autowired
    private UsersRepository userrepo;

    @Override
    public Transaction addTransaction(Transaction transaction) {
        //Users a = userrepo.findOne(transaction.getUser());
        Transaction newtransaction = transactionrepo.save(transaction);
        return newtransaction;
    }

    @Override
    public List<Transaction> getAllTransaction() {
        return transactionrepo.findAll();
    }

    @Override
    public Transaction UpdateTransaction(Transaction t) {
       /* Transaction targetTrans = transactionrepo.findById(t.getId()).get();
        targetTrans.setAmount(t.getAmount());
        //targetTrans.setDate(LocalDate.now());*/
        return null;
    }

    @Override
    public void deleteTransactionById(int id) {
        Transaction targetTrans = transactionrepo.getById(id);
        transactionrepo.delete(targetTrans);

    }
}
