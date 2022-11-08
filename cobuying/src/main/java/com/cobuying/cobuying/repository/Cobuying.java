package com.cobuying.cobuying.repository;


import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Getter // get 함수를 일괄적으로 만들어줍니다.
@NoArgsConstructor // 기본 생성자를 만들어줍니다.
@Entity // DB 테이블 역할을 합니다.
public class Cobuying{

    // ID가 자동으로 생성 및 증가합니다.
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Id
    private Long id;

    // 반드시 값을 가지도록 합니다.
    @Column(nullable = false)
    private String title;

    @Column(nullable = false)
    private int price;

    @Column(nullable = false)
    private String photo;


    @Column(nullable = false)
    private String design;


    @Column(nullable = false)
    private String detail;

    @Column(nullable = false)
    private String deadline;

    @Column(nullable = false)
    private String account;

    @Column(nullable = false)
    private String chatlink;


    // 관심 상품 생성 시 이용합니다.
    public Cobuying(CobuyingRequestDto requestDto) {
        this.title = requestDto.getTitle();
        this.price = requestDto.getPrice();
        this.design=requestDto.getDesign();
        this.photo = requestDto.getPhoto();
        this.detail= requestDto.getDetail();
        this.deadline= requestDto.getDeadline();
        this.account= requestDto.getAccount();
        this.chatlink= requestDto.getChatlink();
    }

}