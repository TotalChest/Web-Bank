<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>
<style><%@include file="/WEB-INF/jsp/styles.css"%></style>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Добавить отделение</title>
    </head>

    <body>
        <div class="header">
            <div class="header_content">
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/customers"'>КЛИЕНТЫ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>СЧЕТА</button>
                <button class="active_button" onClick='location.href="${pageContext.request.contextPath}/departments"'>ОТДЕЛЕНИЯ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/operations"'>ОПЕРАЦИИ</button>
                <div class="header_text">
                    <a href="${pageContext.request.contextPath}/">СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА</a>
                </div>
            </div>
        </div>

        <div class="body_content">
            <form id="dep_form" action="${pageContext.request.contextPath}/add/department" method="post">
                <div class="button" onClick='document.getElementById("dep_form").submit()'>
                    ДОБАВИТЬ
                </div>
                <div class="block">
                    <table>
                        <tr>
                            <th>Название</th>
                            <td><input class="in" type="text" name="name" required value="${DepartmentForm.name}"/></td>
                        </tr>
                        <tr>
                            <th>Адрес</th>
                            <td><input class="in" type="text" name="address" required value="${DepartmentForm.address}"/></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

    </body>
</html>