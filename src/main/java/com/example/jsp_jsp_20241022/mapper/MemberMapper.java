package com.example.jsp_jsp_20241022.mapper;

import com.example.jsp_jsp_20241022.dto.Member;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface MemberMapper {

    @Insert("""
                INSERT INTO member
                (id, password, nick_name, description)
                VALUES (#{id}, #{password}, #{nickName}, #{description})
            """)
    int insertMember(Member member);

    @Select("""
                SELECT *
                FROM member
                ORDER BY id DESC
            """)
    List<Member> selectAll();

    @Select("""
                SELECT * FROM member
                WHERE id = #{id}
            """)
    Member selectById(String id);

    @Delete("""
                DELETE FROM member
                WHERE id = #{id} AND password = #{password}
            """)
    int deleteByIdAndPassword(String id, String password);

    @Update("""
            UPDATE member
            SET nick_name = #{nickName},
                description = #{description}
            WHERE id = #{id}
            """)
    int update(Member member);

    @Update("""
            UPDATE member
            SET password = #{newPassword}
            WHERE id = #{id}
              AND password = #{oldPassword}
            """)
    int updatePassword(String id, String oldPassword, String newPassword);

    @Select("""
            SELECT *
            FROM member
            WHERE id = #{id}
              AND password = #{password}
            """)
    Member selectByIdAndPassword(String id, String password);

    @Select("""
            SELECT name
            FROM auth
            WHERE id = #{id}
            """)
    List<String> selectAuthById(String id);

    @Delete("""
                DELETE FROM board
                WHERE writer = #{memberId}
            """)
    int deleteByMemberId(String memberId);
}
