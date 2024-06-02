<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Revista</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br/>
	<div align="center" class="container">
		<form action="revista" method="post">
			<p class="title"> 
				<b>Revista</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="number" min="0" step="1" id="codigo"
						name="codigo" placeholder="Codigo"
						value='<c:out value="${revista.codigo }"></c:out>'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
					value='<c:out value="${revista.nome }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data_id" type="number" min="0" step="1" id="qtdPaginas" name="qtdPaginas" placeholder="Pags"
					value='<c:out value="${revista.qtdPaginas }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data_id" type="text" id="issn" name="issn" placeholder="ISSN"
					value='<c:out value="${revista.issn }"></c:out>'>
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
		<c:if test="${not empty revistas }">
			<table class="table_round"> 
				<thead>
					<tr>
						<th>Codigo </th>
						<th>Nome </th>
						<th>Qtd Paginas </th>
						<th>ISSN </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="r" items="${revistas }">
						<tr>
							<td><c:out value="${r.codigo }"></c:out> </td>
							<td><c:out value="${r.nome }"></c:out> </td>
							<td><c:out value="${r.qtdPaginas }"></c:out> </td>
							<td><c:out value="${r.issn }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>