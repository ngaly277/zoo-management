<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<link href="<c:url value="/resources/css/style-tickets-page.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-add-ticket-order.css" />" rel="stylesheet">
<link href="<c:url value="/resources/css/style-payment.css" />" rel="stylesheet">
<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">
<title>Chào mừng bạn đến với Sở thú</title>
<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
</head>
<body>
	<jsp:include page="header-not-sticky.jsp"></jsp:include>
	
	<main class="main-container">
		<div class="content-container">
			<h1 class="content-title">Thông tin thanh toán</h1>
			<div class="warning-container">
			<div class="form-wrapper">
				<div class="message-container">
					<i class='fa fa-exclamation-circle' style='color:#0F9F6C;font-size:20px;margin-right:20px;'></i>
					<div style="font-size: 16px;">
						Bạn đã có tài khoản? 
						<a href="login">Đăng nhập</a>
						Chưa có tài khoản?
						<a href="#">Đăng ký ngay</a>
					</div>
				</div>
				<div class="payment">
					<h2 class="title-section">Thanh toán qua VNPAY</h2>
					<div class="payment-detail">
						Thanh toán trực tuyến qua VNPAY – Xác nhận tức thời – An toàn – Nhanh chóng
						</br>Hỗ trợ: Thanh toán quét mã VNPAY – Thẻ ATM và tài khoản ngân hàng – Thẻ thanh toán quốc tế VISA/Master Card – Ví điện tử VNPAY
					</div>
				</div>
				<div class="purchase-details">
					<h2 class="title-section">Thông tin khách hàng</h2>
					<form class="identity-form">
						<div class="form-input-group">
							<label class="form-input">
								<span class="label">Họ và tên</span>
								<input type="text" name="name" id="name" class="input" required/>
							</label>
							<label class="form-input">
								<span class="label">Địa chỉ</span>
								<input type="text" name="address" id="address" class="input" required/>
							</label>
							<label class="form-input">
								<span class="label">Số điện thoại</span>
								<input type="text" name="phone" id="phone" class="input" required/>
							</label>
							<label class="form-input">
								<span class="label">Email</span>
								<input type="email" name="email" id="email" class="input" required/>
							</label>
						</div>
					</form>
					
				</div>
				<div class="btn-container flex-end">
					<button class="back-btn" type="button" onclick="history.back();">Quay lại</button>
				</div>
			</div>
			</div>
			<jsp:include page="cart.jsp"></jsp:include>
		</div>
	</main>
	
	<jsp:include page="footer.jsp"></jsp:include>
</body>
</html>