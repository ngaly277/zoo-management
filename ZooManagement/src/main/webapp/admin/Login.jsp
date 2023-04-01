<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <!-- Design by foolishdeveloper.com -->
    <title>Sign in-Sign up</title>
 
    <link rel="preconnect" href="https://fonts.gstatic.com">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.15.4/css/all.min.css">
    <link href="https://fonts.googleapis.com/css2?family=Poppins:wght@300;500;600&display=swap" rel="stylesheet">
    
       <link href='<c:url value="/resources/css/style-login.css" />' rel="stylesheet" type ="text/css"> 
       <style>
  .bg-img { background-image: url('<c:url value="/resources/images/panda.png" />'); }
    .bg-img2 { background-image: url('<c:url value="/resources/images/tiger.png" />'); }
</style>
</head>
<body>/
    <div class="background">
        <div class="shape"></div>
        <div class="shape"></div>
    </div>
    <div class="bg-img">
    <div class="bg-img2">
    </div>
    <form:form modelAttribute="account" action = "processLogin" method = "post">
        <h3>Login Here</h3>

        <label for="username">Username</label>
        <form:input type="text" path="username" placeholder="Username" id="Username" name = "Username"/>

        <label for="password">Password</label>
        <form:input type="password" path="password" placeholder="Password" id="Password" name = "Password"/>
        <button type = "submit">Log In</button>
        <div class="checkbox-wrapper-54">
		  <label class="switch">
    		<input type="checkbox" id = "check" name = "check">
    		<span class="slider"></span>
  		 </label>
		</div>
		<br>
		<br>
		<p>&emsp;&emsp;&emsp;&ensp;Remember me?</p>
        <br>	
		<br>
   		<p>
   		 Don't have account?
    		<a href="Register.jsp">
        		Sign up
    		</a>
    			here
		</p>
        <div class="social">
          <div class="go"><i class="fab fa-google"></i>  Google</div>
          <div class="fb"><i class="fab fa-facebook"></i>  Facebook</div>
        </div>
    </form:form>
    </div>
</body>
</html>
