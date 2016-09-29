<%-- 
    Document   : index
    Created on : 28/09/2016, 18:16:01
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
    <h1>Bem vindo ao Sisfiscon</h1>
    <div id="content" class="col-lg-8">
        <p><a href="${pageContext.request.contextPath}/listar-fornecedor">Listar Forncededores</a></p>
        <p><a href="${pageContext.request.contextPath}/listar-processo">Listar Processos</a></p>
    </div>
    </body>
</html>
