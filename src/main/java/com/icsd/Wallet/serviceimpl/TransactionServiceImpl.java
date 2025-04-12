package com.icsd.Wallet.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Wallet.Model.Account;
import com.icsd.Wallet.Model.Transaction;
import com.icsd.Wallet.Repository.AccountRepository;
import com.icsd.Wallet.Repository.TransactionRepository;
import com.icsd.Wallet.dto.TransactionDTO;
import com.icsd.Wallet.mapper.TransactionMapper;
import com.icsd.Wallet.service.TransactionService;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Autowired
    private TransactionRepository transactionRepo;

    @Autowired
    private AccountRepository accountRepo;

    
    @Override
    public TransactionDTO createTransaction(TransactionDTO dto) {
        Account fromAccount = accountRepo.findById(dto.getFromAccount())
                .orElseThrow(() -> new RuntimeException("From account not found"));

        Account toAccount = accountRepo.findById(dto.getToAccount())
                .orElseThrow(() -> new RuntimeException("To account not found"));

        double amount = dto.getAmount();

        // 1. Check balance
        if (fromAccount.getOpeningBalance() < amount) {
            throw new RuntimeException("Insufficient funds in the sender's account");
        }

        // 2. Deduct from sender
        fromAccount.setOpeningBalance(fromAccount.getOpeningBalance() - amount);

        // 3. Add to receiver
        toAccount.setOpeningBalance(toAccount.getOpeningBalance() + amount);

        // 4. Save updated account balances
        accountRepo.save(fromAccount);
        accountRepo.save(toAccount);

        // 5. Create and save transaction
        Transaction transaction = TransactionMapper.toEntity(dto, fromAccount, toAccount);
        Transaction saved = transactionRepo.save(transaction);

        return TransactionMapper.toDTO(saved);
    }

    
    public TransactionDTO getTransactionById(int id) {
        return transactionRepo.findById(id).map(TransactionMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Transaction not found"));
    }

    public List<TransactionDTO> getAllTransactions() {
        return transactionRepo.findAll().stream().map(TransactionMapper::toDTO).collect(Collectors.toList());
    }
}

