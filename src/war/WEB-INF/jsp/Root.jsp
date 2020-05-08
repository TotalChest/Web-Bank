<%@ page language="java" contentType="text/html;charset=utf-8"%>
<%@ include file="/WEB-INF/jsp/includes.jsp" %>

<html>
    <head>
        <meta charset="UTF-8">
        <link rel="shortcut icon" href="/images/favicon.jpg" type="image/jpg">
        <title>Банк</title>
    </head>

    <body>

        <div class="header">
            <div class="header_content">
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/customers"'>КЛИЕНТЫ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/accounts"'>СЧЕТА</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/departments"'>ОТДЕЛЕНИЯ</button>
                <button class="common_button" onClick='location.href="${pageContext.request.contextPath}/operations"'>ОПЕРАЦИИ</button>
                <div class="header_text">
                    <a href="${pageContext.request.contextPath}/">СИСТЕМА УПРАВЛЕНИЯ СБЕРЕГАТЕЛЬНЫМИ СЧЕТАМИ БАНКА</a>
                </div>
            </div>
        </div>

        <div class="body_content">
            <div class="block">
                Этот сайт создан в учебных целях. <br/>
                В рамках задания разрабатывалось небольшое Web-приложение с использованием среды интеграции Spring и преобразователя реляционных данных в объектные Hibernate.
                Для разработки использовались технологии Java EE, среда Intellij IDEA, инструменты разработки и выполнения тестов JUnit и Selenium. <br/>
                Сайт предназаначен для управления сберегательными счетами клиентов банка.
            </div>
        </div>

    </body>
</html>