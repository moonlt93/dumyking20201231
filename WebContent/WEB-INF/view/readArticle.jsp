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
.form-control[readonly] {
  background-color: #fff;
}
</style>
</head>
 <body>
<u:navbar/>

 <div class="container">
  <div class="row">
    <div class="col-3"></div>
  	<div class="col-6">
      <h1>게시글 보기 <small><i class="fas fa-hashtag"></i> ${articleData.article.number }</small> </h1>
      
      <div class="content-container">
        <div class="form-group">
          <label for="input1-title">제목</label>
          <div class="input-group">
            <input id="input1-title" type="text" value="${articleData.article.title }" class="form-control" readonly />
            <div class="input-group-append">
              <span class="input-group-text">@ ${articleData.article.writer.name }</span>
            </div>
          </div>
        </div>
        <div class="form-group">
          <label for="textarea1-content">내용</label>
          <textarea class="form-control" name="" id="textarea1-content" cols="30" rows="10" readonly >${articleData.content.content }</textarea>
        </div>
      </div>
      <c:if test="${authUser.id == articleData.article.writer.id}">
        <div class="button-container mt-3">
          <a class="btn btn-primary" href="${root }/article/modify.do?no=${articleData.article.number }"><i class="fas fa-edit"></i> 수정</a>
          <a class="btn btn-danger" href="${root }/article/delete.do?no=${articleData.article.number }"><i class="fas fa-trash-alt"></i> 삭제</a>
        </div>
      </c:if>
      <u:replyForm articleNo="${articleData.article.number }"/>
    
    <u:listReply /> 
    </div>
  </div>
</div> 

<%-- 
   <div class="container">
    <table border="1" width="100%">
      <tr>
        <td>번호</td>
        <td>${articleData.article.number }</td>
      </tr>
      <tr>
        <td>작성자</td>
        <td>${articleData.article.writer.name }</td>
      </tr>
      <tr>
        <td>제목</td>
        <td><c:out value="${articleData.article.title }"></c:out></td>
      </tr>
      <tr>
        <td>내용</td>
        <td><u:pre value="${articleData.content.content }" /></td>
      </tr>
      <tr>
        <td colspan="2"><c:set var="pageNo"
            value="${empty param.pageNo ? '1' : param.pageNo }" /> <a
          href="list.do?pageNo=${pageNo}">[목록]</a>
          <c:if
            test="${authUser.id == articleData.article.writer.id}">
            <a href="modify.do?no=${articleData.article.number }">[게시글수정]</a>
            <a href="delete.do?no=${articleData.article.number }">[게시글삭제]</a>
          </c:if>
        </td>
      </tr>
    </table>
    <u:replyForm articleNo="${articleData.article.number }"/>
    
    <u:listReply /> 
  </div>  --%>
</body>
</html>







