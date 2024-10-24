package com.org.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.org.dto.User;

public class UserDao {
	
	public void saveUser(User user) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
			PreparedStatement pstmt = con.prepareStatement("insert into user(name,age,email,password,mobile) values(?,?,?,?,?)");
			pstmt.setString(1, user.getName());
			pstmt.setInt(2, user.getAge());
			pstmt.setString(3, user.getEmail());
			pstmt.setString(4, user.getPassword());
			pstmt.setLong(5, user.getMobile());
			
			pstmt.executeUpdate();
			
			con.close();
			
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	
	public User fetchUserById(int id) {
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from user where id = "+id+"");
			if (rst.next()) {
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setEmail(rst.getString("email"));
				user.setPassword(rst.getString("password"));
				user.setMobile(rst.getLong("mobile"));
				return user;
			}
			
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null ;
	}
	
	
	
	public List<User> fetchAllUsers() {
		List<User> list = new ArrayList<User>();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from user");
			while (rst.next()) {
				User user = new User();
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setEmail(rst.getString("email"));
				user.setPassword(rst.getString("password"));
				user.setMobile(rst.getLong("mobile"));
				list.add(user);
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	
	
	public void UpdateUserById(int id,User user) {
		
		User user2 = fetchUserById(id);
		if (user2 != null) {
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
				PreparedStatement pstmt = con.prepareStatement("update user set name =?,age=?,email=?,mobile=? where id=?");
				
				pstmt.setString(1, user.getName());
				pstmt.setInt(2, user.getAge());
				pstmt.setString(3, user.getEmail());
				pstmt.setLong(4, user.getMobile());
				pstmt.setInt(5, id);
				pstmt.executeUpdate();
				
				con.close();
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	public void deleteUserById(int id) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
			PreparedStatement stmt = con.prepareStatement("delete from user where id = "+id+"");
			stmt.executeUpdate();
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	public User fetchUserByEmailAndPassword(String email, String pwd) {
		User user = new User();
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/user_management","root","hkb@12345");
			Statement stmt = con.createStatement();
			ResultSet rst = stmt.executeQuery("select * from user where email ='"+email+"' and password = '"+pwd+"'");
			if (rst.next()) {
				user.setId(rst.getInt("id"));
				user.setName(rst.getString("name"));
				user.setAge(rst.getInt("age"));
				user.setEmail(rst.getString("email"));
				user.setPassword(rst.getString("password"));
				user.setMobile(rst.getLong("mobile"));
				return user;
			}
			con.close();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
