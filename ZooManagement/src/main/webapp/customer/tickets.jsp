<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main class="main-container">
		<div class="content-container">
			<h1 class="content-title">Chọn loại vé</h1>
			<div class="warning-container">
				<div class="message-container">
					<i class='fa fa-exclamation-circle' style='color:#0F9F6C;font-size:30px;margin-right:20px;'></i>
					<div style="font-size: 20px;">
						Bạn đã có tài khoản? 
						<a href="login">Đăng nhập</a>
						Chưa có tài khoản?
						<a href="#">Đăng ký ngay</a>
					</div>
				</div>
				<div class="tickets-list">
				<c:if test="${not empty ticketTypeList}">
			      <c:forEach var="ticketType" items="${ticketTypeList}">
						<article class="ticket">
							<a href="add-tickets" class="ticket-img-link">
								<figure>
									<img class="ticket-img" src='<c:url value="/resources/images/img3.jpg"></c:url>' alt=""/>
									
								</figure>
							</a>
							<a href="add-tickets" class="ticket-name">
								<h2 class="ticket-name-content">${ticketType.ticket_Type}</h2>
							</a>
							<div class="ticket-desc">
								${ticketType.ticket_Description }
							</div>
							<a href="add-tickets" class="ticket-link">Chọn</a>
						</article>
			      </c:forEach>
			    </c:if>
					<%-- <article class="ticket">
						<a href="add-tickets" class="ticket-img-link">
							<figure>
								<img class="ticket-img" src='<c:url value="/resources/images/img3.jpg"></c:url>' alt=""/>
								
							</figure>
						</a>
						<a href="add-tickets" class="ticket-name">
							<h2 class="ticket-name-content">Vé vào cổng</h2>
						</a>
						<div class="ticket-desc">
							Yêu cầu đặt vé trực tuyến trước để vào cổng 
						</div>
						<a href="add-tickets" class="ticket-link">Chọn</a>
					</article>
					<article class="ticket">
						<a href="#" class="ticket-img-link">
							<figure>
								<img class="ticket-img" src='<c:url value="/resources/images/img4.jpg"></c:url>' alt=""/>
								
							</figure>
						</a>
						<a href="#" class="ticket-name">
							<h2 class="ticket-name-content">Vé tàu SEPTA PZ Express</h2>
						</a>
						<div class="ticket-desc">
							Tham gia chuyến tàu SEPTA PZ Express của chúng tôi để có được trải nghiệm tốt nhất
						</div>
						<a href="#" class="ticket-link">Chọn</a>
					</article> --%>
				</div>
			</div>
			<jsp:include page="cart.jsp"></jsp:include>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>