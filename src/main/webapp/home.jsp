<%@page import="java.text.CollationKey"%>
<%@page import="com.org.dto.User"%>
<%@page import="java.util.List"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Home</title>
<%@ include file="components/bootstrapCss.jsp"%>
<style type="text/css">
.paint-card {
	box-shadow: 0 0 10px 0 rgba(0, 0, 0, 0.3)
}
th,td {
	text-align: center;
}
</style>
</head>
<body>
	<%
	User user = (User) session.getAttribute("userObj");
	if (user == null) {
		response.sendRedirect("login.jsp");
	} else {
	%>
	<%@ include file="components/user_navbar.jsp"%>
	<h1 class="text-center text-success">Welcome to home page</h1>
	<%
	UserDao dao = new UserDao();
	List<User> alluser = dao.fetchAllUsers();
	%>
	<div class="container-fluid p-3">
		<div class="row">
			<div class="col-md-12">
				<div class="card paint-card">
					<div class="card-body">
						<p class=" fw-bold fs-4 text-center text-secondary">User Details</p>
						<%  String inf = (String)session.getAttribute("info");
							if(inf != null) { %>
								<p class="fs-4 text-center text-success"><%= inf %></p>
							<% session.removeAttribute("info"); 
							} %>
						<table class="table">
							<thead>
								<tr>
									<th>Name</th>
									<th>Age</th>
									<th>Email</th>
									<th>Mobile No</th>
									<th>Action</th>
								</tr>
							</thead>
							<tbody>
								<%
								for (User users : alluser) {
									if(users.getId() == user.getId())
										continue;
								%>
								<tr>
									<td><%=users.getName()%></td>
									<td><%=users.getAge()%></td>
									<td><%=users.getEmail()%></td>
									<td><%=users.getMobile()%></td>
									<td><a class="btn btn-primary btn-md mx-2" href="profile.jsp?id=<%= users.getId() %>">Update</a> 
										<a class="btn btn-md btn-danger" href="delete.jsp?id=<%= users.getId() %>">Delete</a></td>
								</tr>
								<%
								}
								%>
							</tbody>
						</table>
					</div>
				</div>
			</div>
		</div>
	</div>
	<%
	}
							
	%>
</body>
</html>