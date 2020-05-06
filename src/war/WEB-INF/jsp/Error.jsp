<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
    <title>Error</title>
</head>
<body>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/customers"'>Клиенты</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>Счета</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/departments"'>Отделения</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/operations"'>Операции</button>
<br>
<hr>
<h1>Sorry, some error occured :(</h1>
</body>
</html>