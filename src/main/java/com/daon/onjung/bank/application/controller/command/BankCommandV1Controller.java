package com.daon.onjung.bank.application.controller.command;

import com.daon.onjung.bank.application.dto.request.CreateBankRequestDto;
import com.daon.onjung.bank.application.dto.request.DepositBankRequestDto;
import com.daon.onjung.bank.application.dto.response.CreateBankResopnseDto;
import com.daon.onjung.bank.application.dto.response.DepositBankResponseDto;
import com.daon.onjung.bank.application.usecase.CreateBankUseCase;
import com.daon.onjung.bank.application.usecase.DepositBankUseCase;
import com.daon.onjung.core.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banks")
public class BankCommandV1Controller {

    private final CreateBankUseCase createBankUseCase;
    private final DepositBankUseCase depositBankUseCase;


    /**
     * 가상계좌 생성히기
     */
    @PostMapping("")
    public ResponseDto<CreateBankResopnseDto> createBank(
            @RequestBody @Valid CreateBankRequestDto requestDto) {
        return ResponseDto.created(createBankUseCase.execute(requestDto));
    }

    /**
     * 가상계좌에 입금하기
     */
    @PostMapping("/{id}/deposit")
    public ResponseDto<DepositBankResponseDto> depositBank(
            @PathVariable Long id,
            @RequestBody @Valid DepositBankRequestDto requestDto) {
        return ResponseDto.ok(depositBankUseCase.execute(id, requestDto));
    }
}
