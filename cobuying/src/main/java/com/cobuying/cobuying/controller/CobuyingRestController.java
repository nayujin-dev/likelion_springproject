package com.cobuying.cobuying.controller;

import com.cobuying.cobuying.repository.Cobuying;
import com.cobuying.cobuying.repository.CobuyingRepository;
import com.cobuying.cobuying.repository.CobuyingRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController
public class CobuyingRestController {

    private final CobuyingRepository cobuyingRepository;

    @PostMapping("/api/products")
    public Cobuying createProduct(@RequestBody CobuyingRequestDto requestDto) {
        Cobuying cobuying = new Cobuying(requestDto);
        cobuyingRepository.save(cobuying);
        return cobuying;
    }
}
