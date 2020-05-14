<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Отделения</title>
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
            <div class="button" onClick='location.href="${pageContext.request.contextPath}/add/department"'>
                ДОБАВИТЬ ОТДЕЛЕНИЕ
            </div>
            <hr>
            <div class="block_head">
                Таблица отделений
            </div>
            <div class="block">
                <table>
                    <tr>
                        <th>Название</th>
                        <th>Адрес</th>
                    </tr>
                    <tr>
                        <td>Сбербанк Алтуфьево</td>
                        <td>г. Москва, Череповецкая улица, 12</td>
                    </tr>
                    <c:forEach items="${DepartmentList}" var="department">
                        <tr>
                            <td>${department.name}</td>
                            <td>${department.address}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>

    </body>
</html>