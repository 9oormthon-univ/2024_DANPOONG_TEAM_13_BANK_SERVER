package com.daon.onjung.bank.domain.service;

import com.daon.onjung.bank.domain.Bank;
import org.springframework.stereotype.Service;

@Service
public class BankService {

    public Bank createBank(Long eventId, String bankNumber) {
        return Bank.builder()
                .eventId(eventId)
                .bankNumber(bankNumber)
                .build();

    }
}
