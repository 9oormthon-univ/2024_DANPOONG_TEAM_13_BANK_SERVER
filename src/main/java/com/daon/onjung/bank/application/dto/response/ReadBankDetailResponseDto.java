package com.daon.onjung.bank.application.dto.response;

import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.core.dto.SelfValidating;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;

public class ReadBankDetailResponseDto extends SelfValidating<ReadBankDetailResponseDto> {

    @JsonProperty("bank_id")
    private final Long bankId;

    @JsonProperty("event_id")
    private final Long eventId;

    @JsonProperty("bank_number")
    private final String bankNumber;

    @JsonProperty("balance")
    private final Integer balance;

    @Builder
    public ReadBankDetailResponseDto (Long bankId, Long eventId, String bankNumber, Integer balance) {
        this.bankId = bankId;
        this.eventId = eventId;
        this.bankNumber = bankNumber;
        this.balance = balance;

        this.validateSelf();
    }

    public static ReadBankDetailResponseDto fromEntity(Bank bank) {
        if (bank == null) {
            return ReadBankDetailResponseDto.builder()
                    .bankId(null)
                    .eventId(null)
                    .bankNumber(null)
                    .balance(null)
                    .build();
        }
        return ReadBankDetailResponseDto.builder()
                .bankId(bank.getId())
                .eventId(bank.getEventId())
                .bankNumber(bank.getBankNumber())
                .balance(bank.getBalance())
                .build();
    }
}
