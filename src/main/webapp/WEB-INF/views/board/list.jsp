<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/26/24
  Time: 3:25 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="jakarta.tags.core" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Board List</title>
</head>
<body>
    <table>
        <tr>
            <th>게시글 번호</th>
            <th>제목</th>
            <th>내용</th>
            <th>작성자</th>
            <th>등록일</th>
            <th>조회수</th>
            <th>삭제</th>
        </tr>
        <c:forEach items="${bList}" var="item">
            <tr>
                <td><a href="${pageContext.request.contextPath}/board/read?bno=${item.bno}">${item.bno}</a></td>
                <td>${item.title}</td>
                <td>${item.content}</td>
                <td>${item.writer}</td>
                <td><fmt:formatDate value="${item.regDate}" pattern="yy-MM-dd hh:mm:ss"/></td>
                <td>${item.hit}</td>
                <td>
                    <form action="${pageContext.request.contextPath}/board/remove?bno=${item.bno}" method="post">
                        <button type="submit">삭제하기</button>
                    </form>
                </td>
            </tr>
        </c:forEach>
    </table>
    <a href="${pageContext.request.contextPath}/board/write">새 게시글 작성하러 가기</a>
</body>
</html>
