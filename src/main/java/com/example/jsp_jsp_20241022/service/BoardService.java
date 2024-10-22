package com.example.jsp_jsp_20241022.service;

import com.example.jsp_jsp_20241022.dto.Board;
import com.example.jsp_jsp_20241022.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final Mapper mapper;

    public void add(Board board) {
        mapper.insert(board);
    }


    public List<Board> list() {
//        List<Board> list = mapper.selectAll();
//        return list;
        return mapper.selectAll();
    }
}
