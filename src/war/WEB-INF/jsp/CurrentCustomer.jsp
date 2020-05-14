<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Клиент</title>
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
            <div>Информация о клиенте номер ${id}</div>
            <table>
                <tr>
                    <th>Имя</th>
                    <th>Тип</th>
                    <th>Дата</th>
                </tr>
                <tr>
                    <td>${CustomerName}</td>
                    <td>${CustomerType}</td>
                    <td>${CustomerDate}</td>
                </tr>
                <tr>
                <div>Список счетов клиента</div>
                </tr>
                <c:forEach items="${AccountList}" var="account">
                    <tr>
                        <td> ${account.name}</td>
                        <td> ${account.balance}</td>
                        <td> ${account.type}</td>
                        <td> ${account.department}</td>
                        <td> ${account.date}</td>
                    </tr>
                </c:forEach>
            </table>
        </div>

    </body>
</html>