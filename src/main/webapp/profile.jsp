<%@page import="com.org.dto.User"%>
<%@page import="com.org.dao.UserDao"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Profile</title>
<%@ include file="components/bootstrapCss.jsp"%>
</head>
<body>
	<%@ include file="components/user_navbar.jsp"%>
	<%
	int id = Integer.parseInt(request.getParameter("id"));
	UserDao dao = new UserDao();
	User user = dao.fetchUserById(id);
	%>	
	<div class="container p-4">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="shadow p-3 mb-5 bg-body rounded car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center"><%=user.getName()%>'s Profile
						</p>
						<form action="update_profile" method="post">
							<div class="mb-2">
								<label class="form-label">Name</label> <input name="name"
									type="text" class="form-control" value="<%=user.getName()%>"
									required>
							</div>
							<div class="mb-2">
								<label class="form-label">Age</label> <input name="age"
									type="number" class="form-control" value="<%=user.getAge()%>"
									required>
							</div>
							<div class="mb-2">
								<label class="form-label">Email Address</label> <input
									name="email" type="email" class="form-control"
									value="<%=user.getEmail()%>" required>
							</div>
							<div class="mb-3">
								<label class="form-label">Mobile No</label> <input name="mobile"
									type="tel" class="form-control" value="<%=user.getMobile()%>"
									required>
							</div>
							<input name="id" type="hidden" value="<%=user.getId()%>">
							<button type="submit" class="btn bg-primary text-white col-md-12">Update</button>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>