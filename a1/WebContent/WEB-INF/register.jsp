<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>

<head>

    <meta charset="utf-8" />
    <title>Register</title>
    <link type="text/css" rel="stylesheet" href="style.css" />

</head>

<body>

<form method="post" action="register">

    <fieldset>

    <legend>Register</legend>
    <p>please fill this form:</p>
    
    <label for="userId">User name<span class="required">*</span></label>
    <input type="text" id="userId" name="userId" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['userId']}</span>

                
    <br />

    <label for="firstName">first name<span class="required">*</span></label>
    <input type="text" id="firstName" name="firstName" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['firstName']}</span>

    <br />

    <label for="lastName">last name<span class="required">*</span></label>
    <input type="text" id="lastName" name="lastName" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['lastName']}</span>
    <br />
    
    <label for="email">Email <span class="required">*</span></label>
    <input type="text" id="email" name="email" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['email']}</span>
    <br />
    <!--  this is for later 
    <label for="password">password<span class="required">*</span></label>
    <input type="text" id="password" name="password" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['password']}</span>
    <br />
    
   
    <label for="confirm">confirm password<span class="required">*</span></label>
    <input type="text" id="confirm" name="confirm" value="" size="50" maxlength="100" />
	<span class="errors">${form.errors['confirm']}</span>
    <br /> 
	-->
    <label for="address1">address1</label>
    <input type="text" id="address1" name="address1" value="" size="50" maxlength="150" />
	<span class="errors">${form.errors['address1']}</span>
    <br />
    
    <label for="address2">address2</label>
    <input type="text" id="address2" name="address2" value="" size="50" maxlength="150" />

    <br />
    
    <label for="city">city</label>
    <input type="text" id="city" name="city" value="" size="50" maxlength="150" />

    <br />
    
    <label for="state">state</label>
    <input type="text" id="state" name="state" value="" size="50" maxlength="150" />

    <br />
    
    <label for="zip">zip</label>
    <input type="text" id="zip" name="zip" value="" size="50" maxlength="150" />

    <br />

	<label for="country">country</label>
    <input type="text" id="country" name="country" value="" size="50" maxlength="150" />

    <br />

	<label for="credit_card_type">credit card type</label>
    <input type="text" id="credit_card_type" name="credit_card_type" value="" size="50" maxlength="150" />

    <br />
    
    <label for="credit_card_number">credit card number</label>
    <input type="text" id="credit_card_number" name="credit_card_number" value="" size="50" maxlength="150" />

    <br />

	<label for="credit_card_cvv">credit card cvv</label>
    <input type="text" id="credit_card_cvv" name="credit_card_cvv" value="" size="50" maxlength="150" />

    <br />
    
	<label for="credit_card_expiry">credit card expiry date</label>
    <input type="text" id="credit_card_expiry" name="credit_card_expiry" value="" size="50" maxlength="150" />

    <br />
    <input type="submit" value="Register" class="noLabel" /> 
    <br />
    
    <!-- Print if the form was processed correclty or not -->
    <p class="errors">${ form.getResult() }</p>
    <a href="login">login</a>
    
    </fieldset>

</form>

</body>

</html>