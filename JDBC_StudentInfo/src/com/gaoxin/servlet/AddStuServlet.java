package com.gaoxin.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.gaoxin.dao.StudentDao;
import com.gaoxin.model.Student;

public class AddStuServlet extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		response.setContentType("text/html");
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		out.println("<HTML>");
		out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		out.println("  <BODY>");
		out.print("    This is ");
		out.print(this.getClass());
		out.println(", using the GET method");
		out.println("  </BODY>");
		out.println("</HTML>");
		out.flush();
		out.close();
	}


	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");		//设置request格式为utf-8
		SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
		Student stu = new Student();
		String stu_id = request.getParameter("stu_id");
		String name = request.getParameter("name");
		String gender = request.getParameter("gender");
		String class_no = request.getParameter("class_no");
		String birthday = request.getParameter("birthday");
		String dept = request.getParameter("dept");
		String major = request.getParameter("major");
		
		stu.setStu_id(Integer.parseInt(stu_id!=""?stu_id:"1"));
		stu.setName(name);
		stu.setClass_no(Integer.parseInt(class_no!=""?stu_id:"1"));
		stu.setGender(gender);
		
		 
		try {
			stu.setBirthday(sdf.parse(birthday));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		stu.setDept(dept);
		stu.setMajor(major);

		StudentDao stuDao = new StudentDao();
		stuDao.addStudent(stu);
		request.setAttribute("message", "增加记录成功！");
		response.sendRedirect("../admin/addStu.jsp");
	}

}
