<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
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
    <form:form action = "login" method = "post" modelAttribute="account" onsubmit = "return(validate());">
        <h3>Login Here</h3>
		<span id="password-invalid" style="color: #eb1c26; margin-top: 10px;">${error }</span>
		
        <label for="username">Username</label>
        <form:input path="username" type="text" placeholder="Username" id="username" name = "username" />
		<span id="username-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Please fill out this field.</span>
        <label for="password">Password</label>
        <form:input path="password" type="password" placeholder="Password" id="password" name = "password" />
        <span id="password-invalid" style="color: #eb1c26; margin-top: 10px; display:none">Please fill out this field.</span>
        
        <button type = "submit">Log In</button>
        <div class="checkbox-wrapper-54">
		  <label class="switch">
    		<input type="checkbox" id = "remember" name = "remember">
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
        <!-- <div class="social">
          <div class="go"><i class="fab fa-google"></i>  Google</div>
          <div class="fb"><i class="fab fa-facebook"></i>  Facebook</div>
        </div> -->
    </form:form>
    </div>
    <script>
    	function validate() {
    		if( document.getElementById("username").value == "" ) {
	            document.getElementById("username").classList.add("is-invalid");
	            document.getElementById("username-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("username").classList.remove("is-invalid");
	            check = true;
	         }
			
			if( document.getElementById("password").value == "" ) {
	            document.getElementById("password").classList.add("is-invalid");
	            document.getElementById("password-invalid").style.display = "block";
	            check = false;
	         } else {
	            document.getElementById("password").classList.remove("is-invalid");
	            check = true;
	         }
			
			return check;
    	}
    </script>
</body>
</html>
