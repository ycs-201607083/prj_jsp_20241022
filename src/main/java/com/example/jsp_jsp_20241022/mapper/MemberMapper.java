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
    int deleteById(String id, String password);

    @Update("""
                        UPDATE member
                        SET
                        id=#{id}, nick_name=#{nickName}, password=#{password} description=#{description}
                        WHERE id = #{id}
            """)
    void updateById(Member m);
}
