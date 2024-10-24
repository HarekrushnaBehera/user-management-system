package com.org.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.org.dao.UserDao;
import com.org.dto.User;

@WebServlet("/update_profile")
public class UpdateServlet extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		long mob = Long.parseLong(req.getParameter("mobile"));
		int id = Integer.parseInt(req.getParameter("id"));
		
		User user = new User();
		user.setName(name);
		user.setAge(age);
		user.setEmail(email);
		user.setMobile(mob);
		
		UserDao dao = new UserDao();
		dao.UpdateUserById(id, user);
		
		HttpSession session = req.getSession();
		session.setAttribute("info", "Updated Successfully");
		
		res.sendRedirect("home.jsp");
	}
}
