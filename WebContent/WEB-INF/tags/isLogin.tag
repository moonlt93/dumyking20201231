<%@ tag language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:if test="${not empty sessionScope.authUser }" >

<!-- 세션이 비어있지 않으면(로그인시) dobody실행 -->

  <jsp:doBody />
</c:if>
