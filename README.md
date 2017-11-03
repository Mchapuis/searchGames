# searchGames
web project to search games from a database


##### Game search website

* using servlet, jsp, java *

A user can login, register, search games and see their description

### Description of main files

Web Pages    | Servlet/Java code    | Model/Java code    | View/JSP
-------------| -------------------- | ------------------ | -------------
Login     | Login.java        | LoginForm.java  | login.jsp
Registration | Register.java  | RegisterForm.java | register.jsp
Search | Search.java | SearchParse.java |search.java
Search Result | SearchResult.java | N/A | searchResult.jsp
Specials | specials.java | N/A | specials.jsp
Details | Details.java | N/A | Details.jsp


## Create the Database

The java file *Database.java* is using the .xml files to create a database called **a1_soen387** and tables called **gameData** and **user**
*important*: if the database is already created, you can't run this file again ( or you can update the code to make it work )

If you need to change the user and password to access your database, you need to change USER and PASSWORD static String in several files.
* line 86 and 87 in LoginForm.java
* line 225 and 226 in RegisterForm.java

# XML files content

Information is from the open source website [GameDB API][http://wiki.thegamesdb.net/index.php/API_Introduction]

**each folder contain information for 5 games**

* zelda 1
* fish 2
* mario 3
* miami 4
* myst 5
* rabbit 6
* red 7
* sky 8
* tokyo 9
* batman 10
* boy 11
* car 12
* creed 13
* diablo 14

**In each folder there are 5 full descriptions and 5 artifacts description**


Cheers!