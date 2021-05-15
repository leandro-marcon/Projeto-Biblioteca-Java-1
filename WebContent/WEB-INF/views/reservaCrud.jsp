<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Reserva</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaReservas.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Código</th>
					<th>Cliente</th>
					<th>Data Inicio</th>
					<th>Data Final</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:forEach var="c" items="${listaReservas}">
					<tr>
						<td>${c.codigoReserva}</td>
						<td>${c.dtInicio}</td>
						<td>${c.dtFinal}</td>
						<td>${c.usuario.nome}</td>


						<td><a href="reservaEdit/${c.codigoReserva}">Edit</a></td>
						<td><a href="reservaDelete/${c.codigoReserva}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<h3>CADASTRAR RESERVA</h3>
		<form action="/Biblioteca/reservaSave" method="POST"
			modelAttribute="reserva">
			<form:hidden path="reserva.codigoReserva" />

			<!-- 			<p> -->
			<!-- 				Código: -->
			<%-- 				<form:input path="livro.codigoReserva" /> --%>

			<!-- 			</p> -->

			<p>
				Usuário:
				
				<form:label path="reserva.usuario"></form:label>
				<form:select path="reserva.usuario.codigoUser">
					<form:option value="-1" label="--Selecione Usuário" />
					<form:options items="${listaUsuarios}" itemValue="codigoUser"
						itemLabel="nome" />
				</form:select>


			</p>

			<p>
				Data Inicio:
				<form:input path="reserva.dtInicio" />

			</p>

			<p>
				Data Final:
				<form:input path="reserva.dtFinal" />


			</p>


			<input type="submit" value="Salvar" />

		</form>
	</div>


	<a href="/Biblioteca"> voltar</a>
</body>
</html>