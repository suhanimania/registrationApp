<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@include file ="menu.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>update</title>
</head>
<body>
      <h2>UPDATE REGISTRATION</h2>
      <form action="update" method="post">
      <pre>
      Email<input type ="text" name="email"value="<%=request.getAttribute("email")%>"/>
      Mobile<input type ="text" name="mobile"value="<%=request.getAttribute("mobile")%>"/> 
      <input type="submit" value="update"/>
      </pre>
      
      </form>
     
</body>
</html>