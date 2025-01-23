package com.icsd.serviceImpl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Service.TransactionService;
import com.icsd.model.Transaction;
import com.icsd.repo.TransactionRepository;

@Service
public class TransactionServiceImpl implements TransactionService {

    // Assuming you have a TransactionRepository to interact with the database
    @Autowired
    private TransactionRepository transactionRepository;

    public Transaction saveTransaction(Transaction transaction) {
        return transactionRepository.save(transaction);
    }
}

