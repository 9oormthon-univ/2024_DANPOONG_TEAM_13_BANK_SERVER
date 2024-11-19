package com.daon.onjung.bank.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record TransferBankRequestDto(
        @JsonProperty("target_account_number")
        String targetAccountNumber,

        @JsonProperty("amount")
        Integer amount
) {
}
