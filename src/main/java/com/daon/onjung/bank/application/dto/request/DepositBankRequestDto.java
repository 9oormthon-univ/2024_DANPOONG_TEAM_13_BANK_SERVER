package com.daon.onjung.bank.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record DepositBankRequestDto(
        @JsonProperty("amount")
        Integer amount,

        @JsonProperty("sender_name")
        String senderName
) {
}
