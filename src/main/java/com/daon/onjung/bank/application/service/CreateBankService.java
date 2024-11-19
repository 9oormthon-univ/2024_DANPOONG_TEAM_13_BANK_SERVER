package com.daon.onjung.bank.application.service;

import com.daon.onjung.bank.application.dto.request.CreateBankRequestDto;
import com.daon.onjung.bank.application.dto.response.CreateBankResopnseDto;
import com.daon.onjung.bank.application.usecase.CreateBankUseCase;
import com.daon.onjung.bank.domain.Bank;
import com.daon.onjung.bank.domain.service.BankService;
import com.daon.onjung.bank.repository.mysql.BankRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Random;

@Service
@RequiredArgsConstructor
public class CreateBankService implements CreateBankUseCase {

    private final BankRepository bankRepository;
    private final BankService bankService;

    @Override
    @Transactional
    public CreateBankResopnseDto execute(CreateBankRequestDto requestDto) {
        // 3333 (카카오뱅크 예시)로 시작하는 10자리 랜덤 숫자 생성
        Random random = new Random();
        StringBuilder accountNumber = new StringBuilder();
        accountNumber.append("3333");
        for (int i = 0; i < 10; i++) {
            accountNumber.append(random.nextInt(10));  // 0부터 9 사이의 랜덤 숫자 추가
        }

        // Bank 생성
        Bank bank = bankService.createKAKAOBank(requestDto.eventId(), accountNumber.toString());
        bankRepository.save(bank);

        return CreateBankResopnseDto.fromEntity(bank);
    }
}
