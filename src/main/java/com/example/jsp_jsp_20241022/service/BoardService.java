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


    public List<Board> list(Integer page) {
//        List<Board> list = mapper.selectAll();
//        return list;

        Integer offset = (page - 1) * 10;
        List<Board> list = mapper.selectAllPaging(offset);
        return list;
    }

    public Board get(int id) {
        return mapper.selectById(id);
    }

    public void remove(int id) {
        mapper.deleteById(id);
    }

    public void update(Board b) {
        mapper.editById(b);
    }
}
