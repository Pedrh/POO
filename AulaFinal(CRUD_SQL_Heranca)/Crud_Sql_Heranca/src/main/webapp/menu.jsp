<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title></title>
</head>
<body>
<nav id="menu">
		<ul>
			<li> <a href="index.jsp">Home</a>
	   		<li> <a href="${pageContext.request.contextPath}/livro">Livro</a>
			<li> <a href="${pageContext.request.contextPath}/revista">Revista</a> 
	   		<li> <a href="${pageContext.request.contextPath}/aluguel">Aluguel</a>
			<li> <a href="${pageContext.request.contextPath}/aluno">Aluno</a> 
		</ul>
	</nav>
</body>
</html>