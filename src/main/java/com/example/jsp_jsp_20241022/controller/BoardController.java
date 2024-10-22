package com.example.jsp_jsp_20241022.controller;

import com.example.jsp_jsp_20241022.dto.Board;
import com.example.jsp_jsp_20241022.service.BoardService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequiredArgsConstructor
@RequestMapping("/board")
public class BoardController {

    private final BoardService service;
    //게시물 crud

    // /board/new
    @GetMapping("new")
    public void newBoard() {


    }

    @PostMapping("new")
    public String newBoard(Board board) {
        service.add(board);

        return "redirect:/board";
    }
}
