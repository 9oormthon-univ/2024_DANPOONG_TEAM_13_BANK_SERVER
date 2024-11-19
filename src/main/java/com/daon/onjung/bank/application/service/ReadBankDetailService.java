package com.daon.onjung.bank.application.service;

import com.daon.onjung.bank.application.dto.response.ReadBankDetailResponseDto;
import com.daon.onjung.bank.application.usecase.ReadBankDetailUseCase;
import com.daon.onjung.bank.repository.mysql.BankRepository;
import com.daon.onjung.core.exception.error.ErrorCode;
import com.daon.onjung.core.exception.type.CommonException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ReadBankDetailService implements ReadBankDetailUseCase {

    private final BankRepository bankRepository;

    @Override
    public ReadBankDetailResponseDto execute(Long bankId) {
        return bankRepository.findById(bankId)
                .map(ReadBankDetailResponseDto::fromEntity)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_RESOURCE));
    }
}
