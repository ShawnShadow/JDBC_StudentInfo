<%@ page language="java" import="java.util.*,com.gaoxin.dao.*,com.gaoxin.model.*" pageEncoding="utf-8"%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>查询学生记录</title>
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
            <h1>学生基本信息显示表</h1>
          <hr color="#00f">
          <table>
          	<tr>
          		<th>学号</th><th>姓名</th><th>性别</th><th>班级</th><th>出生日期</th><th>所属学院</th><th>专业方向</th>
          	</tr>
          	<% Student stu = null; 
          		
          		StudentDao stuDao = new StudentDao();
          		List<Student> students = stuDao.query(); 	
          		for(int i = 0;i < students.size();i++){
          			stu = students.get(i);
          			%>
          			<tr>
          				<td><%= stu.getStu_id() %></td>
          				<td><%= stu.getName() %></td>
          				<td><%= stu.getGender() %></td>
          				<td><%= stu.getClass_no() %></td>
          				<td><%= stu.getBirthday() %></td>
          				<td><%= stu.getDept() %></td>
          				<td><%= stu.getMajor() %></td>
          			</tr>
          			
          			
          			<%          			
          		
          		
          		}
          		
          	 %>
          
          </table>

        </div>
    </div>
  </body>
</html>
