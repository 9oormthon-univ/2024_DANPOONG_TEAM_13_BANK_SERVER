package com.daon.onjung.bank.application.usecase;

import com.daon.onjung.bank.application.dto.request.CreateBankRequestDto;
import com.daon.onjung.bank.application.dto.response.CreateBankResopnseDto;
import com.daon.onjung.core.annotation.bean.UseCase;

@UseCase
public interface CreateBankUseCase {
    CreateBankResopnseDto execute(CreateBankRequestDto requestDto);
}
