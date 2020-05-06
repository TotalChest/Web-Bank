<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>
<html>
<head>
    <meta charset="utf-8">
    <title>...</title>
</head>
<body>

<button class="button" onClick='location.href="${pageContext.request.contextPath}/customers"'>Клиенты</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>Счета</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/departments"'>Отделения</button>
<button class="button" onClick='location.href="${pageContext.request.contextPath}/operations"'>Операции</button>

<h1><a href="${pageContext.request.contextPath}/">Система управления сберегательными счетами клиентов банка</a></h1>

<form action="${pageContext.request.contextPath}/add/customer" method="post">
    <input type="submit" value="Добавить" class="button"/>
    <table>
        <tr>
            <td>Тип</td>
            <td><input type="text" name="type" required/></td>
        </tr>
        <tr>
             <td>Имя</td>
             <td><input type="text" name="name" required/></td>
        </tr>
        <tr>
            <td>Фимилия</td>
            <td><input type="text" name="surname" required/></td>
        </tr>
        <tr>
             <td>Адрес</td>
             <td><input type="text" name="address" required/></td>
        </tr>
        <tr>
            <td>Телефонный номер</td>
            <td><input type="text" name="phone" required/></td>
        </tr>
        <tr>
             <td>Почта</td>
             <td><input type="text" name="mail" required/></td>
        </tr>
    </table>
</form>
</body>
</html>