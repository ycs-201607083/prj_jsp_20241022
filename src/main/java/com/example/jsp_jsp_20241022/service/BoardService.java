package com.example.jsp_jsp_20241022.service;

import com.example.jsp_jsp_20241022.dto.Board;
import com.example.jsp_jsp_20241022.dto.Member;
import com.example.jsp_jsp_20241022.mapper.Mapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
@RequiredArgsConstructor
public class BoardService {
    private final Mapper mapper;

    public void add(Board board, Member member) {
        mapper.insert(board, member);
    }


    public Map<String, Object> list(Integer page) {
        // 한 페이지에 10개

        Integer offset = (page - 1) * 10;

//        List<Board> list = mapper.selectAll();
        List<Board> list = mapper.selectAllPaging(offset);

        // Controller에게 넘겨 줄 정보들을 담을 map
        Map<String, Object> map = new HashMap<>();

        // 페이지 관련 정보들
        Integer countAll = mapper.countAll();
        Integer lastPageNumber = (countAll - 1) / 10 + 1; // 마지막 페이지 번호
        Integer rightPageNumber = ((page - 1) / 10 + 1) * 10; // 현재페이지 기준 오른쪽 끝 페이지 번호
        Integer leftPageNumber = rightPageNumber - 9;// 현재페이지 기준 왼쪽 끝 페이지 번호
        Integer nextPageNumber = rightPageNumber + 1;     //다음 버튼 클릭 시 이동하는 페이지
        Integer prevPageNumber = leftPageNumber - 1;        //이전 페이지 버튼 클릭 시 이동하는 페이지

        Boolean hasNextPage = nextPageNumber < lastPageNumber;      //다음 버튼 유무
        Boolean hasPrevPage = prevPageNumber > 0;       //이전 버튼 유무

        //오른쪽 끝페이지는 마지막 페이지 보다 클 수 없음
        rightPageNumber = Math.min(rightPageNumber, lastPageNumber);

        Map<String, Object> pageInfo = new HashMap<>();

        pageInfo.put("hasNextPage", hasNextPage);
        pageInfo.put("hasPrevPage", hasPrevPage);
        pageInfo.put("nextPageNumber", nextPageNumber);
        pageInfo.put("prevPageNumber", prevPageNumber);
        pageInfo.put("leftPageNumber", leftPageNumber);
        pageInfo.put("rightPageNumber", rightPageNumber);
        pageInfo.put("lastPageNumber", lastPageNumber);
        pageInfo.put("currentPageNumber", page);

        map.put("pageInfo", pageInfo);
        map.put("boardList", list);

        return map;
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
