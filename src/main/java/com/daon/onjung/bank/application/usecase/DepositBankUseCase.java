package com.daon.onjung.bank.application.usecase;

import com.daon.onjung.bank.application.dto.request.DepositBankRequestDto;
import com.daon.onjung.bank.application.dto.response.DepositBankResponseDto;
import com.daon.onjung.core.annotation.bean.UseCase;

@UseCase
public interface DepositBankUseCase {
    DepositBankResponseDto execute(Long bankId, DepositBankRequestDto requestDto);
}
