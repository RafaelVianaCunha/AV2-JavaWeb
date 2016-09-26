<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<!DOCTYPE HTML>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css"
	rel="stylesheet" type="text/css" />
<title>Cadastrar Pedido</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.0/jquery.min.js"></script>          

</head>
<body>
	<div id="content" class="col-lg-4">
		<h2>Cadastrar Pedido</h2>
		<form id="frm" action="salvar-pedido" method="post">
			<div style="visibility: hidden">
				<label for="id">ID</label> <input type="text" name="id"
					value="<c:out value="${pedido.id}" />" readonly="readonly"
                                        placeholder="ID" required />
			</div>
			<div>
				<form:errors path="pedido.status" cssStyle="color:red" />
			</div>
			<div>
				<label for="status">status:</label> <input class="form-control"
					type="text" name="status"
					value="<c:out value="${pedido.status}" />" placeholder="status" required />
			</div>
			<div>
				<form:errors path="pedido.dataPedido" cssStyle="color:red" />
			</div>
			
                                        
                                <div >
                                        <label for="data" >Data(MM/DD/YYYY)</label>
                                        
                                        <input type="text" name="dataPedido" placeholder="Data" id="dataPedido" name="dataPedido" class="form-control" value="<c:out value="${pedido.dataPedido}" />" placeholder="Data Pedido" required 
                                               pattern="(0[1-9]|1[012])[- /.](0[1-9]|[12][0-9]|3[01])[- /.](19|20)\d\d"/>                                             
                                       
                                    </div>          
                                        
                                        
                             <div>  
                                 <label for=autor>Cliente:</label>                                  
                                    <select name="cliente.id" id="cliente_id" class="form-control" required>
                                        <c:forEach items="${clientes}" var="cliente">
                                            <option value="<c:out value="${cliente.id}" />"><c:out value="${cliente.nome}" /></option>
                                        </c:forEach>
                                    </select>                                            
                             </div>

			<div>
				<input class="btn btn-success" type="submit" value="Salvar" />
			</div>
		</form>
	</div>

</body>
</html>