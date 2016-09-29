<%-- 
    Document   : processo
    Created on : 28/09/2016, 17:25:59
    Author     : rafae
--%>

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
         <p><a href="${pageContext.request.contextPath}/">Pagina inicial</a></p>>
	<p><a href="${pageContext.request.contextPath}/novo-processo">Novo Processo</a></p>
	<div id="content" class="col-lg-8">
		<table class="table table_list">
			<thead>
				<tr>
					<th>numeroProcesso</th>
					<th>Razão Socia / CNPJ do Fornecedor</th>
					<th>Fiscal Responsável</th>
					<th>Data Relatorio</th>
                                        <th>Receita Bruta</th>
                                        <th colspan="2">Ações</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach items="${processos}" var="processo">
					<tr>
						<td><c:out value="${processo.numeroProcesso}" /></td>
						<td><c:out value="${processo.fornecedor.razaoSocial} / ${processo.fornecedor.CNPJ} " /></td>
						<td><c:out value="${processo.fiscalResponsavel}" /></td>
						<td><c:out value="${processo.dateRelatorio}" /></td>
						<td><c:out value="${processo.receitaBruta}" /></td>
                                                <td><a href="${pageContext.request.contextPath}/editar-processo?id=<c:out value="${processo.id }"/>">Editar</a></td>
						<td><a href="${pageContext.request.contextPath}/excluir-processo?id=<c:out value="${processo.id}"/>">Excluir</a></td> 						
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</div>
</body>
</html>