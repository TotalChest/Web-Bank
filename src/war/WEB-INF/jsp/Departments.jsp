<%@ page language="java" contentType="text/html;charset=utf-8"%>
<html>
<head>
    <meta charset="utf-8">
    <title>...</title>
</head>

<body>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/clients"'>Клиенты</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>Счета</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/departments"'>Отделения</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/operations"'>Операции</button>
<h1><a href="${pageContext.request.contextPath}/">Система управления сберегательными счетами клиентов банка</a></h1>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/add/department"'>Добавить отделение</button>
<div>Таблица отделений банка</div>
</body>
</html>