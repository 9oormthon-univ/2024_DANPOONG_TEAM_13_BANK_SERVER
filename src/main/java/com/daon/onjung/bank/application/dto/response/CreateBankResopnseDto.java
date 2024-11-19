package com.daon.onjung.bank.application.dto.response;

import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.core.dto.SelfValidating;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class CreateBankResopnseDto extends SelfValidating<CreateBankResopnseDto> {

    @JsonProperty("bank_id")
    private final Long bankId;

    @JsonProperty("bank_name")
    private final String bankName;

    @JsonProperty("bank_number")
    private final String bankNumber;

    @JsonProperty("balance")
    private final Integer balance;

    @Builder
    public CreateBankResopnseDto(Long bankId, String bankName, String bankNumber, Integer balance) {
        this.bankId = bankId;
        this.bankName = bankName;
        this.bankNumber = bankNumber;
        this.balance = balance;

        this.validateSelf();
    }

    public static CreateBankResopnseDto fromEntity(Bank bank) {
        return CreateBankResopnseDto.builder()
                .bankId(bank.getId())
                .bankName(bank.getBankName())
                .bankNumber(bank.getBankNumber())
                .balance(bank.getBalance())
                .build();
    }


}
