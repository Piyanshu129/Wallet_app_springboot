package com.icsd.Wallet.mapper;

import com.icsd.Wallet.Model.Account;
import com.icsd.Wallet.Model.Transaction;
import com.icsd.Wallet.dto.TransactionDTO;

public class TransactionMapper {
    public static TransactionDTO toDTO(Transaction transaction) {
        return new TransactionDTO(
            transaction.getTransactionId(),
            transaction.getTransactionType(),
            transaction.getTransactionDate(),
            transaction.getAmount(),
            transaction.getDescription(),
            transaction.getFromAccount().getAccountNumber(),
            transaction.getToAccount().getAccountNumber()
        );
    }

    public static Transaction toEntity(TransactionDTO dto, Account fromAccount, Account toAccount) {
        return new Transaction(
            dto.getTransactionId(),
            dto.getTransactionType(),
            dto.getTransactionDate(),
            dto.getAmount(),
            dto.getDescription(),
            fromAccount,
            toAccount
        );
    }
}
