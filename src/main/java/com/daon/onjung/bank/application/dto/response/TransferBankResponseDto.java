package com.daon.onjung.bank.application.dto.response;

import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.core.dto.SelfValidating;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class TransferBankResponseDto extends SelfValidating<TransferBankResponseDto> {
    @JsonProperty("bank_id")
    private final Long bankId;

    @JsonProperty("balance")
    private final Integer balance;

    @Builder
    public TransferBankResponseDto(Long bankId, Integer balance) {
        this.bankId = bankId;
        this.balance = balance;

        this.validateSelf();
    }

    public static TransferBankResponseDto fromEntity(Bank bank) {
        return TransferBankResponseDto.builder()
                .bankId(bank.getId())
                .balance(bank.getBalance())
                .build();
    }
}
