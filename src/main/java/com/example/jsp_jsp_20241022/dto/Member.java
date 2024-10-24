package com.example.jsp_jsp_20241022.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class Member {
    private String id;
    private String nickName;
    private String password;
    private String description;
    private LocalDateTime inserted;
}