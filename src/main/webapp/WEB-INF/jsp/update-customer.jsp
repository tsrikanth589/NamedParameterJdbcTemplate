<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/bootstrap.min.css">
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
	<form action="${pageContext.request.contextPath}/customers/update" method="post">
		<div class="form-group row">
	        <label for="customerId" class="col-sm-2 col-form-label">ID</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="customerId" name="customerId">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="firstName" class="col-sm-2 col-form-label">First Name</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="firstName"  name="firstName">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="lastName" class="col-sm-2 col-form-label">Last Name</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="lastName" name="lastName">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="age" class="col-sm-2 col-form-label">Age</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="age" name="age">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="mobile" class="col-sm-2 col-form-label">Mobile</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="mobile" name="mobile">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="email" class="col-sm-2 col-form-label">Email</label>
	        <div class="col-sm-2">
	            <input type="email" class="form-control" id="email" name="email">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="homeAddress" class="col-sm-2 col-form-label">Home Address</label>
	        <div class="col-sm-2">
	        	<input type="text" class="form-control" id="homeAddressId" name="homeAddressId" placeholder="Address Id">
	        </div>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="homeAddress" name="homeAddress" placeholder="Address">
	        </div>
	    </div>
	    <div class="form-group row">
	        <label for="workAddress" class="col-sm-2 col-form-label">Work Address</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="workAddressId" name="workAddressId" placeholder="Address Id">
	        </div>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="workAddress" name="workAddress" placeholder="Address">
	        </div>
	    </div>
	    <div class="form-group row">
	        <div class="col-sm-2 offset-sm-2">
	            <button type="submit" class="btn btn-primary">Update</button>
	        </div>
	    </div>
	</form>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
</body>
</html>