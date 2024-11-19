package com.daon.onjung.bank.application.controller.query;

import com.daon.onjung.bank.application.dto.response.ReadBankDetailResponseDto;
import com.daon.onjung.bank.application.usecase.ReadBankDetailUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/bank/v1/banks")
public class BankQueryV1Controller {

    private final ReadBankDetailUseCase readBankDetailUseCase;

    /**
     * 가상계좌 상세 조회하기
     */
    @GetMapping("/{id}")
    public ReadBankDetailResponseDto readBankDetail(@PathVariable Long id) {
        return readBankDetailUseCase.execute(id);
    }
}
