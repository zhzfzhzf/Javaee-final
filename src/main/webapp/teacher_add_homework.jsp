
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework</title>

</head>
<body>
    <form action="teacher_add_homework" method="post" class="form">
        <table align="center" width="800" >
            <tr align="center" height="100">
                <th style="width: 100px; height: 50px;">作业标题</th>
                <th><input type="text" name="title" placeholder="请输入作业标题" style="width: 650px; height: 100px;"></th>
            </tr>
            <tr align="center" height="60">
                <th></th>
                <th><input type="submit" value="提交" style="width: 650px; height: 60px;"></th>
            </tr>
        </table>
    </form>
</body>
</html>
