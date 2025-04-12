package com.icsd.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icsd.Wallet.Model.Account;

public interface AccountRepository extends JpaRepository<Account, Integer> {}
