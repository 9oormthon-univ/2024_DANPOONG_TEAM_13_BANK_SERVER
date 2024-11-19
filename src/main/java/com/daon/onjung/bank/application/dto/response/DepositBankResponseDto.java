package com.daon.onjung.bank.application.dto.response;

import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.core.dto.SelfValidating;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class DepositBankResponseDto extends SelfValidating<DepositBankResponseDto> {
    @JsonProperty("bank_id")
    private final Long bankId;

    @JsonProperty("balance")
    private final Integer balance;

    @Builder
    public DepositBankResponseDto(Long bankId, Integer balance) {
        this.bankId = bankId;
        this.balance = balance;

        this.validateSelf();
    }

    public static DepositBankResponseDto fromEntity(Bank bank) {
        return DepositBankResponseDto.builder()
                .bankId(bank.getId())
                .balance(bank.getBalance())
                .build();
    }
}
