<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Edit or Create Animal page</title>
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
					<span class="name">Rainie</span> <span class="profession">Admin
						Site</span>
				</div>
			</div>

			<i class='bx bx-chevron-right toggle'></i>
		</header>
		<div class="menu-bar">
			<div class="menu">
				<ul class="menu-links">
					<li class="nav-link"><a href="#"> <i
							class='bx bx-home-alt icon'></i> <span class="text nav-text">Home</span>
					</a></li>
					<li class="nav-link"><a
						href="<%=request.getContextPath()%>/showAllCage"> <i
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

					<li class="nav-link"><a href="Staff.jsp"> <i
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
		<div class="container-xl px-4 mt-4">
			<hr class="mt-0 mb-4">
			<div class="row">
				<div class="col-xl-8">
					<!-- Account details card-->
					<div class="card mb-4">
						<div class="card-header">Edit Animal</div>
						<div class="card-body">
							<form action="editAnimal?idCage=${animal.cages.idCage}" method="post">
								<div class="row gx-3 mb-3">
									<div class="col-md-6">
										<label class="small mb-1" for="idAnimal">ID Động vật</label> <input
											readonly class="form-control" id="idAnimal" name="idAnimal"
											type="text" placeholder="Nhập ID Động vật"
											value="<c:out value="${animal.idAnimal == null ? '' : String.valueOf(animal.idAnimal)}"/>">
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="animalName">Tên Động vật</label> <input
											class="form-control" id="animalName" name="animalName"
											type="text" placeholder="Nhập ID Động vật"
											value="<c:out value="${animal.animalName}"/>">
									</div>
									<div class="col-md-6">
										<label class="small mb-1" for="animalStatus">Trạng thái Động vật</label> <input
											class="form-control" id="animalStatus" name="animalStatus"
											type="text" placeholder="Nhập tên chuồng"
											value="<c:out value="${animal.animalStatus}"/>">
									</div>
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="detail">Thông tin thêm</label> <input
										class="form-control" id="detail" name="detail" type="text"
										placeholder="Nhập giới hạn"
										value="<c:out value="${animal.detail}"/>">
								</div>
								<div class="mb-3">
									<label class="small mb-1" for="food">Thức ăn</label> <input
										class="form-control" id="food" name="food" type="text"
										placeholder="Nhập giới hạn"
										value="<c:out value="${animal.food}"/>">
								</div>
								<br> <label class="small mb-1" for="animalType">Loài động vật
								</label> <select class="select" id="animalType" name="animalType">
									<option value="">-- Chọn loài --</option>
									<c:forEach var="type" items="${animalTypeList}">
										<option value="<c:out value="${type.idAnimalType}"/>" <c:out value = "${type.animalType.equals(animal.types.animalType)? 'selected' : ''}"/>>${type.animalType}</option>
									</c:forEach>
								</select> <br> <br>
								<button class="button-search" type="submit">Save</button>
							</form>
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