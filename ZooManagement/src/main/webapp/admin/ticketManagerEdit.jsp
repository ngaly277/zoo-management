<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Ticket manager</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type="text/css">
    <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
    <%-- Page variables --%>
    <c:set var="myContext" value="${pageContext.request.contextPath}"/>
</head>
<body>
    <jsp:include page="navbar.jsp" />
    <section class="home">
        <div class="text">
            <a href="${myContext}/admin/tickets"><i class='bx bx-left-arrow-alt' style="border: solid; border-width: 2px; border-radius: 100px;"></i></a>
            <c:out value='${ticketId != null ? "Edit" : "Add"}' /> a ticket
        </div>
        <form class="searchform" action="${myContext}/admin/tickets/add" method="post">
            <c:if test="${ticketId != null}">
                <p class="text2">ID: </p>
                <div class="searchbar"><input type="text" name="id" readonly value='${ticketId}'></div>
                <br>
            </c:if>
            <p class="text2">Ticket type (hover option for description):</p>
            <select class="select" name="type">
                <c:forEach var="item" items="${ticketTypeList}">
                    <option value="${item.id_Ticket_Type}" title="${item.ticket_Description}">${item.ticket_Type}</option>
                </c:forEach>
            </select>
            <br>
            <p class="text2">Amount: </p>
            <div class="searchbar"><input type="text" name="q"></div>
            <br>
            <p class="text2">Price: </p>
            <div class="searchbar"><input type="text" name="q"></div>
            <br>
            <button class="button-search" type="submit"><c:out value='${ticketId != null ? "Edit" : "Add"}' /></button>
            <button class="button-search" type="reset">Clear data</button>
        </form>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>