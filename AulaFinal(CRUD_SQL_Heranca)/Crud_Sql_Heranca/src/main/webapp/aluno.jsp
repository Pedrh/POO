<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Aluno</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br/>
	<div align="center" class="container">
		<form action="aluno" method="post">
			<p class="title"> 
				<b>Aluno</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_ra" type="number" min="0" step="1" id="ra"
						name="ra" placeholder="RA"
						value='<c:out value="${aluno.ra }"></c:out>'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
					value='<c:out value="${aluno.nome }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="email" name="email" placeholder="Email"
					value='<c:out value="${aluno.email }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="botao" name="botao" value="Cadastrar">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Alterar">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Excluir">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Consultar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br/>
	<div align="center">
		<c:if test="${not empty erro }">
			<H2><b><c:out value="${erro }" /> </b></H2>
		</c:if>
	</div>
	<br/>
	<div align="center">
		<c:if test="${not empty saida }">
			<H3><b><c:out value="${saida }" /> </b></H3>
		</c:if>
	</div>
	<br/>
	<div align="center">
		<c:if test="${not empty alunos }">
			<table class="table_round"> 
				<thead>
					<tr>
						<th>RA </th>
						<th>Nome </th>
						<th>Email </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${alunos }">
						<tr>
							<td><c:out value="${a.ra }"></c:out> </td>
							<td><c:out value="${a.nome }"></c:out> </td>
							<td><c:out value="${a.email }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>