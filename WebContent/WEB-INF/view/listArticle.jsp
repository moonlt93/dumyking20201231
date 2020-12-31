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
<style>
.num-col {
	width: 10%;
}

.title-col {
	width: 60%;
}

.writer-col {
	width: 20%;
}

.read-col {
	width: 10%;
}
</style>
</head>
<body>
	<u:navbar />


	<div class="container">
		<table border="1">
			<tr>
				<td colspan="4"><a href="write.do">[게시글쓰기]</a> <!--게시글 쓰기로 넘어감  -->
				</td>
			</tr>
			<!--컬럼 열 구성.  -->
			<tr>
				<td>번호</td>
				<td>제목</td>
				<td>작성자</td>
				<td>조회수</td>
			</tr>

			<c:if test="${articlePage.hasNoArticles() }">
				<!-- if articlePage 게시글이 없을때 -->
				<tr>
					<td colspan="4">게시글이 없습니다.</td>
				</tr>
			</c:if>
			<c:forEach var="article" items="${articlePage.content }">
				<!--var: 결과를 저장할 변수 items 저장된 배열? -->
				<tr>
					<td>${article.number }</td>
					<td><a
						href="read.do?no=${article.number }&pageNo=${articlePage.currentPage}">
							<!-- get방식 ? --> <c:out value="${article.title}" />
					</a></td>
					<td>${article.writer.name }</td>
					<td>${article.readCount }</td>
				</tr>
			</c:forEach>
			<c:if test="${articlePage.hasArticles() }">
				<tr>
					<td colspan="4"><c:if test="${articlePage.startPage > 5}">
							<a href="list.do?pageNo=${articlePage.startPage - 5 }">[이전]</a>
						</c:if> <c:forEach var="pNo" begin="${articlePage.startPage }"
							end="${articlePage.endPage }">
							<a href="list.do?pageNo=${pNo }">[${pNo }]</a>
						</c:forEach> <c:if test="${articlePage.endPage < articlePage.totalPages }">
							<a href="list.do?pageNo=${articlePage.startPage + 5 }">[다음]</a>
						</c:if></td>
				</tr>
			</c:if>
		</table>
	</div>
</body>
</html>