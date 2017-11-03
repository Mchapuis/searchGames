<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Login</title>
 <link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>

<form method="post" action="login">

    <fieldset>

    <legend>Login</legend>
 	<label for="userId">User name<span class="required">*</span></label>
    <input type="text" id="userId" name="userId" value="" size="50" maxlength="100" />
	<br />
	<span class="errors">${login.errors['userId']}</span>

    <p>no passwords required for now...</p>
    
    <br />
    <input type="submit" value="login" class="noLabel" /> 
    <br />
    
    <!-- Print if the form was processed correclty or not -->
    <p class="errors">${login.getResult()}</p>
    <a href="register">or sign up here!</a>
    </fieldset>
    
</form>

<p></p>
</body>
</html>