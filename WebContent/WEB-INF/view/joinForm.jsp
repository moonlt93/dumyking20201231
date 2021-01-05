<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="u" tagdir="/WEB-INF/tags"%>
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
<script src="https://kit.fontawesome.com/a076d05399.js"></script>
<title>Insert title here</title>
</head>
<body>
	<u:navbar />
	<div class="container">
		<h1>회원가입</h1>
		<form action="${root }/join.do" method="post">
			<div class="form-group">
				<label for="input1-id">아이디</label> <input type="text" name="id"
					value="${param.id }" class="form-control" id="input1-id">
				<c:if test="${errors.id }">
					<small class="form-text text-muted"> ID를 입력하세요. </small>
				</c:if>
				<c:if test="${errors.duplicateId }">
					<small class="form-text text-muted"> 이미 사용중인 아이디입니다. </small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="input2-name">이름</label> <input type="text" name="name"
					value="${param.name }" id="input2-name" class="form-control">

				<c:if test="${errors.name }">
					<small class="form-text text-muted"> 이름을 입력하세요. </small>
				</c:if>
			</div>

			<div class="form-group">
				<label for="input3-password">암호</label> <input type="password"
					name="password" class="form-control" id="input3-password">
				<c:if test="${errors.password }">
					<small class="form-text text-muted"> 암호를 입력하세요. </small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="input4-confirmPassword">확인</label> <input
					type="password" name="confirmPassword" class="form-control"
					id="input4-confirmPassword">
				<c:if test="${errors.confirmPassword }">
					<small class="form-text text-muted"> 확인을 입력하세요. </small>
				</c:if>
				<c:if test="${errors.notMatch }">
					<small class="form-text text-muted"> 암호와 확인이 일치하지 않습니다. </small>
				</c:if>
			</div>
			<div class="form-group">
				<label for="input5-birth">생일</label> 
				<input type="date" name="birth"
					class="form-control" value="${param.birth }" />
				<c:if test="${errors.birth }">생일이 입력되지 않았습니다.</c:if>
			</div>
		<!-- 	<p>
				성별 <br />
			<div class="form-check">
				<input class="form-check-input1" type="checkbox" value="남자"
					id="flexCheckDefault"> <label class="form-check-label"
					for="flexCheckDefault"> 남자 </label> <input
					class="form-check-input2" type="checkbox" value="여자"
					id="flexCheckDefault"> <label class="form-check-label"
					for="flexCheckDefault"> 여자 </label>
			</div>
			</p> -->

			 성별: <br /> <input type="radio" name="gender" value="남자" />남자 
			             <input	type="radio" name="gender" value="여자" />여자
			

			<div class="form-group">
				<label for="input2-name">직업</label> <input type="text" name="job"
					value="${param.job }" id="input2-name" class="form-control">
				<c:if test="${errors.job }">
					<small class="form-text text-muted"> 직업을 입력하세요. </small>
				</c:if>
			</div>
			<input type="submit" value="가입" />
		</form>
	</div>
</body>
</html>



