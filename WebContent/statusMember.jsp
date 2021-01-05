<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<script
	src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
<title>문진수</title>
</head>
<body>
<div class="container">
	<form action="${root }/index.jsp" method="post">
		<u:navbar />
			<ul class="info-hover">
			<li class="list-group-item">아이디:${sessionScope.authUser.id }</li>
			<li class="list-group-item">이름:${sessionScope.authUser.name }</li>
			<li class="list-group-item">생일:${sessionScope.authUser.birth }</li>
			<li class="list-group-item">성별:${sessionScope.authUser.gender }</li>
			<li class="list-group-item">직업:${sessionScope.authUser.job }</li>
			</ul>
			<input type="submit" value="확인" />
	</form>
</div>
</body>
</html>