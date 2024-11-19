package com.daon.onjung.bank.application.dto.request;

import com.fasterxml.jackson.annotation.JsonProperty;

public record CreateBankRequestDto(
        @JsonProperty("event_id")
        Long eventId,

        @JsonProperty("bank_name")
        String bankName
) {
}
