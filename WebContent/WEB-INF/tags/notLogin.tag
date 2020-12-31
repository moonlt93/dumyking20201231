<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:if test="${empty sessionScope.authUser }" >

<!-- test내 el구문이 참이면 실행.  session객체에 authUser가 비어있으면 실행.  -->  
	<jsp:doBody />
	<!--dobody 실행.  -->
</c:if>

