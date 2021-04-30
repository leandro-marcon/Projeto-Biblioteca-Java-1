<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Usuario</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaUsuarios.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Código</th>
					<th>Nome</th>
					<th>Data de Nascimento</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:forEach var="c" items="${listaUsuarios}">
					<tr>
						<td>${c.codigo}</td>
						<td>${c.nome}</td>
<%-- 						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dataNasc}"/></td> --%>
						<td><a href="usuarioEdit/${c.id}">Edit</a></td>
						<td><a href="usuarioDelete/${c.id}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		 Percebam que aqui no action eu to passando qual a página que elevai mandar os dados depois que eu clicar no botao
				<form action="/Biblioteca/usuarioSave" method="POST" modelAttribute="usuario">
					<form:hidden path="usuario.codigoUser" />

<!-- 			<p> -->
<!-- 				Código: -->
<%-- 				<form:input path="usuario.codigoUser" /> --%>

<!-- 			</p> -->

			<p>
						Nome:
						<form:input path="usuario.nome" />

					</p>

<!-- 					<p> -->
<!-- 						Sobrenome: -->


<!-- 					</p> -->
					
					<p>
					 


					</p>

					<input type="submit" value="Salvar" />

				</form>
		</div> 


		<a href="/Biblioteca"> voltar</a>
</body>
</html>