<%@ page import="java.util.List" %>
<%@ page import="com.javaee.finalproject.entity.Homework" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" isELIgnored="false" %>
<html>
  <head>
    <title>Homework Management System</title>
  </head>
  <body>

    <form action="index" method="post">
      <table align="center" width="1000">
        <tr align="center" bgcolor="#7fffd4" height="50">
          <th>作业编号</th>
          <th>作业标题</th>
          <th>作业内容</th>
          <th>发布时间</th>
          <th>点击提交</th>
        </tr>
      <%
          List<Homework> list = (List<Homework>)request.getAttribute("list");
          for(Homework homework :list){
      %>
        <tr align="center" height="200" >
          <th><input style="width:200px; height:180px; border:none; font-size: 20px; text-align: center;" readonly="readonly"
                     type="text" align="center" value="<%=homework.getId()%>" name="homework_id"></th>
          <th><input style="width:200px; height:180px; border:none; font-size: 20px; text-align: center;" readonly="readonly"
                     type="text" align="center" value="<%=homework.getTitle()%>" name="homework_title+<%=homework.getId()%>"></th>
          <th><input type="text" name="content+<%=homework.getId()%>" placeholder="请输入作业内容" style="width:200px; height:180px;" ></th>
          <th><%=homework.getCreate_time()%></th>
          <th><input type="submit" value="submit <%=homework.getId()%>" name="submit" style="width:150px; height:40px; font-size: 20px;"  ></th>
        </tr>
      <%
          }
      %>
      </table>
    </form>
  </body>
</html>
