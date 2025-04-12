package com.icsd.Wallet.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.icsd.Wallet.Model.Transaction;

public interface TransactionRepository extends JpaRepository<Transaction, Integer> {}
