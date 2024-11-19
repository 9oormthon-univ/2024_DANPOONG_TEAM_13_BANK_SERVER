package com.daon.onjung.bank.domain.service;

import com.daon.onjung.bank.domain.Bank;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    public Bank createKAKAOBank(Long eventId, String bankNumber) {
        return Bank.builder()
                .eventId(eventId)
                .bankName("KAKAO")
                .bankNumber(bankNumber)
                .build();
    }

    public Bank depositBank(Bank bank, Integer amount) {
        bank.updateBalance(bank.getBalance() + amount);
        return bank;
    }

    public Bank withdrawBank(Bank bank, Integer amount) {
        bank.updateBalance(bank.getBalance() - amount);
        return bank;
    }
}
