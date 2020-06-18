
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>添加学生</title>
</head>
<body>
<form action="/Project_war_exploded/add_student" method="POST">
    学生姓名: <input type="text" name="name">
    <br />
    学号: <input type="text" name="id" />
    <input type="submit" value="提交" />
</form>


</body>
</html>
