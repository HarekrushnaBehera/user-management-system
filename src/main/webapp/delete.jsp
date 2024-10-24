<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Delete</title>
<%@ include file="components/bootstrapCss.jsp"%>
</head>
<body>
	<%@ include file="components/index_navbar.jsp"%>
	<div class="container p-5">
		<div class="row">
			<div class="col-md-4 offset-md-4">
				<div class="shadow p-3 mb-5 bg-body rounded car paint-card">
					<div class="card-body">
						<p class="fs-4 text-center">Are you sure to delete ?</p>
						<div class="d-grid gap-2 d-md-flex justify-content-md-end">
							<% int id = Integer.parseInt(request.getParameter("id")); %>
							<a class="btn btn-primary me-md-2" href="delete_user?id=<%= id %>">Yes</a>
							<a class="btn btn-danger" href="home.jsp">No</a>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>
</html>