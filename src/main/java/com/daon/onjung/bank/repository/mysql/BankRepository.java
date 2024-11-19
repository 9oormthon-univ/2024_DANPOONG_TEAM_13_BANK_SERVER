package com.daon.onjung.bank.repository.mysql;

import com.daon.onjung.bank.domain.Bank;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BankRepository extends JpaRepository<Bank, Long> {
}
