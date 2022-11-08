package com.cobuying.cobuying.repository;

import lombok.Getter;

@Getter
public class CobuyingRequestDto {
    private String title;
    private int price;
    private String design;
    private String photo;
    private String detail;
    private String account;
    private String deadline;
    private String chatlink;
}
