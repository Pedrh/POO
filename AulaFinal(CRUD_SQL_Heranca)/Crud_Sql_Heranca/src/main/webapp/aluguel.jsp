<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Aluguel</title>
</head>
<body>
	<div>
		<jsp:include page="menu.jsp" />
	</div>
	<br/>
	<div align="center" class="container">
		<form action="aluguel" method="post">
			<p class="title"> 
				<b>Alugar</b>
			</p>
			<table>
				<tr>
					<td colspan="4">
					<select class="input_data" id="aluno" name="aluno"> 
						<option value="0">Escolha um Aluno</option>
						<c:forEach var="a" items="${alunos }">
							<c:if test="${(empty aluguel) || (a.ra ne aluguel.aluno.ra) }">
								<option value="${a.ra }">
									<c:out value="${a }" />
								</option>
							</c:if>
							<c:if test="${a.ra eq aluguel.aluno.ra }">
								<option value="${a.ra }" selected="selected">
									<c:out value="${a }" />
								</option>
							</c:if>
						 </c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<select class="input_data" id="exemplar" name=exemplar> 
						<option value="0">Escolha um Exemplar</option>
						<c:forEach var="e" items="${exemplares }">
							<c:if test="${(empty aluguel) || (e.codigo ne aluguel.exemplar.codigo) }">
								<option value="${e.codigo }">
									<c:out value="${e }" />
								</option>
							</c:if>
							<c:if test="${e.codigo eq aluguel.exemplar.codigo }">
								<option value="${e.codigo }" selected="selected">
									<c:out value="${e }" />
								</option>
							</c:if>
						 </c:forEach>
					</select>
					</td>
				</tr>
				<tr>
					<td colspan="3">
					<input class="input_data" type="date" id="dataRetirada" name="dataRetirada"
					value='<c:out value="${aluguel.dataRetirada }"></c:out>'>
					</td>
					<td>
						<input type="submit" id="botao" name="botao" value="Buscar">
					</td>
				</tr>
				<tr>
					<td colspan="4">
					<input class="input_data" type="date" id="dataDevolucao" name="dataDevolucao"
					value='<c:out value="${aluguel.dataDevolucao }"></c:out>'>
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
		<c:if test="${not empty alugueis }">
			<table style="border: 1px solid black; border-radius: 4px;"> 
				<thead>
					<tr>
						<th>Aluno </th>
						<th>Exemplar </th>
						<th>Data Retirada </th>
						<th>Data Devolucao </th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="a" items="${alugueis }">
						<tr>
							<td style="border: 1px solid black; border-collapse: collapse; border-radius: 4px;"><c:out value="${a.aluno }"></c:out> </td>
							<td style="border: 1px solid black; border-collapse: collapse; border-radius: 4px;"><c:out value="${a.exemplar }"></c:out> </td>
							<td style="border: 1px solid black; border-collapse: collapse; border-radius: 4px;"><c:out value="${a.dataRetirada }"></c:out> </td>
							<td style="border: 1px solid black; border-collapse: collapse; border-radius: 4px;"><c:out value="${a.dataDevolucao }"></c:out> </td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
		</c:if>
	</div>
</body>
</html>