<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Inventory Management page</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link href='<c:url value="/resources/css/style-page-admin.css" />' rel="stylesheet" type ="text/css"> 
 <link href='https://unpkg.com/boxicons@2.1.4/css/boxicons.min.css' rel='stylesheet'>
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
                <span class="image">
                	<img src = '<c:url value="/resources/images/eevee.png"></c:url>'>
                </span>

                <div class="text logo-text">
                    <span class="name">Rainie</span>
                    <span class="profession">Cage Site</span>
                </div>
            </div>

            <i class='bx bx-chevron-right toggle'></i>
        </header>
        <div class="menu-bar">
            <div class="menu">
                <ul class="menu-links">
                <li class="nav-link">
                        <a href="admin.jsp">
                            <i class='bx bx-home-alt icon'></i>
                            <span class="text nav-text">Home</span>
                        </a>
                    </li>
                    <li class="nav-link">
                        <a href="Cage.jsp">
                            <i class='bx bxs-castle icon' ></i>
                            <span class="text nav-text">Quản lý chuồng</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="Animal.jsp">
                            <i class='bx bxs-dog icon' ></i>
                            <span class="text nav-text">Quản lý động vật</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="<%=request.getContextPath()%>/viewInventory">
                            <i class='bx bx-box icon'></i>
                            <span class="text nav-text">Quản lý kho</span>
                        </a>
                    </li>
                    
                    <li class="nav-link">
                        <a href="#">
                            <i class='bx bxs-coupon icon'></i>
                            <span class="text nav-text">Quản lý đặt vé</span>
                        </a>
                    </li>

                    <li class="nav-link">
                        <a href="Staff.jsp">
                            <i class='bx bx-user icon' ></i>
                            <span class="text nav-text">Quản lý nhân viên</span>
                        </a>
                    </li>

					<li class="nav-link">
                        <a href="Revenue.jsp">
                            <i class='bx bx-pie-chart-alt icon' ></i>
                            <span class="text nav-text">Doanh thu</span>
                        </a>
                    </li>
                </ul>
            </div>

            <div class="bottom-content">
                <li class="">
                    <a href="#">
                        <i class='bx bx-log-out icon' ></i>
                        <span class="text nav-text">Logout</span>
                    </a>
                </li>
                <li class="mode">
                    <div class="sun-moon">
                        <i class='bx bx-moon icon moon'></i>
                        <i class='bx bx-sun icon sun'></i>
                    </div>
                    <span class="mode-text text">Dark mode</span>

                    <div class="toggle-switch">
                        <span class="switch"></span>
                    </div>
                </li>
                
            </div>
        </div>

    </nav>

    <section class="home">
        		<div class="text">Bill Page</div>
        <h2 class = "banner ">Bill History Table</h2>
        <div class = "banner">
			<a href="<%=request.getContextPath()%>/showAddBill" class="button-search" role="button">Add Bill</a>
			<a href="<%=request.getContextPath()%>/showAddBillAvailable" class="button-search" role="button">Add Bill (Available Product)</a>
		</div>
          <c:url value="/SearchInventory" var="SearchInventory"/>
 		<form:form class = "searchform" action="SearchBillDetail" method="post">
					<p class = "text2" >Search Information by:</p>
    								<select name="op" class="select">
      									 <option value="Bill_Name">Tên hóa đơn</option>
      									 <option value="Bill_Type">Loại</option>
      									 <option value="Supplier_Name">Nhà cung cấp</option>
      									 <option value="Product_Name">Sản phẩm</option>
      									 <option value="Transfer_Date ">Ngày</option>
    								</select>
                	<p class = "text2" >Type here:</p>
  						<div class="searchbar"><input name="search" type="search" placeholder='Search' /></div>
  						<button class = "button-search" type = "submit">Search</button>
                		<button class = "button-search" type = "reset">Reset</button>

        </form:form>
<br>
<br>
<div class="table-wrapper">
    <table class="fl-table">
        <thead>
        <tr>
            <th>STT</th>
            <th>Tên hóa đơn</th>
            <th>Loại</th>
            <th>Nhà cung cấp</th>
            <th>Sản phẩm</th>
            <th>Số lượng</th>
            <th>Ngày</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${billDetail}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.bill.name}" /></td>
            <td>
            <c:choose>
    			<c:when test="${item.bill.billType=='0'}">
        			nhập kho 
        			<br />
    			</c:when>    
    			<c:otherwise>
        			xuất kho 
        			<br />
    			</c:otherwise>
			</c:choose>
			</td>
            <td><c:out value="${item.bill.supplier.name}" /></td>
            <td><c:out value="${item.product.name}" /></td>
            <td><c:out value="${item.amountTransfer}" /></td>
            <td><c:out value="${item.transferDate}" /></td>
            <td>
            <a class = "bx bxs-trash bx-xs" style="text-decoration:none; color: red " href = "<%=request.getContextPath()%>/deleteBillDetail?id=<c:out value="${item.id}-${item.bill.id}" />">
  					</a>
  					</td>
        </tr>
        </c:forEach>
        <tbody>
    </table>
</div>
        </div>
    </section>

</body>
    <script src = '<c:url value="/resources/js/js-page-admin.js" />' ></script>
</html>