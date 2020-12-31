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
<title>문진수</title>

</head>
<body>
	<u:navbar />
				<!-- 	<img
						src="https://pixnio.com/free-images/2017/09/26/2017-09-26-07-57-28-1100x666.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="https://image.musinsa.com/mfile_s01/2019/10/23/6bd8407bf6d5ceee8602e3fad4c3511f093523.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F250B5538583D140F1F72ED" class="d-block w-100" alt="...">
				</div>
			</div> -->

	<div class="container">
		<div id="carouselExampleFade" class="carousel slide carousel-fade"
			data-bs-ride="carousel">
			<div class="carousel-inner">
				<div class="carousel-item active">
					<img
						src="https://pixnio.com/free-images/2017/09/26/2017-09-26-07-57-28-1100x666.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="https://image.musinsa.com/mfile_s01/2019/10/23/6bd8407bf6d5ceee8602e3fad4c3511f093523.jpg"
						class="d-block w-100" alt="...">
				</div>
				<div class="carousel-item">
					<img
						src="https://img1.daumcdn.net/thumb/R720x0.q80/?scode=mtistory2&fname=http%3A%2F%2Fcfile30.uf.tistory.com%2Fimage%2F250B5538583D140F1F72ED"
						class="d-block w-100" alt="...">
				</div>
			</div>
			<a class="carousel-control-prev" href="${root }/index.jsp"
				role="button" data-bs-slide="prev"> <span
				class="carousel-control-prev-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Previous</span>
			</a> <a class="carousel-control-next" href="${root }/index.jsp"
				role="button" data-bs-slide="next"> <span
				class="carousel-control-next-icon" aria-hidden="true"></span> <span
				class="visually-hidden">Next</span>
			</a>
		</div>
	</div>
</body>
</html>