<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Tests JDBC<title>
<link type="text/css" rel="stylesheet" href="<c:url value="/inc/form.css"/>" />
</head>
<body>
	<h1>Tests JDBC</h1>
	<c:forEach items="$ { messages }" var="message" varStatus="boucle">
		<p>${ boucle.count }. ${message }</p>
	</c:forEach>

</body>
</html>