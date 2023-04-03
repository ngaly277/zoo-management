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
    <jsp:include page="navbar.jsp">
        <jsp:param name="navToggle" value="tickets"/>
    </jsp:include>
    <section class="home">
        <div class="text">Ticket management</div>
        <h2 class="banner ">Ticket management table</h2>
        <form class="searchform" action="${myContext}/admin/tickets" method="get">
            <p class="text2">Find a ticket:</p>
            <div class="searchbar"><input type="search" name="q" placeholder='Enter a query here...' value='<c:out value="${searchQuery}" />'></div>
            <button class="button-search" type="submit">Search</button>
            <button class="button-search" type="reset">Clear text</button>
        </form>
        <br>
        <br>
        <%-- TODO: Add a ticket here --%>
        <a href="${myContext}/admin/tickets/add">
            <button style="margin-left: 70px" class="button-search">Add a ticket</button>
        </a>
        <div class="table-wrapper">
            <table class="fl-table">
                <thead>
                    <tr>
                        <th>Name</th>
                        <th>Type</th>
                        <th>Amount</th>
                        <th>Price</th>
                        <th>Action</th>
                    </tr>
                </thead>
                <tbody>
                    <c:forEach var="item" items="${data}">
                        <tr>
                            <td>Testing ${item}</td>
                            <td>Testing ${item}</td>
                            <td>Testing ${item}</td>
                            <td>Testing ${item}</td>
                            <td>
                                <form action="${myContext}/admin/tickets/delete?id=${item}" method="post">
                                    <a class="bx bxs-edit bx-xs" style="text-decoration:none; color: green" href="${myContext}/admin/tickets/edit?id=${item}"></a>
                                    &nbsp &nbsp
                                    <button type="submit" class="bx bxs-trash bx-xs" style="text-decoration:none; color: red; border: none; background-color: transparent;"></button>
                                </form>
                            </td>
                        </tr>
                    </c:forEach>
                <tbody>
            </table>
        </div>
        </div>
    </section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>