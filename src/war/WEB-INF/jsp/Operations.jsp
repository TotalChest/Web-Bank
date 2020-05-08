<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Операции</title>
    </head>

    <body>
        <div class="header">
            <div class="header_content">
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/customers"'>КЛИЕНТЫ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>СЧЕТА</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/departments"'>ОТДЕЛЕНИЯ</button>
                <button class="active_button" onClick='location.href="${pageContext.request.contextPath}/operations"'>ОПЕРАЦИИ</button>
                <div class="header_text">
                    <a href="${pageContext.request.contextPath}/">СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА</a>
                </div>
            </div>
        </div>

        <div class="body_content">
            <div class="block_head">
                Таблица всех операций
            </div>
            <div class="block">
                <table>
                    <tr>
                        <th>Счет</th>
                        <th>Операция</th>
                        <th>Сумма</th>
                        <th>Дата</th>
                    </tr>
                    <tr>
                        <td>89676776</td>
                        <td>Списание</td>
                        <td>7000</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>89676776</td>
                        <td>Списание</td>
                        <td>7000</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>89676776</td>
                        <td>Списание</td>
                        <td>7000</td>
                        <td>23.11.19</td>
                    </tr>
                    <tr>
                        <td>89676776</td>
                        <td>Списание</td>
                        <td>7000</td>
                        <td>23.11.19</td>
                    </tr>
                </table>
            </div>
        </div>

    </body>
</html>