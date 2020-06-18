<%@ page import="java.util.List" %>
<%@ page import="com.javaee.finalproject.entity.StudentHomework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Homework check</title>

</head>
<body>
    <form method="post">
        <table align="center" width="1000">
            <tr align="center" bgcolor="#7fffd4" height="50">
                <th>学生编号</th>
                <th>作业编号</th>
                <th>作业标题</th>
                <th>作业内容</th>
                <th>提交时间</th>
            </tr>
            <%
                List<StudentHomework> list = (List<StudentHomework>)request.getAttribute("homework_list");
                for(StudentHomework homework: list){
            %>
            <tr align="center" height="100" >
                <th><%=homework.getStudentId()%></th>
                <th><%=homework.getHomeworkId()%></th>
                <th><%=homework.getHomeworkTitle()%></th>
                <th><%=homework.getHomeworkContent()%></th>
                <th><%=homework.getTime()%></th>
            </tr>
            <%
                }
            %>
        </table>
    </form>
</body>
</html>
