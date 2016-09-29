<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>           
<script src="${pageContext.request.contextPath}/resources/js/main.js" type="text/javascript" ></script>
<title>Sisfiscon</title>
</head>
<body>
	<h2>Sisfiscon</h2>
        <p><a href="${pageContext.request.contextPath}/">Pagina inicial</a></p>
	<p>
		<a href="${pageContext.request.contextPath}/novo-fornecedor">Novo Fornecedor</a> 
                
	</p>
	<div id="content" class="col-lg-8">
		<table class="table table_list">
			<thead>
				<tr>
					<th>ID</th>
					<th>CNPJ</th>
					<th>Razao Social</th>
					<th>Inscricao Municipal</th>
                                        <th>Receita Bruta</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${fornecedores}" var="fornecedor">
					<tr>
						<td><c:out value="${fornecedor.id}" /></td>
						<td><c:out value="${fornecedor.CNPJ}" /></td>
						<td><c:out value="${fornecedor.razaoSocial}" /></td>
						<td><c:out value="${fornecedor.inscricaoMunicipal}" /></td>
						<td><c:out value="${fornecedor.receitaBruta}" /></td>
                                                                                      
						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>