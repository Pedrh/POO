<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Livro</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br/>
	<div align="center" class="container">
		<form action="livro" method="post">
			<p class="title"> 
				<b>Livro</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="number" min="0" step="1" id="codigo"
						name="codigo" placeholder="Codigo"
						value='<c:out value="${livro.codigo }"></c:out>'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
					value='<c:out value="${livro.nome }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data_id" type="number" min="0" step="1" id="qtdPaginas" name="qtdPaginas" placeholder="Pags"
					value='<c:out value="${livro.qtdPaginas }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data_id" type="text" id="isbn" name="isbn" placeholder="ISBN"
					value='<c:out value="${livro.isbn }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data_id" type="number" min="0" step="1" id="edicao" name="edicao" placeholder="Edicao"
					value='<c:out value="${livro.edicao }"></c:out>'>
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
		<c:if test="${not empty livros }">
			<table class="table_round"> 
				<thead>
					<tr>
						<th>Codigo </th>
						<th>Nome </th>
						<th>Qtd Paginas </th>
						<th>ISBN </th>
						<th>Edicao </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="l" items="${livros }">
						<tr>
							<td><c:out value="${l.codigo }"></c:out> </td>
							<td><c:out value="${l.nome }"></c:out> </td>
							<td><c:out value="${l.qtdPaginas }"></c:out> </td>
							<td><c:out value="${l.isbn }"></c:out> </td>
							<td><c:out value="${l.edicao }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>