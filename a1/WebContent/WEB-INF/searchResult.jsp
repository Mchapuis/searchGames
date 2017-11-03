<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Search result</title>
<link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="post" action="searchResult">
	<fieldset>
	<legend>Search Result</legend>
	<!-- Show what option the user took to search game -->
		<c:set var = "myOption" scope = "session" value = "${optionChosen}"/>
		<c:set var = "id" scope = "session" value="${0}"/>
		<c:if test="${myOption != null }" >
			<p class="searchResult">
			Result of search with <c:out value="${optionChosen}" />   -------------  <a href="search">other search?</a>
			
			</p>
		</c:if>
		<table>
		
		<!-- Print the result of the query -->
		<c:forEach items="${gameList}" var="i">
			<tr>
			<td>
				<p>
				${ i.getGameTitle() } 
				</p>
			</td>
			<td>
				<p>
				${ i.getReleaseDate() }
				</p>
			</td>
			<td>
				<a href="details?param=${ i.getId() }">Details...</a>
			</td>
			</tr>
		</c:forEach>
		
		</table>
		<p value="badQuery" id="badQuery">${badQuery }</p> 
		
		
	</fieldset>
	
	<fieldset>
	<legend>Specials</legend>
	<p>
	
	<a href="specials?optionValue=gameTitle&search='Mario'">List of discounts</a>
	</p>
	
</fieldset>
</form>
</body>
</html>