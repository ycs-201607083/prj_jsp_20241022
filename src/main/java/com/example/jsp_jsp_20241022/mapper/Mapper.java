package com.example.jsp_jsp_20241022.mapper;

import com.example.jsp_jsp_20241022.dto.Board;
import com.example.jsp_jsp_20241022.dto.Member;
import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Insert("""
            INSERT INTO board
            (title, content, writer)
            VALUES (#{board.title}, #{board.content}, #{member.id})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "board.id")
    int insert(Board board, Member member);

    @Select("""
                SELECT *
                FROM board
                WHERE id = #{id}
            """)
    Board selectById(int id);

    @Delete("""
            DELETE FROM board
            WHERE id = #{id}
            """)
    int deleteById(int id);

    @Update("""
            UPDATE board
            SET title=#{title},
                content=#{content}
            WHERE   
                id = #{id}
            """)
    int update(Board board);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();

    @Select("""
                SELECT COUNT(id)
                FROM board
            """)
    Integer countAll();

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            LIMIT #{offset}, 10
            """)
    List<Board> selectAllPaging(Integer offset);
}
