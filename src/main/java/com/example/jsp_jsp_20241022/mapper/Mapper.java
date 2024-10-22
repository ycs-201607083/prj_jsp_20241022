package com.example.jsp_jsp_20241022.mapper;

import com.example.jsp_jsp_20241022.dto.Board;
import org.apache.ibatis.annotations.Insert;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Insert("""
                INSERT INTO board
                (title, content, writer)
                VALUES (#{title}, #{content}, #{writer})
            """)
    int insert(Board board);
}
