package com.example.jsp_jsp_20241022.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {
    //게시물 crud

    // /board/new
    @GetMapping("new")
    public void newBoard(){


    }
}
