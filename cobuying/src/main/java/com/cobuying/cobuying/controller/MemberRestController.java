package com.cobuying.cobuying.controller;

import com.cobuying.cobuying.repository.Member;
import com.cobuying.cobuying.repository.MemberRepository;
import com.cobuying.cobuying.repository.MemberRequestDto;
import com.cobuying.cobuying.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor // final로 선언된 멤버 변수를 자동으로 생성합니다.
@RestController // JSON으로 데이터를 주고받음을 선언합니다.
public class MemberRestController {
    private final MemberRepository memberRepository;
    private final MemberService memberService;

    @PostMapping("/user/register")
    public String createUser(@RequestBody MemberRequestDto requestDto){
        if (memberService.create(requestDto)){
            Member member =new Member(requestDto);
            memberRepository.save(member);
            return (requestDto.getEmail());
        }else{
            System.out.println("오류");
            System.out.println(memberService.create(requestDto));
            //이러면 에러메세지가 출력되나 ? ..
            return ("오류");
        }
    }

    @GetMapping("/user/login")
    public String login(){
        return "user/login";
    }

    @PostMapping("/user/login")
    public String login(@RequestBody MemberRequestDto requestDto){
        if(memberService.login(requestDto.getEmail(),requestDto.getPassword())!=null){
            return "로그인 성공";
        }else{
            return "로그인 실패";
        }
    }
    @DeleteMapping("/user/{id}")
    public String deleteUser(@PathVariable Long id, @RequestBody MemberRequestDto requestDto ){
        if(memberService.signout(id,requestDto.getEmail(),requestDto.getPassword())!=null){
            memberRepository.deleteById(id);
            return "탈퇴 완료";
        }
        else return "오류";
    }
    @GetMapping("/admin")
    public List<Member> admin(){
        return memberRepository.findAll();
    }
}

