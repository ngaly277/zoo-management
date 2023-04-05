<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html xmlns="http://www.w3.org/1999/xhtml"
	xmlns:th="http://www.thymeleaf.org"
	xmlns:sec="http://www.thymeleaf.org">
<head>
<meta charset="UTF-8">
<title>Cage Management page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/resources/css/style-page-admin.css" />'
	rel="stylesheet" type="text/css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
</head>
<body>

	<nav class="sidebar close">
		<header>
			<div class="image-text">
				<span class="image"> <img
					src='<c:url value="/resources/images/eevee.png"></c:url>'>
				</span>

				<div class="text logo-text">
					<span class="name">Rainie</span> <span class="profession">Staff
						Site</span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="admin.jsp"> <i
							class='bx bx-home-alt icon'></i> <span class="text nav-text">Home</span>
					</a></li>
					<li class="nav-link"><a href="Cage.jsp"> <i
							class='bx bxs-castle icon'></i> <span class="text nav-text">Quản
								lý chuồng</span>
					</a></li>

					<li class="nav-link"><a href="Animal.jsp"> <i
							class='bx bxs-dog icon'></i> <span class="text nav-text">Quản
								lý động vật</span>
					</a></li>

					<li class="nav-link"><a href="Inventory.jsp"> <i
							class='bx bx-box icon'></i> <span class="text nav-text">Quản
								lý kho</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bxs-coupon icon'></i> <span class="text nav-text">Quản
								lý đặt vé</span>
					</a></li>

					<li class="nav-link"><a href="stafflist"> <i
							class='bx bx-user icon'></i> <span class="text nav-text">Quản
								lý nhân viên</span>
					</a></li>

					<li class="nav-link"><a href="Revenue.jsp"> <i
							class='bx bx-pie-chart-alt icon'></i> <span class="text nav-text">Doanh
								thu</span>
					</a></li>
				</ul>
			</div>

			<div class="bottom-content">
				<li class=""><a href="#"> <i class='bx bx-log-out icon'></i>
						<span class="text nav-text">Logout</span>
				</a></li>
				<li class="mode">
					<div class="sun-moon">
						<i class='bx bx-moon icon moon'></i> <i class='bx bx-sun icon sun'></i>
					</div> <span class="mode-text text">Dark mode</span>

					<div class="toggle-switch">
						<span class="switch"></span>
					</div>
				</li>

			</div>
		</div>

	</nav>

	<section class="home">
		<div class="text">Staff Updating Page</div>
		<h2 class="banner ">Staff Updating</h2>
		<form:form modelAttribute="staffupdate" class="searchform" action="processupdatestaff" method="post">
			
			<button style="" class="button-search">Cập Nhật</button>

			<div class="table-wrapper" style="height: 50vh; overflow: auto">
				<table class="fl-table">
					<thead>
						<tr>
							<th>Mã NV</th>
							<th>Tên NV</th>
							<th>Lương</th>
							<th>Hợp đồng</th>
							<th>Loại nhân viên</th>
							<th>Username</th>
						</tr>
					</thead>
					<tbody>
					<c:forEach items="${staffList}" var="stafflist" >
					<tr>
						<td><form:input type="text" path="idStaff" value = "${stafflist.idStaff}" readonly="true"/></td>
						<td><form:input type="text" path="staffName" value="${stafflist.staffName}"/></td>
						<td><form:input type="text" path="salary" value="${stafflist.salary}"/></td>
						<td><a class="bx bx-notepad bx-xs"
							style="text-decoration: none; color: green" href="">${stafflist.idContract} </a></td>
							
						<%-- <c:forEach items="${staffTypeList}" var="stafftypelist">
						<c:if test="${stafflist.idStaffType == stafftypelist.idStaffType}">
						<td>${stafftypelist.staffType}</td>
						</c:if>
						</c:forEach> --%>
						
						<td>
						<select name="staffTypeClicked">
						<c:forEach items="${staffTypeList}" var="stafftypelist">
						<c:if test="${stafflist.idStaffType == stafftypelist.idStaffType}">
						<option value="${stafftypelist.idStaffType}" selected >${stafftypelist.staffType}</option>
						</c:if>
						<option value="${stafftypelist.idStaffType}">${stafftypelist.staffType}</option>
						</c:forEach>
						</select>
						</td>
						
						<td><form:input type="text" path="username" value="${stafflist.username}"/></td>
						
					</tr>
					</c:forEach>
				<tbody>
				</table>
			</div>
		</form:form>


	</section>
</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>