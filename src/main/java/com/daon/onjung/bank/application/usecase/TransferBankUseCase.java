package com.daon.onjung.bank.application.usecase;

import com.daon.onjung.bank.application.dto.request.TransferBankRequestDto;
import com.daon.onjung.bank.application.dto.response.TransferBankResponseDto;
import com.daon.onjung.core.annotation.bean.UseCase;

@UseCase
public interface TransferBankUseCase {
    TransferBankResponseDto execute(Long bankId, TransferBankRequestDto requestDto);
}
