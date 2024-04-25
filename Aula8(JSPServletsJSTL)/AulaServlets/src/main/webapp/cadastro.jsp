<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Aula Servlets - Cadastro</title>
</head>
<body>

	<jsp:include page="menu.jsp" />
	
	<br />
	<div class="container" align="center">
		<form action="pessoa" method="post">
			<p class="title"><b>Cadastro de Pessoas</b></p>
			<table>
				<tr>
					<td>
						<input class="input_data_id" type="number" min="0" step="1" id="id" name="id" 
						placeholder="#ID">
					</td>
				</tr>				
				<tr>	
					<td>
						<input class="input_data" type="text" id="nome" name="nome" 
						placeholder="Nome">
					</td>
				</tr>
				<tr>
					<td>
						<input class="input_data_date" type="date" id="dataNasc" name="dataNasc" 
						placeholder="Data de nascimento">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="enviar" name="enviar" value="Enviar">
						<input type="submit" id="enviar" name="enviar" value="Listar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<c:if test="${not empty saida }"> <!-- Vai ler o retorno da acao no PessoaServlet -->
		<div align="center">
			<H1><c:out value="${saida }" /></H1>
		</div>
	</c:if>
	<c:if test="${not empty pessoas }">
		<div align="center">
			<table class="table_round">
				<thead>
					<tr>
						<th>#ID</th>
						<th>Nome</th>
						<th>Data de nascimento</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="p" items="${pessoas }">
						<tr>
							<td>${p.id }</td> 
							<td>${p.nome }</td>
							<td>${p.dataNasc }</td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</div>
		
	</c:if>
</body>
</html>