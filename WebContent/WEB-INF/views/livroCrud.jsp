<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix = "fmt" uri = "http://java.sun.com/jsp/jstl/fmt" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Livro</title>
</head>
<body>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		<c:if test="${listaLivros.size() > 0}">
			<table border="2" width="70%" cellpadding="2">
				<tr>
					<th>Código</th>
					<th>Titulo</th>
					<th>Autor</th>
					<th>Ano Publicação</th>
					<th>Editar</th>
					<th>Deletar</th>
				</tr>
				<c:forEach var="c" items="${listaLivros}">
					<tr>
						<td>${c.codigoLivro}</td>
						<td>${c.titulo}</td>
						<td>${c.autor}</td>
						<td>${c.anoPublic}</td>
						

						<td><a href="livroEdit/${c.codigoLivro}">Edit</a></td>
						<td><a href="livroDelete/${c.codigoLivro}">Delete</a></td>
					</tr>
				</c:forEach>
			</table>
		</c:if>
	</div>

	<div
		style="position: relative; display: inline-block; width: 50%; margin-bottom: 40px; margin-left: 15%; border-collapse: collapse;">
		 <h3>CADASTRAR LIVRO</h3>
				<form action="/Biblioteca/livroSave" method="POST" modelAttribute="livro">
					<form:hidden path="livro.codigoLivro" />

<!-- 			<p> -->
<!-- 				Código: -->
<%-- 				<form:input path="livro.codigoUser" /> --%>

<!-- 			</p> -->

			<p>
						Titulo:
						<form:input path="livro.titulo" />

					</p>

					<p>
						Autor:
						<form:input path="livro.autor" />


					</p>
					
					<p>
					 	Ano Publicação:
					 	<form:input path="livro.anoPublic" />


					</p>

					<input type="submit" value="Salvar" />

				</form>
		</div> 


		<a href="/Biblioteca"> voltar</a>
</body>
</html>