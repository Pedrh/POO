<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Jogador</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br/>
	<div align="center" class="container">
		<form action="jogador" method="post">
			<p class="title"> 
				<b>Jogador</b>
			</p>
			<table>
				<tr>
					<td colspan="3">
						<input class="input_data_id" type="number" min="0" step="1" id="codigo"
						name="codigo" placeholder="Codigo">
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="date" id="dataNasc" name="dataNasc">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="number" min="0" step="0.01" id="altura" name="altura" placeholder="Altura">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="number" min="0" step="0.1" id="peso" name="peso" placeholder="Peso">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<select class="input_data" id="time" name="time"> 
						<option value="0">Escolha um time</option>
						<c:forEach var="t" items="${times }">
							<option value="${t.codigo }">
								<c:out value="${t }" />
							</option>
						 </c:forEach>
					</select>
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
		<c:if test="${not empty jogadores }">
			<table class="table_round"> 
				<thead>
					<tr>
						<th>Codigo</th>
						<th>Nome</th>
						<th>Time</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" items="${jogadores }">
						<tr>
							<td><c:out value="${j.id }"></c:out> </td>
							<td><c:out value="${j.nome }"></c:out> </td>
							<td><c:out value="${j.time }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>