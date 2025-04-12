package com.icsd.Wallet.service;

import java.util.List;

import com.icsd.Wallet.dto.TransactionDTO;

public interface TransactionService {
    TransactionDTO createTransaction(TransactionDTO dto);
    TransactionDTO getTransactionById(int id);
    List<TransactionDTO> getAllTransactions();
}

