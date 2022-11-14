package com.cobuying.cobuying.repository;

import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@NoArgsConstructor // 기본생성자를 만듭니다.
@Getter
@Entity // 테이블과 연계됨을 스프링에게 알려줍니다.
public class Member {
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    @Column(name = "mid")
    private Long id;

    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String nickname;

    public Member(MemberRequestDto requestDto){
        this.email=requestDto.getEmail();
        this.password=requestDto.getPassword();
        this.nickname= requestDto.getNickname();
        this.id=requestDto.getId();
    }
}
