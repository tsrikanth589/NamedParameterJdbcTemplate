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
	<form action="${pageContext.request.contextPath}/customers/delete" method="post">
		<div class="form-group row">
	        <label for="customerId" class="col-sm-2 col-form-label">ID</label>
	        <div class="col-sm-2">
	            <input type="text" class="form-control" id="customerId" name="customerId">
	        </div>
	    </div>
	    
	    <div class="form-group row">
	        <div class="col-sm-2 offset-sm-2">
	            <button type="submit" class="btn btn-primary">Delete</button>
	        </div>
	    </div>
	</form>
	<script src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/popper.min.js"></script>
	<script src="${pageContext.request.contextPath}/js/bootstrap.min.js"></script>
	
</body>
</html>