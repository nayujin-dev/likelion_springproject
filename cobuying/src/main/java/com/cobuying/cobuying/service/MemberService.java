package com.cobuying.cobuying.service;

import com.cobuying.cobuying.repository.Member;
import com.cobuying.cobuying.repository.MemberRepository;
import com.cobuying.cobuying.repository.MemberRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@RequiredArgsConstructor
@Service
public class MemberService {
    private final MemberRepository memberRepository;

    @Transactional
    public boolean create(MemberRequestDto requestDto){
        boolean emailDuplicate = memberRepository.existsByEmail(requestDto.getEmail());
        boolean nicknameDuplicate= memberRepository.existsByNickname(requestDto.getNickname());
        if(emailDuplicate){
            return false;
//            throw new IllegalStateException("이미 존재하는 이메일입니다");
        }
        else if(nicknameDuplicate){
            return false;
//            throw new IllegalStateException("이미 존재하는 닉네임입니다");
        }
        else{
            return true;
        }
    }

    @Transactional
    public Member login(String email, String password){
        return memberRepository.findByEmail(email)
                .filter(m->m.getPassword().equals(password))
                .orElse(null);
    }

    @Transactional
    public Member signout(Long id, String email, String password){
        return memberRepository.findById(id)
                .filter(m -> m.getEmail().equals(email)&& m.getPassword().equals(password))
                .orElse(null);
    }

}
