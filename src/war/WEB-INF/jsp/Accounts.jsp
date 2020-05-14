<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Счета</title>
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
            <table>
                <tr>
                    <td class="but">
                        <div class="filters">
                            ФИЛЬТР
                        </div>
                    </td>
                    <td class="but">
                        <div class="button" onClick='location.href="${pageContext.request.contextPath}/add/account"'>
                            ДОБАВИТЬ СЧЕТ
                        </div>
                    </td>
                </tr>
            </table>
            <hr>
            <div class="block_head">
                Таблица счетов
            </div>
            <div class="block">
                <table id="AccountTable">
                    <tr>
                        <td><input type="text" id="number" class="search_icon" onkeyup="FilterFunction(0, id)" placeholder="Поиск по номеру"></td>
                        <td><input type="text" id="type" class="search_icon" onkeyup="FilterFunction(1, id)" placeholder="Поиск по типу"></td>
                        <td><input type="text" id="department" class="search_icon" onkeyup="FilterFunction(2, id)" placeholder="Поиск по отделению"></td>
                    </tr>
                    <tr>
                        <th>Номер счета</th>
                        <th>Клиент</th>
                        <th>Баланс</th>
                        <th>Тип</th>
                        <th>Отделение</th>
                        <th>Дата открытия</th>
                    </tr>
                    <tr>
                        <td>89676776</td>
                        <td>Иванов</td>
                        <td>20000</td>
                        <td>LIGHT</td>
                        <td>Сбербанк Алтуфьево</td>
                        <td>23.11.19</td>
                    </tr>
                    <c:forEach items="${accountList}" var="account">
                        <tr>
                            <td>
                                <a href="account?id=${account.accountId}">
                                    ${account.number}
                                </a>
                            </td>
                            <td> ${account.name}</td>
                            <td> ${account.balance}</td>
                            <td> ${account.type}</td>
                            <td> ${account.department}</td>
                            <td> ${account.date}</td>
                        </tr>
                    </c:forEach>
                </table>
            </div>
        </div>
        <script>
            function FilterFunction(id, input) {
                var real_input, filter, table, tr, td, i, txtValue;
                real_input = document.getElementById(input);
                filter = real_input.value.toUpperCase();
                table = document.getElementById("AccountTable");
                tr = table.getElementsByTagName("tr");
                for (i = 2; i < tr.length; i++) {
                    td = tr[i].getElementsByTagName("td")[id];
                    if (td) {
                        txtValue = td.textContent || td.innerText;
                        if (txtValue.toUpperCase().indexOf(filter) > -1) {
                            tr[i].style.display = "";
                        } else {
                            tr[i].style.display = "none";
                        }
                    }
                }
            }
        </script>
    </body>
</html>