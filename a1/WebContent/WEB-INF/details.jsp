<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>  
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Details of game...</title>
 <link type="text/css" rel="stylesheet" href="style.css" />
</head>
<body>
<form method="post" action="details">
	<fieldset>
	
	<legend>Details of game</legend>

	
	<table style="width:100%">
		<tr>
			<th>Game Title</th>
			<td>${ game.getGameTitle()}</td>
		</tr>
		<tr>
			<th>Release Date</th>
			<td>${ game.getReleaseDate() }</td>
		</tr>
		<tr>
			<th>Platform</th>
			<td>${ game.getPlatform() }</td>
		</tr>
		<tr>
			<th>Overview</th>
			<td>${ game.getOverview() }</td>
		<tr>
			<th>Co-op</th>
			<td>${ game.getNum_players() }</td>
		</tr>
		<tr>
			<th>Genre</th>
			<td>${ game.getGenre() }</td>
		</tr>
		<tr>
			<th>Developer</th>
			<td>${ game.getDeveloper() }</td>
		</tr>
		<tr>
			<th>Publisher</th>
			<td>${ game.getPublisher() }</td>
		</tr>
		<tr>
			<th>Front box art</th>
			<td>
			<img style="max-height: 200px; max-width: 300px;" src="http://thegamesdb.net/banners/${ game.getFront_box_art() }"/>
			</td>
		</tr>
		<tr>
			<th>Back box art</th>
			<td>
			<img style="max-height: 200px; max-width: 300px;" src="http://thegamesdb.net/banners/${ game.getBack_box_art() }"/>
			</td>
		</tr>
		<tr>
			<th>Logo</th>
			<td>
			<img style="max-height: 200px; max-width: 300px;" src="http://thegamesdb.net/banners/${ game.getLogo() }"/>
			</td>
		</tr>
		<tr>
			<th>Developer Logo</th>
			<td>${ game.getDeveloper_logo() }</td>
		</tr>
		<tr>
			<th>Comments</th>
			<td>${ game.getComments() }</td>
		</tr>
	</table>
	
	
	</fieldset>
</form>
</body>
</html>