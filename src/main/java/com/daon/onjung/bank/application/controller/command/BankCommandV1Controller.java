package com.daon.onjung.bank.application.controller.command;

import com.daon.onjung.bank.application.dto.request.CreateBankRequestDto;
import com.daon.onjung.bank.application.dto.response.CreateBankResopnseDto;
import com.daon.onjung.bank.application.usecase.CreateBankUseCase;
import com.daon.onjung.core.dto.ResponseDto;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/banks")
public class BankCommandV1Controller {
    private final CreateBankUseCase createBankUseCase;

    @PostMapping("")
    public ResponseDto<CreateBankResopnseDto> createBank(
            @RequestBody @Valid CreateBankRequestDto requestDto) {
        return ResponseDto.created(createBankUseCase.execute(requestDto));
    }
}
