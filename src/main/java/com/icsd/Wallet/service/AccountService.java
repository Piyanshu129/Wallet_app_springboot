package com.icsd.Wallet.service;

import java.util.List;

import com.icsd.Wallet.dto.AccountDTO;

public interface AccountService {
    AccountDTO createAccount(AccountDTO dto);
    AccountDTO getAccountById(int id);
    List<AccountDTO> getAllAccounts();
    AccountDTO updateAccount(int id, AccountDTO dto);
    void deleteAccount(int id);
}

