<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Insert title here</title>
</head>
<body>
	<nav id="menu">
		<ul>
			<li><a href="index.jsp">Home</a></li>
			<li><a href="${pageContext.request.contextPath }/pessoa">Cadastro</a></li> <!-- Puxa localHost:8080.... e o ServLet. Ele vem do get pelo caso -->
		</ul>
	</nav>
</body>
</html>