package com.cobuying.cobuying.service;

import com.cobuying.cobuying.repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
@RequiredArgsConstructor
@Service
public class CobuyingService {
    private final CobuyingRepository cobuyingRepository;
    private final MemberRepository memberRepository;
    @Transactional
    public Cobuying save(Long id, Cobuying cobuying){
        Member member=memberRepository.findById(id).orElseThrow(()->new NullPointerException("잘못된 멤버조회"));
        cobuying.opencobuying(member);
        return cobuyingRepository.save(cobuying);
    }
}
