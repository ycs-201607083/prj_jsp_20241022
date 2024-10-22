package com.example.jsp_jsp_20241022.mapper;

import com.example.jsp_jsp_20241022.dto.Board;
import org.apache.ibatis.annotations.*;

import java.util.List;

@org.apache.ibatis.annotations.Mapper
public interface Mapper {

    @Insert("""
            INSERT INTO board
            (title, content, writer)
            VALUES (#{title}, #{content}, #{writer})
            """)
    @Options(useGeneratedKeys = true, keyProperty = "id")
    int insert(Board board);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            """)
    List<Board> selectAll();

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
                        SET
                        title=#{title}, content=#{content}, writer=#{writer}
                        WHERE id = #{id}
            """)
    int editById(Board b);

    @Select("""
            SELECT *
            FROM board
            ORDER BY id DESC
            LIMIT #{offset}, 10
            """)
    List<Board> selectAllPaging(Integer offset);
}
