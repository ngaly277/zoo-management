<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Đăng nhập</title>
</head>
<body>
	<div class="login">
		<div class="login-form">
			<h3>Đăng nhập</h3>
			<form>
				<div class="mb-3">
				    <label for="username" class="form-label">Tên đăng nhập</label>
				    <input path="username" type="text" class="form-control" id="username" name="username"/>
				</div>
				<div class="mb-3">
				    <label for="password" class="form-label">Mật khẩu</label>
				    <input path="password" type="text" class="form-control" id="password" name="password"/>
				</div>
				
			  <button type="submit" class="btn btn-primary">Đăng nhập</button>
			</form>
		</div>
	</div>
</body>
</html>