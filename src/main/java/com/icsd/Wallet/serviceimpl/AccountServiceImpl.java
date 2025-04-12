package com.icsd.Wallet.serviceimpl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.icsd.Wallet.Model.Account;
import com.icsd.Wallet.Repository.AccountRepository;
import com.icsd.Wallet.dto.AccountDTO;
import com.icsd.Wallet.mapper.AccountMapper;
import com.icsd.Wallet.service.AccountService;

@Service
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountRepository accountRepo;

    @Override
    public AccountDTO createAccount(AccountDTO dto) {
        return AccountMapper.toDTO(accountRepo.save(AccountMapper.toEntity(dto)));
    }

    @Override
    public AccountDTO getAccountById(int id) {
        return accountRepo.findById(id).map(AccountMapper::toDTO)
                .orElseThrow(() -> new RuntimeException("Account not found with ID: " + id));
    }

    @Override
    public List<AccountDTO> getAllAccounts() {
        return accountRepo.findAll().stream().map(AccountMapper::toDTO).collect(Collectors.toList());
    }

    @Override
    public AccountDTO updateAccount(int id, AccountDTO dto) {
        Account account = AccountMapper.toEntity(dto);
        account.setAccountNumber(id);
        return AccountMapper.toDTO(accountRepo.save(account));
    }

    @Override
    public void deleteAccount(int id) {
        accountRepo.deleteById(id);
    }
}

