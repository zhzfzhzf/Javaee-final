
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="teacher_add_student" method="post" class="form">
        <table align="center" width="1000">
            <tr align="center" height="100">
                <th>姓名</th>
                <th>学号</th>
                <th>提交</th>
            </tr>
            <tr align="center" height="50">
                <th><input type="text" name="name" style="height: 40px; width: 250px; "></th>
                <th><input type="text" name="age" style="height: 40px; width: 250px;"></th>
                <th><input type="submit" value="提交" class="submit" style="height: 40px; width: 200px;"></th>
            </tr>
        </table>
    </form>
</body>
</html>
