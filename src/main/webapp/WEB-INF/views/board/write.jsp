<%--
  Created by IntelliJ IDEA.
  User: jeongjung-il
  Date: 11/26/24
  Time: 3:50 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Board write</title>
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
  <form class="form" action="${pageContext.request.contextPath}/board/write" method="post">
    <label>
      <span>제목</span>
      <input class="form-input" id="board-title" name="title" />
    </label>
    <label>
      <span>내용</span>
      <input class="form-input" id="board-content" name="content" />
    </label>
    <label>
      <span>작성자</span>
      <input class="form-input" id="board-writer" name="writer" />
    </label>
    <input type="submit" value="등록하기"/>
  </form>
</body>
</html>
