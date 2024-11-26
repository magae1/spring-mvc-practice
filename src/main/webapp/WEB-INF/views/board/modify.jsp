<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/26/24
  Time: 4:08 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Board modify</title>
  <style>
    .form {
      display: flex;
      flex-direction: column;
      gap: 5px;
      width: 360px;
    }
    .form-input {
      width: 100%;
    }
  </style>
</head>
<body>
<form class="form" action="${pageContext.request.contextPath}/board/modify" method="post">
  <input hidden name="bno" value="${board.bno}" />
  <label>
    <span>제목</span>
    <input class="form-input" id="board-title" name="title" value="${board.title}" />
  </label>
  <label>
    <span>내용</span>
    <input class="form-input" id="board-content" name="content" value="${board.content}" />
  </label>
  <label>
    <span>작성자</span>
    <input class="form-input" id="board-writer" name="writer" value="${board.writer}" />
  </label>
  <input type="submit" value="수정하기"/>
</form>
</body>
</html>


