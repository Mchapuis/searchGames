<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>List of Specials</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="post" action="specials">

    <fieldset>
    <legend>List </legend>
    <table>
    	<tr>
    	<td><p>
    	${ gameList.get(1).getGameTitle() }
    	</p> 
    	</td>
    	<td><p>
    	${gameList.get(1).getReleaseDate()}
    	</p>
    	</td>
    	<td><p>
    	${gameList.get(1).getPlatform()}
    	</p>
    	</td>
    	<td><p> 30% off!
    	</p>
    	</td>
    	</tr>
    	
    	<tr>
    	<td><p>
    	${gameList.get(2).getGameTitle()}
    	</p>
    	</td>
    	<td><p>
    	${gameList.get(2).getReleaseDate()}
    	</p>
    	</td>
    	<td><p>
    	${gameList.get(2).getPlatform()}
    	</p>
    	</td>
    	<td><p> 20% off!
    	</p>
    	</td>
    	</tr>
    	
    	<tr>
    	<td><p>
    	${gameList.get(3).getGameTitle()}
    	</p>
    	</td>
    	<td><p>
    	${gameList.get(3).getReleaseDate()}
    	</p>
    	</td>
    	<td><p>
    	${gameList.get(3).getPlatform()}
    	</p>
    	</td>
    	<td><p> 15% off!
    	</p>
    	</td>
    	</tr>
    </table>
    
    
    </fieldset>
    
</form>
<fieldset>
<legend> Back </legend>
<a href="search">Search</a>
</fieldset>

</body>
</html>