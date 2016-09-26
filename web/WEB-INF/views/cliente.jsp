<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
    head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<title>Sistema de Clientes</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>          

</head>
<body>
	<h2>Sistema de Clientes</h2>
	<p>
		<a href="/Rafael_Viana_AV1/novo-cliente">Novo Cliente</a> <a href="/Rafael_Viana_AV1/novo-pedido">Novo
			Pedido</a>
	</p>
	<div id="content" class="col-lg-8">
		<table class="table table_list">
			<thead>
				<tr>
					<th>ID</th>
					<th>nome</th>
					<th>cpf</th>
					<th>Endereco</th>
					<th>telefone</th>

					<th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${clientes}" var="cliente">
					<tr>
						<td><c:out value="${cliente.id}" /></td>
						<td><c:out value="${cliente.nome}" /></td>
						<td><c:out value="${cliente.CPF}" /></td>
						<td><c:out value="${cliente.endereco}" /></td>
						<td><c:out value="${cliente.telefone}" /></td>

						<td><a href="/Rafael_Viana_AV1/editar-cliente?id=<c:out value="${cliente.id }"/>">Editar</a></td>
						<td><a href="/Rafael_Viana_AV1/excluir-cliente?id=<c:out value="${cliente.id}"/>">Excluir</a></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>