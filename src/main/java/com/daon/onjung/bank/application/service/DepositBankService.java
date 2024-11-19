package com.daon.onjung.bank.application.service;

import com.daon.onjung.bank.application.dto.request.DepositBankRequestDto;
import com.daon.onjung.bank.application.dto.response.DepositBankResponseDto;
import com.daon.onjung.bank.application.usecase.DepositBankUseCase;
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
public class DepositBankService implements DepositBankUseCase {

    private final BankRepository bankRepository;
    private final BankService bankService;

    @Override
    @Transactional
    public DepositBankResponseDto execute(Long bankId, DepositBankRequestDto requestDto) {

        // Bank 조회
        Bank bank = bankRepository.findById(bankId)
                .orElseThrow(() -> new CommonException(ErrorCode.NOT_FOUND_RESOURCE));

        // Bank에 amount만큼 입금
        bank = bankService.depositBank(bank, requestDto.amount());
        bankRepository.save(bank);

        return DepositBankResponseDto.fromEntity(bank);
    }
}
