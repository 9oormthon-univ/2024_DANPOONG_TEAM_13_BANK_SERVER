package com.daon.onjung.bank.application.service;

import com.daon.onjung.bank.application.dto.request.TransferBankRequestDto;
import com.daon.onjung.bank.application.dto.response.TransferBankResponseDto;
import com.daon.onjung.bank.application.usecase.TransferBankUseCase;
import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.bank.domain.service.BankService;
import com.daon.onjung.bank.repository.mysql.BankRepository;
import com.daon.onjung.core.exception.error.ErrorCode;
import com.daon.onjung.core.exception.type.CommonException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class TransferBankService implements TransferBankUseCase {
    private final BankRepository bankRepository;
    private final BankService bankService;

    @Override
    @Transactional
    public TransferBankResponseDto execute(Long bankId, TransferBankRequestDto requestDto) {
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_RESOURCE));

        bank = bankService.withdrawBank(bank, requestDto.amount());
        bankRepository.save(bank);

        return TransferBankResponseDto.fromEntity(bank);
    }
}
