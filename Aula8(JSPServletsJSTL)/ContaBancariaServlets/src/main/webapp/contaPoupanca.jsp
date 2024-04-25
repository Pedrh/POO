<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Conta Bancaria - Poupança</title>
</head>
<body>
	<div align="center">
		<p class="title"><b>Criação de Conta Poupança</b></p>	
	</div>
	<jsp:include page="menu.jsp" />
	<br />
	<c:if test="${not empty saida}">
		<div>
			<H1 align="center"><c:out value="${saida}" /></H1>
		</div>
	</c:if>
	<br />
	<div class="container" align="center">
		<form action="poupanca" method="post">
			<table>
				<tr>
					<h2> Cadastrar cliente</h2>	
					<td>
						<input class="input_data" type="text" id="nome" name="nome" 
						placeholder="Nome do cliente">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_numConta" type="number" min="0" id="numConta" name="numConta" 
						placeholder="Numero da Conta">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_numConta" type="number" id="rendimentoDia" name="rendimentoDia" 
						placeholder="Rendimento diario">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_valor" type="number" id="saldo" name="saldo" 
						placeholder="Saldo">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" id="enviar" name="enviar" value="Enviar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div class="container" align="center">
		<form action="poupanca" method="post">
			<table>
				<tr>
					<h2> Encontrar cliente</h2>	
					<td>
						<input class="input_numConta" type="number" min="0" id="posicao" name="posicao" 
						placeholder="Posicao na lista">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" id="enviar" name="enviar" value="Encontrar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<br />
	<br />
	<div class="container" align="center">
		<form action="poupanca" method="post">
			<table>
				<tr>	
					<h2> Realizar saque</h2>
					<td>
						<input class="input_numConta" type="number" min="0" id="posicao" name="posicao" 
						placeholder="Posicao na lista">
					</td>
				</tr>
				<tr>
					<td>
						<input class="input_saldo" type="number" min="0" id="valorSaque" name="valorSaque" 
						placeholder="Valor do saque">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" id="enviar" name="enviar" value="Sacar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	
	<br />
	<br />
	<div class="container" align="center">
		<form action="poupanca" method="post">
			<table>
				<tr>	
					<h2> Realizar Deposito</h2>
					<td>
						<input class="input_numConta" type="number" min="0" id="posicao" name="posicao" 
						placeholder="Posicao na lista">
					</td>
				</tr>
				<tr>
					<td>
						<input class="input_saldo" type="number" min="0" id="valorDep" name="valorDep" 
						placeholder="Valor do deposito">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" id="enviar" name="enviar" value="Depositar">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div class="container" align="center">
		<form action="poupanca" method="post">
			<table>
				<tr>	
					<h2> Calcular novo saldo</h2>
					<td>
						<input class="input_numConta" type="number" min="0" id="posicao" name="posicao" 
						placeholder="Posicao na lista">
					</td>
				</tr>
				<tr>
					<td align="center">
						<input type="submit" id="enviar" name="enviar" value="Calcular">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
</body>
</html>