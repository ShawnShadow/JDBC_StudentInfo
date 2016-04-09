package com.gaoxin.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.PseudoColumnUsage;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gaoxin.db.DButil;
import com.gaoxin.model.Student;


public class StudentDao {		//Data Access Object
	
	DButil dButil = new DButil();
	Connection conn = dButil.getConnection();
	
	public void addStudent(Student stu){
		
		
		PreparedStatement ps = null;
		String sql = ""
				+ "insert into stu_table"
				+ "(stu_id,name,gender,class_no,dept,major,birthday)"
				+ "values("
				+ "?,?,?,?,?,?,?)";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getStu_id());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getGender());
			ps.setInt(4, stu.getClass_no());
			ps.setString(5, stu.getDept());
			ps.setString(6, stu.getMajor());
			ps.setDate(7, new Date(stu.getBirthday().getTime()));
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	
	public void delStudent(int id){
		Connection conn = dButil.getConnection();
		PreparedStatement ps = null;
		String sql = "delete from stu_table"
				+ " where stu_id = ?";
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	public void updateStudent(Student stu,Integer id){
		PreparedStatement ps = null;
		String sql = ""
				+ "update stu_table"
				+ " set stu_id=?,name=?,gender=?,class_no=?,dept=?,major=?,birthday=?"
				+ " where stu_id=?";
		
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, stu.getStu_id());
			ps.setString(2, stu.getName());
			ps.setString(3, stu.getGender());
			ps.setInt(4, stu.getClass_no());
			ps.setString(5, stu.getDept());
			ps.setString(6, stu.getMajor());
			ps.setDate(7, new Date(stu.getBirthday().getTime()));
			ps.setInt(8, id);
			ps.execute();
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				ps.close();
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
		}
	}
	public List<Student> query(){
		Statement stmt = null;
		List<Student> students = new ArrayList<Student>();
		Student student = null;
		ResultSet rs = null;
		try {
			stmt = conn.createStatement();
			rs = stmt.executeQuery("select * from stu_table;");
			while(rs.next()){
				student = new Student();
				student.setStu_id(rs.getInt("stu_id"));
				student.setName(rs.getString("name"));
				student.setGender(rs.getString("gender"));
				student.setClass_no(rs.getInt("class_no"));
				student.setDept(rs.getString("dept"));
				student.setMajor(rs.getString("major"));
				student.setBirthday(rs.getDate("birthday"));
				students.add(student);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}finally{
			try{
				stmt.close();
				conn.close();
			}catch (Exception e){
				e.printStackTrace();
			}
			
		}
		
	
		return students;
		
		
	}
}
