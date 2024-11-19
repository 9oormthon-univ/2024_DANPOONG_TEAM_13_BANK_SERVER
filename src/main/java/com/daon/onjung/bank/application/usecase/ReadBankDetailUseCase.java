package com.daon.onjung.bank.application.usecase;

import com.daon.onjung.bank.application.dto.response.ReadBankDetailResponseDto;
import com.daon.onjung.core.annotation.bean.UseCase;

@UseCase
public interface ReadBankDetailUseCase {
    ReadBankDetailResponseDto execute(Long bankId);
}
