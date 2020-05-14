<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Добавить клиента</title>
    </head>

    <body>
        <div class="header">
            <div class="header_content">
                <button class="active_button" onClick='location.href="${pageContext.request.contextPath}/customers"'>КЛИЕНТЫ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>СЧЕТА</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/departments"'>ОТДЕЛЕНИЯ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/operations"'>ОПЕРАЦИИ</button>
                <div class="header_text">
                    <a href="${pageContext.request.contextPath}/">СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА</a>
                </div>
            </div>
        </div>

        <div class="body_content">
            <form id="cus_form" action="${pageContext.request.contextPath}/add/customer" method="post">
                <div class="button" onClick='document.getElementById("cus_form").submit()'>
                    ДОБАВИТЬ
                </div>
                <div class="block">
                    <table>
                        <tr>
                            <th>Тип</th>
                            <td><input class="in" type="text" name="type" required value="${CustomerForm.type}"/></td>
                        </tr>
                        <tr>
                            <th>Имя</th>
                            <td><input class="in" type="text" name="name" required value="${CustomerForm.name}"/></td>
                        </tr>
                        <tr>
                            <th>Фамилия</th>
                            <td><input class="in" type="text" name="surname" required value="${CustomerForm.surname}"/></td>
                        </tr>
                        <tr>
                            <th>Адрес</th>
                            <td><input class="in" type="text" name="address" required value="${CustomerForm.address}"/></td>
                        </tr>
                        <tr>
                            <th>Телефонный номер</th>
                            <td><input class="in" type="text" name="phone_number" required value="${CustomerForm.phone_number}"/></td>
                        </tr>
                        <tr>
                            <th>Электронная почта</th>
                            <td><input class="in" type="text" name="email" required  value="${CustomerForm.email}"/></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

    </body>
</html>