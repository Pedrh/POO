<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" href="./css/styles.css">
<title>Calculo de imposto</title>
</head>
<body>
	<div align="center">
		<p class="title"><b>Calculo de imposto</b></p>	
	</div>
	<c:if test="${not empty saida}">
		<H1 align="center"><c:out value="${saida}" /></H1>
	</c:if>
	<div class="container" align="center">
		<form action="impostossimples" method="post">
			<table>
				<tr>	
					<h2>São Paulo</h2>	
					<td>
						<input class="input_data" type="number" min="0" id="areaTotal" name="areaTotal" 
						placeholder="Area total">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_numConta" type="number" min="0" id="numComodos" name="numComodos" 
						placeholder="Numero da Comodos">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="enviar" name="enviar" value="Calcular SP">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div class="container" align="center">
		<form action="impostossimples" method="post">
			<table>
				<tr>	
					<h2>Belo Horizonte</h2>	
					<td>
						<input class="input_data" type="number" min="0" id="areaTotal" name="areaTotal" 
						placeholder="Area total">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_numConta" type="number" min="0" id="numQuartos" name="numQuartos" 
						placeholder="Numero da quartos">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="enviar" name="enviar" value="Calcular BH">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div class="container" align="center">
		<form action="portoalegre" method="post">
			<table>
				<tr>	
					<h2>Porto Alegre</h2>	
					<td>
						<input class="input_data" type="number" min="0" id="areaTotal" name="areaTotal" 
						placeholder="Area total">
					</td>
				</tr>
				<tr>	
					<td>
						<p class="garagem">Tem garagem <input type="checkbox" id="garagem" name="garagem" 
						placeholder="Tem garagem"></p>
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_data" type="number" min="0" id="areaGaragem" name="areaGaragem" 
						placeholder="Area da garagem (caso exista)">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="enviar" name="enviar" value="Calcular PA">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
	<div class="container" align="center">
		<form action="curitiba" method="post">
			<table>
				<tr>	
					<h2>Curitiba</h2>	
					<td>
						<input class="input_data" type="number" min="0" id="areaTotal" name="areaTotal" 
						placeholder="Area total">
					</td>
				</tr>
				<tr>	
					<td>
						<input class="input_numConta" type="number" min="0" id="idadeImovel" name="idadeImovel" 
						placeholder="Idade do imóvel">
					</td>
				</tr>
				<tr>
					<td>
						<input type="submit" id="enviar" name="enviar" value="Calcular Curitiba">
					</td>
				</tr>
			</table>
		</form>
	</div>
	<br />
	<br />
</body>
</html>