package com.cobuying.cobuying.controller;

import com.cobuying.cobuying.repository.*;
import com.cobuying.cobuying.service.CobuyingService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final 로 선언된 클래스를 자동으로 생성합니다.
@RestController
public class CobuyingRestController {

    private final MemberRepository memberRepository;
    private final CobuyingService cobuyingService;
    private final CobuyingRepository cobuyingRepository;
    @PostMapping("/cobuying/{id}")
    public Cobuying createProduct(@PathVariable Long id, @RequestBody CobuyingRequestDto requestDto) {
        Cobuying cobuying = new Cobuying(requestDto);
//        cobuying.opencobuying(cobuyingService.opener(id));
        Cobuying a= cobuyingRepository.save(cobuying);
        return cobuyingService.save(id,a);
    }
    @GetMapping("/cobuying/all")
    public List<Cobuying> getProducts(){ return cobuyingRepository.findAll();}
    @PostMapping("/cobuying")
    public Cobuying createProduct(@RequestBody CobuyingRequestDto requestDto){
        return new Cobuying(requestDto);
    }
    @GetMapping("/cobuying/{id}")
    public Optional<Member> getwhois(@PathVariable Long id){
        return memberRepository.findById(id);
    }
}
