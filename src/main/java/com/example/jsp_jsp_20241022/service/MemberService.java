package com.example.jsp_jsp_20241022.service;

import com.example.jsp_jsp_20241022.dto.Member;
import com.example.jsp_jsp_20241022.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class MemberService {

    private final MemberMapper mapper;

    public void addMember(Member member) {
        mapper.insertMember(member);
    }

    public List<Member> list() {
        return mapper.selectAll();
    }

    public Member info(String id) {
        return mapper.selectById(id);
    }

    public boolean remove(String id, String password) {
        int cnt = mapper.deleteById(id, password);
        return cnt == 1;
    }

    public void update(Member m) {
        mapper.updateById(m);
    }
}