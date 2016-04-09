<%@ page language="java" import="java.util.*,com.gaoxin.dao.*,com.gaoxin.model.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>增加学生记录</title>
	<link rel="stylesheet" type="text/css" href="styles/style.css">
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="../styles/style.css">

  </head>
  
  <body>
    <div id = "top" >
        <h1>学生信息管理系统</h1>
    </div>

    <div id = "center">
        <div class = "left">
            <ul>
                <li><a href="addStu.jsp">增加学生记录</a> </li>
                <li><a href="delStu.jsp">删除学生记录</a> </li>
                <li><a href="updateStu.jsp">修改学生记录</a> </li>
                <li><a href="showStu.jsp">查询学生记录</a> </li>
            </ul>

        </div>
        <div class = "right">
        <span>${message}</span>
            <h1>学生基本信息显示表</h1>
          <hr color="#00f">
          <form action = "../servlet/AddStuServlet" method = "post">
	          <table>
	          	<tr>
	          		<th>学号</th><th>姓名</th><th>性别</th><th>班级</th><th>出生日期</th><th>所属学院</th><th>专业方向</th>
	          	</tr>
	          			<tr>
	          				<td><input type = "text" name = "stu_id" ></td>
	          				<td><input type = "text" name = "name" ></td>
	          				<td><input type = "text" name = "gender" ></td>
	          				<td><input type = "text" name = "class_no" ></td>
	          				<td><input type = "text" name = "birthday" ></td>
	          				<td><input type = "text" name = "dept" ></td>
	          				<td><input type = "text" name = "major" ></td>
	          			</tr>
	          </table>
	          <center><input type = "submit" value = "新增学生"/></center>
      	</form>
        </div>
    </div>
  </body>
</html>
