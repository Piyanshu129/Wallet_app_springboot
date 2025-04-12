package com.icsd.Wallet.mapper;

import com.icsd.Wallet.Model.Account;
import com.icsd.Wallet.dto.AccountDTO;

public class AccountMapper {
    public static AccountDTO toDTO(Account account) {
        return new AccountDTO(
            account.getAccountNumber(),
            account.getCustomerId(),
            account.getAccountType(),
            account.getOpeningBalance(),
            account.getDescription(),
            account.getOpeningDate()
        );
    }

    public static Account toEntity(AccountDTO dto) {
        return new Account(
            dto.getAccountNumber(),
            dto.getCustomerId(),
            dto.getAccountType(),
            dto.getOpeningBalance(),
            dto.getDescription(),
            dto.getOpeningDate()
        );
    }
}

