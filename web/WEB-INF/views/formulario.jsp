<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" 
              rel="stylesheet" type="text/css" />
        <title>Cadastrar Cliente</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Cadastrar Cliente</h2>
            <form action="salvar-cliente" method="post">
                <div style="visibility:hidden">
                    <label for="id">ID</label> <input type="text"
                                                      name="id" value="<c:out value="${cliente.id}" />"
                                                      readonly="readonly" placeholder="ID" />
                </div>
                <div>
                    <form:errors path="livro.titulo" cssStyle="color:red"/>
                </div>    
                <div>
                    <label for="nome">Mome:</label> <input class="form-control" type="text"
                                                           name="nome" value="<c:out value="${cliente.nome}" />"
                                                           placeholder="Nome" required/>
                </div>
                <div>
                    <form:errors path="livro.nome" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for=autor>CPF:</label> 
                    <input class="form-control" type="text" name="CPF" value="<c:out value="${cliente.CPF}" />"
                                                                 placeholder="CPF" required/>
                </div>
                <div>
                    <form:errors path="livro.endereco" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for="endereco">Endereco:</label> <input class="form-control" type="text" name="endereco"
                                                             value="<c:out value="${cliente.endereco}" />" placeholder="Endereco" required/>
                </div>
                
                <div>
                    <form:errors path="livro.telefone" cssStyle="color:red"/>
                </div>
                <div>    
                    <label for=telefone>telefone:</label> <input class="form-control" type="text" name="telefone"
                                                             value="<c:out value="${cliente.telefone}" />" placeholder="telefone" required/>
                </div>
                
                <div>
                    <input class="btn btn-success" type="submit" value="Salvar" />
                </div>
            </form>
        </div>
</body>
</html>