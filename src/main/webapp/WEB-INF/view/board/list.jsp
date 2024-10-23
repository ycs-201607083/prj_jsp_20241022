<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .active {
            background-color: yellowgreen;
        }
    </style>
</head>
<body>

<c:import url="/WEB-INF/fragment/navbar.jsp"/>

<h2>게시물 목록</h2>
<table>
    <thead>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>작성자</th>
        <th>작성일시</th>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${boardList}" var="board">
        <tr>
            <td>${board.id}</td>
            <td>
                <a href="/board/view?id=${board.id}">
                        ${board.title}
                </a>
            </td>
            <td>${board.writer}</td>
            <td>${board.inserted}</td>
        </tr>
    </c:forEach>

    </tbody>
</table>

<%--    pagination --%>
<div>
    <%--이전버튼--%>
    <c:if test="${pageInfo.hasPrevPage}">
        <a href="/board/list?page=${pageInfo.prevPageNumber}">이전</a>
    </c:if>
    <c:forEach begin="${pageInfo.leftPageNumber}" end="${pageInfo.rightPageNumber}" var="pageNumber">
        <a class="${pageInfo.currentPageNumber == pageNumber ? 'active' : ''}"/>
        <a href="/board/list?page=${pageNumber}">${pageNumber}</a>
    </c:forEach>
    <%--다음버튼--%>
    <c:if test="${pageInfo.hasNextPage}">
        <a href="/board/list?page=${pageInfo.nextPageNumber}">다음</a>
    </c:if>
</div>
</body>
</html>