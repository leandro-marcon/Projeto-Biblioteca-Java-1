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
<<<<<<< HEAD
					<th>Email</th>
=======
					<th>E-mail</th>
>>>>>>> 5c673c229f677506cd09a6d0058dbb19132ae1a2
					<th>Data Nascimento</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:forEach var="c" items="${listaUsuarios}">
					<tr>
						<td>${c.codigoUser}</td>
						<td>${c.nome}</td>
						<td>${c.email}</td>
<<<<<<< HEAD
					
					<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dtNascimento}"/></td>
=======
						<td><fmt:formatDate pattern = "dd/MM/yyyy" value = "${c.dtNascimento}"/></td>

>>>>>>> 5c673c229f677506cd09a6d0058dbb19132ae1a2
						<td><a href="usuarioEdit/${c.codigoUser}">Edit</a></td>
						<td><a href="usuarioDelete/${c.codigoUser}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		  <h3>CADASTRAR USUARIO</h3>
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
					
					<p>

<<<<<<< HEAD
					Email:
						<form:input path="usuario.email" />

					</p> 
					
					<p>
					 
					Data Nascimento:
					<form:input type="date" path="usuario.dtNascimento" />
=======
					<p>
						E-mail:
						<form:input path="usuario.email" />


					</p>
					
					<p>
					 	Data de Nascimento:
					 	<form:input type="date" path="usuario.dtNascimento"/>

>>>>>>> 5c673c229f677506cd09a6d0058dbb19132ae1a2

					</p>

					<input type="submit" value="Salvar" />

				</form>
		</div> 


		<a href="/Biblioteca"> voltar</a>
</body>
</html>