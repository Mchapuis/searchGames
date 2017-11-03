<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>search game</title>
 <link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="post" action="search">
	<fieldset>
	
	<legend>Search </legend>
		<select id="optionValue" name="optionValue" class="searchOp" >
			<option value="gametitle">Game title</option> 
			<option value="releaseDate">release date</option>
			<option value="platform">platform</option>
			<option value="Overview">overview</option>
			<option value="number_players">number of players</option>
			<option value="coop">coop</option>
			<option value="genre">genre</option>
			<option value="developer">developer</option>
			<option value="publisher">publisher</option>
		</select>
		<input type="text" name="search" id="search" value="" size="50" maxlength="100" />
		<br/>
		
		<p type="submit" value="search" class="noLabel"></p>
		
		
	</fieldset>
</form>



</body>
</html>