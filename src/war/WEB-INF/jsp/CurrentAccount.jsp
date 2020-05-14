<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Счет</title>
    </head>

    <body>
        <div class="header">
            <div class="header_content">
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/customers"'>КЛИЕНТЫ</button>
                <button class="active_button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>СЧЕТА</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/departments"'>ОТДЕЛЕНИЯ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/operations"'>ОПЕРАЦИИ</button>
                <div class="header_text">
                    <a href="${pageContext.request.contextPath}/">СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА</a>
                </div>
            </div>
        </div>

        <div class="body_content">
            <div>Информация о счете номер ${id}</div>
            <table>
                <tr>
                    <th>Номер счета</th>
                    <th>Клиент</th>
                    <th>Баланс</th>
                    <th>Тип</th>
                    <th>Отделение</th>
                    <th>Дата открытия</th>
                </tr>
                <tr>
                    <td>${AccountCustomer.getName}</td>
                    <td>${AccountNumber}</td>
                    <td>${AccountBalance}</td>
                    <td>${AccountType}</td>
                    <td>${AccountInterest}</td>
                    <td>${AccountDepartment}</td>
                    <td>${AccountDate}</td>
                </tr>
            </table>
            <input type="text" id="amount" class="in" placeholder="Сумма">
            <button class="button" onClick='updateAmount(0, id)'>Зачислить</button>
            <button class="button" onClick='updateAmount(1, id)'>Списать</button>
            <div>Список последних операций</div>
            <table>
                <c:forEach items="${OperationList}" var="operation">
                    <tr>
                        <td> ${operation.type}</td>
                        <td> ${operation.amount}</td>
                        <td> ${operation.date}</td>
                    </tr>
                </c:forEach>
             </table>
        </div>

    </body>
</html>