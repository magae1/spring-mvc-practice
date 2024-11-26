<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/26/24
  Time: 3:37 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="fmt" uri="jakarta.tags.fmt" %>
<html>
<head>
    <title>Read Board</title>
</head>
<body>
  <h2>게시글 번호</h2>
  <p>${board.bno}</p>
  <h3>제목</h3>
  <p>${board.title}</p>
  <h3>내용</h3>
  <p>${board.content}</p>
  <h3>작성자</h3>
  <p>${board.writer}</p>
  <h3>등록일</h3>
  <p><fmt:formatDate value="${board.regDate}" pattern="yy년 MM월 dd일 hh:mm:ss"/></p>
  <h4>조회수</h4>
  <p>${board.hit}</p>
  <a href="${pageContext.request.contextPath}/board/modify?bno=${board.bno}">수정하기</a>
</body>
</html>
