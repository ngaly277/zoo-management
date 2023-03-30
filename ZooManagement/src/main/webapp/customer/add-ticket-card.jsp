<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-add-ticket-order.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.css">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/themes/light.css">
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/flatpickr/4.2.3/flatpickr.js"></script>
<title>Chào mừng bạn đến với Sở thú</title>
</head>
<body>
	<jsp:include page="header.jsp"></jsp:include>
	
	<main class="main-container">
		<div class="content-container">
			<h1 class="content-title">Vé vào cổng</h1>
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
				<article >
					<figure class="ticket-detail">
						<img class="ticket-detail-img" src='<c:url value="/resources/images/img3.jpg"></c:url>' alt=""/>
						
					</figure>
					<div class="ticket-detail-desc" style="font-size:20px;">
						Yêu cầu đặt vé trực tuyến trước để vào cổng 
					</div>
				</article>
				<form class="ticket-form">
					<div class="choose-container">
						<h2 class="choose-title">Chọn thông tin vé</h2>
						<div class="choose-date">
							<h3 class="choose-date-label">Chọn ngày</h3>
							<div class="choose-date-picker">
								<input class="choose-date-picker-input" id="basicDate" data-input placeholder="Chọn ngày">
								</input>
							</div>
						</div>
						<div class="select-amount">
							<h3 class="choose-date-label">Chọn số lượng vé</h3>
							<div class="tickets">
								<div class="tickets-group">
									<div class="ticket-type">
										<div class="ticket-type-desc">
											<div class="ticket-type-desc-title">Người lớn (Trên 12 tuổi)</div>
											<div class="price-container">
												<div class="price-value">80.000đ</div>
											</div>
										</div>
										<div class="stepper">
											<button class="minus-btn" type="button" disabled>-</button>
											<span class="count">0</span>
											<button class="plus-btn" type="button">+</button>
										</div>
									</div>
									<div class="ticket-type">
										<div class="ticket-type-desc">
											<div class="ticket-type-desc-title">Trẻ em (Từ 2-11 tuổi)</div>
											<div class="price-container">
												<div class="price-value">60.000đ</div>
											</div>
										</div>
										<div class="stepper">
											<button class="minus-btn" type="button" disabled>-</button>
											<span class="count">0</span>
											<button class="plus-btn" type="button">+</button>
										</div>
									</div>
									<div class="ticket-type">
										<div class="ticket-type-desc">
											<div class="ticket-type-desc-title">Trẻ em (Dưới 2 tuổi)</div>
											<div class="price-container">
												<div class="price-value">Miễn phí</div>
											</div>
										</div>
										<div class="stepper">
											<button class="minus-btn" type="button" disabled>-</button>
											<span class="count">0</span>
											<button class="plus-btn" type="button">+</button>
										</div>
									</div>
								</div>
							</div>
						</div>
						<div class="btn-container">
							<button class="add-btn" type="submit">Thêm vào giỏ hàng</button>
							<button class="back-btn">Quay lại</button>
						</div>
					</div>
				</form>
			</div>
			<jsp:include page="cart.jsp"></jsp:include>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
	
	
	<script>
	$("#basicDate").flatpickr({
	    enableTime: false,
	    minDate: "today",
	    dateFormat: "d-m-Y"
	});
	</script>
</body>
</html>