<%@ page isELIgnored="false" language="java"<%--     contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%> --%>

<%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%> --%>
<%-- <%@ taglib prefix="sec" --%>
<%--     uri="http://www.springframework.org/security/tags"%> --%>
<!-- <!DOCTYPE html> -->
<html>
<head>
<meta charset="UTF-8">
<title>Student manegement Project</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/css/bootstrap.min.css">
<script
	src="https://cdn.jsdelivr.net/npm/jquery@3.6.0/dist/jquery.slim.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.1/dist/js/bootstrap.bundle.min.js"></script>

</head>
<body>


	<div class="container">

		<div class="bg-success text-white">
			<h1 style="text-align: center; color: black; padding-top: 40px;">Student
				MANAGMENT PROJECT</h1>
			<br> <br>
		</div>

		<br> <a href="/Stduent-form" class="btn btn-secondary"> ADD
			STUDENT</a> Display UseName And Roles
		

	</div>


	<br>

	<div class="container">

		<table class="table table-dark table-hover">
			<thead>
				<tr>
					<th>Student_id</th>
					<th>Name</th>
					<th>Department</th>
                 	<th>Country</th>
					<th>Action</th>
				</tr>
			</thead>


			<c:forEach var="temp" items="${students}" varStatus="c">
				<tbody>
					<tr>
						<td>${c.count}</td>
						<td>${temp.name}</td>
						<td>${temp.Department}</td>
						<td>${temp.Country}</td>
						<td><a href="Update?id=${temp.id}" class="btn btn-warning">Update</a>
							| <a href="Delete?id=${temp.id}" class="btn btn-danger">Delete</a></td>
					</tr>
				</tbody>
			</c:forEach>
		</table>
	</div>

</body>
</html>