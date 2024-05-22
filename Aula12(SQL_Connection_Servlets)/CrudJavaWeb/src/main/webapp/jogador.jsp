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
						name="codigo" placeholder="Codigo"
						value='<c:out value="${jogador.id }"></c:out>'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="text" id="nome" name="nome" placeholder="Nome"
					value='<c:out value="${jogador.nome }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="date" id="dataNasc" name="dataNasc"
					value='<c:out value="${jogador.dataNasc }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="number" min="0" step="0.01" id="altura" name="altura" placeholder="Altura"
					value='<c:out value="${jogador.altura }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="number" min="0" step="0.01" id="peso" name="peso" placeholder="Peso"
					value='<c:out value="${jogador.peso }"></c:out>'>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<select class="input_data" id="time" name="time"> 
						<option value="0">Escolha um time</option>
						<c:forEach var="t" items="${times }">
							<c:if test="${(empty jogador) || (t.codigo ne jogador.time.codigo) }">
								<option value="${t.codigo }">
									<c:out value="${t }" />
								</option>
							</c:if>
							<c:if test="${t.codigo eq jogador.time.codigo }">
								<option value="${t.codigo }" selected="selected">
									<c:out value="${t }" />
								</option>
							</c:if>
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
						<input type="submit" id="botao" name="botao" value="Listar">
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
						<th>Codigo </th>
						<th>Nome </th>
						<th>Data Nascimento </th>
						<th>Altura </th>
						<th>Peso </th>
						<th>Time </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="j" items="${jogadores }">
						<tr>
							<td><c:out value="${j.id }"></c:out> </td>
							<td><c:out value="${j.nome }"></c:out> </td>
							<td><c:out value="${j.dataNasc }"></c:out> </td>
							<td><c:out value="${j.altura }"></c:out> </td>
							<td><c:out value="${j.peso }"></c:out> </td>
							<td><c:out value="${j.time }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>