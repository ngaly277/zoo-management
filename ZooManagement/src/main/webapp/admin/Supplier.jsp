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
                        <a href="#">
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
        		<div class="text">Supplier Page</div>
        <h2 class = "banner ">Supplier Management Table</h2>
        <div class = "banner">
			<a href="<%=request.getContextPath()%>/showAddSupplier" class="button-search" role="button">Add Supplier</a>

		</div>
          <c:url value="/SearchInventory" var="SearchInventory"/>
 		<form:form class = "searchform" action="SearchSupplier" method="post">
					<p class = "text2" >Search Information by:</p>
    								<select name="op" class="select">
      									 <option value="Supplier_Name">Tên</option>
      									 <option value="ID_Supplier_Type">Loại</option>
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
            <th>Tên nhà cung cấp</th>
            <th>Loại sản phẩm cung cấp</th>
            <th>Hợp đồng</th>
            <th>Action</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${supplier}" var="item">
        <tr>
            <td><c:out value="${item.id}" /></td>
            <td><c:out value="${item.name}" /></td>
  			<td><c:out value="${item.supplierType.supplierType}" /></td>
            <td><c:out value="${item.contracts.details}" /></td>
            <td><a class = "bx bxs-edit bx-xs" style="text-decoration:none; color: green" href = "<%=request.getContextPath()%>/showEditSupplier?id=<c:out value="${item.id}" />">
  					</a>
  					&nbsp &nbsp
            <a class = "bx bxs-trash bx-xs" style="text-decoration:none; color: red " href = "<%=request.getContextPath()%>/deleteSupplier?id=<c:out value="${item.id}" />">
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