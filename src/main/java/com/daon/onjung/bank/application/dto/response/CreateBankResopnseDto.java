package com.daon.onjung.bank.application.dto.response;

import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.core.dto.SelfValidating;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class CreateBankResopnseDto extends SelfValidating<CreateBankResopnseDto> {

    @JsonProperty("bank_id")
    private final Long bankId;

    @JsonProperty("bank_number")
    private final String bankNumber;

    @JsonProperty("balance")
    private final Integer balance;

    @Builder
    public CreateBankResopnseDto(Long bankId, String bankNumber, Integer balance) {
        this.bankId = bankId;
        this.bankNumber = bankNumber;
        this.balance = balance;

        this.validateSelf();
    }

    public static CreateBankResopnseDto fromEntity(Bank bank) {
        return CreateBankResopnseDto.builder()
                .bankId(bank.getId())
                .bankNumber(bank.getBankNumber())
                .balance(bank.getBalance())
                .build();
    }


}
