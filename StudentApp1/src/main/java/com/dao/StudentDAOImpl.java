package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.model.Student;
import com.util.DBUtility;

public class StudentDAOImpl implements StudentDAO {
	@Override
	public int saveStudent(Student student) {
		int rows = 0;
		String sql = "insert into student values (?,?,?)";

		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, student.getId());
			ps.setString(2, student.getName());
			ps.setFloat(3, student.getMarks());
			rows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("ADD STUDENT " + e.getMessage());
		}

		return rows;
	}

	@Override
	public int deleteStudent(int id) {
		int rows = 0;
		String sql = "delete from student where id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);

			rows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("DELETE STUDENT" + e.getMessage());
		}
		return rows;
	}

	@Override
	public int updateStudent(Student student) {
		int rows = 0;
		String sql = "update student set name=?,marks=? where id=?";
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(3, student.getId());

			ps.setString(1, student.getName());
			ps.setFloat(2, student.getMarks());

			rows = ps.executeUpdate();
		} catch (Exception e) {
			System.err.println("UPDATE STUDENT" + e.getMessage());
		}
		return rows;
	}

	@Override
	public List<Student> getAllStudent() {
		String sql = "select * from Student";
		List<Student> list = new ArrayList<Student>();
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ResultSet rs = ps.executeQuery();

			while (rs.next()) {
				int id = rs.getInt("id");
				String name = rs.getString("name");
				float marks = rs.getFloat("marks");

				list.add(new Student(id, name, marks));
			}
		} catch (Exception e) {
			System.err.println("GET ALL STUDENT" + e.getMessage());
		}
		return list;
	}

	@Override
	public Student findStudentById(int id) {
		String sql = "select * from Student where id=?";
		Student student = null;
		try (Connection con = DBUtility.getInstance().getDBConnection();
				PreparedStatement ps = con.prepareStatement(sql)) {
			ps.setInt(1, id);

			ResultSet rs = ps.executeQuery();
			while (rs.next()) {
				student = new Student(rs.getInt("id"), rs.getString("name"), rs.getFloat("marks"));
			}
		} catch (Exception e) {
			System.err.println("FIND STUDENT BY ID" + e.getMessage());
		}
		return student;
	}

}
