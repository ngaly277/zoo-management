<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory Management page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link href='<c:url value="/resources/css/style-page-admin.css" />'
	rel="stylesheet" type="text/css">
<link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css'
	rel='stylesheet'>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM"
	crossorigin="anonymous"></script>
<script src="https://code.jquery.com/jquery-3.6.4.min.js"></script>
</head>
<body>
	<nav class="sidebar close">
		<header>
			<div class="image-text">
				<span class="image"> <img
					src='<c:url value="/resources/images/eevee.png"></c:url>'>
				</span>

				<div class="text logo-text">
					<span class="name">Rainie</span> <span class="profession">Cage
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

					<li class="nav-link"><a
						href="<%=request.getContextPath()%>/viewInventory"> <i
							class='bx bx-box icon'></i> <span class="text nav-text">Quản
								lý kho</span>
					</a></li>

					<li class="nav-link"><a href="#"> <i
							class='bx bxs-coupon icon'></i> <span class="text nav-text">Quản
								lý đặt vé</span>
					</a></li>

					<li class="nav-link"><a href="Staff.jsp"> <i
							class='bx bx-user icon'></i> <span class="text nav-text">Quản
								lý nhân viên</span>
					</a></li>

					<li class="nav-link"><a href="Revenue.jsp"> <i
							class='bx bx-pie-chart-alt icon'></i> <span
							class="text nav-text">Doanh thu</span>
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
		<div class="container-xl px-4 mt-4">
			<!-- Account page navigation-->
			<div class="row">
				<div class="col-xl-8">
					<div class="card mb-4">
						<div class="card-header">Insert Bill</div>
						<div class="card-body">
							<form:form class="searchform" action="addBill" method="post">
								<br />
								<!-- Form Row-->
								<div class="row gx-3 mb-3">
									<!-- Form Group (first name)-->
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Tên hóa đơn</label> <input
											class="form-control" name="name" type="text">
									</div>
									<!-- Form Group (last name)-->
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Loại</label> <select
											name="type" class="form-control">
											<option value="0">Nhập Kho</option>
										</select>
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="Brief">Chọn nhà cung
											cấp:</label> <select name="opSupplier" class="form-control">
											<c:forEach items="${supplier}" var="item">
												<option value="${item.id}"><c:out
														value="${item.name}" /></option>
											</c:forEach>
										</select>
									</div>
								</div>
								<br />
								<!-- Form Group (email address)-->
								<div class="row gx-3 mb-3">
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Số lượng:</label> <input
											class="form-control" name="number" type="number">
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Ngày thực hiện:</label>
										<input readonly="readonly" class="form-control" value="${dateNow}" type="text">
									</div>
								</div>
								<div class="row gx-3 mb-3">
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Tên sản phẩm:</label> <input
											class="form-control" name="nameProduct" type="text">
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Chọn kho:</label>
										<select name="opInventory" class="form-control">
											<c:forEach items="${inventory}" var="item">
												<option value="${item.id}"><c:out
														value="${item.name}" /></option>
											</c:forEach>
										</select>
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="Title">Giá:</label> <input
											class="form-control" name="price" type="number">
									</div>
								</div>
								<!-- Save changes button-->
								<br>
								<button class="button-search" type="submit">Save</button>
							</form:form>
							<br>
						</div>
					</div>
				</div>
			</div>
		</div>
	</section>

</body>
<script src='<c:url value="/resources/js/js-page-admin.js" />'></script>
</html>