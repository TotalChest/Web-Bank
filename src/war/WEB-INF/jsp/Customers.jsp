<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Клиенты</title>
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
            <table>
                <tr>
                    <td class="but">
                        <div class="filters">
                            ФИЛЬТР
                        </div>
                    </td>
                    <td class="but">
                        <div class="button" onClick='location.href="${pageContext.request.contextPath}/add/customer"'>
                            ДОБАВИТЬ КЛИЕНТА
                        </div>
                    </td>
                </tr>
            </table>
            <hr>
            <div class="block_head">
                Таблица клиентов
            </div>
            <div class="block">
                <table>
                    <tr>
                        <th>Тип</th>
                        <th>Имя</th>
                        <th>Дата регистрации</th>
                    </tr>
                    <tr>
                        <td>INDIVIDUAL</td>
                        <td>Иванов</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>INDIVIDUAL</td>
                        <td>Иванов</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>INDIVIDUAL</td>
                        <td>Иванов</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>INDIVIDUAL</td>
                        <td>Иванов</td>
                        <td>23.11.19</td>
                    </tr>
                </table>
            </div>
        </div>

    </body>
</html>