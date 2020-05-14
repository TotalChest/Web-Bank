<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Добавить счет</title>
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
            <form id="acc_form" action="${pageContext.request.contextPath}/add/account" method="post">
                <div id="add" class="button" onClick='document.getElementById("acc_form").submit()'>
                    ДОБАВИТЬ
                </div>
                <div class="block">
                    <table>
                        <tr>
                            <th>Номер счета</th>
                            <td><input class="in" type="text" name="number" required value="${AccountForm.number}" /></td>
                        </tr>
                        <tr>
                            <th>Идентификатор клиента</th>
                            <td><input class="in" type="text" name="customer_id" required value="${AccountForm.customer}"/></td>
                        </tr>
                        <tr>
                            <th>Тип</th>
                            <td><input class="in" type="text" name="type" required  value="${AccountForm.type}"/></td>
                        </tr>
                        <tr>
                            <th>Номер счета начисления процентов</th>
                            <td><input class="in" type="text" name="interest_account" required  value="${AccountForm.interest}"/></td>
                        </tr>
                        <tr>
                            <th>Отделение</th>
                            <td><input class="in" type="text" name="department_id" required/  value="${AccountForm.department}"></td>
                        </tr>
                    </table>
                </div>
            </form>
        </div>

    </body>
</html>