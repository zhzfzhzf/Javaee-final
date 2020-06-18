<%@ page import="java.util.Date" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加作业</title>
</head>
<body>
<form action="/Project_war_exploded/add_homework" method="POST">
    作业编号: <input type="text" name="id" width="20%">
    <br />
    题目: <input type="text" name="title" width="20%"/>
    <br/>
    内容: <textarea rows="10" cols="30" name="content" width="20%"></textarea>
    <br/>
    <input type="submit" value="提交" />
</form>


</body>
</html>
