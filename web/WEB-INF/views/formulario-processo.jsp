<%-- 
    Document   : formulario-processo
    Created on : 28/09/2016, 18:24:53
    Author     : rafae
--%>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1"%>

<%@taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>
<!DOCTYPE HTML>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
        <script   src="https://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8="   crossorigin="anonymous"></script>
        <link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.6/css/bootstrap.min.css" rel="stylesheet" type="text/css" />
<!--        <script   src="https://cdnjs.cloudflare.com/ajax/libs/jquery-maskmoney/3.0.2/jquery.maskMoney.min.js" crossorigin="anonymous"></script>
        <script   src="https://cdnjs.cloudflare.com/ajax/libs/jquery.maskedinput/1.4.1/jquery.maskedinput.min.js" crossorigin="anonymous"></script>-->
        <script   src="https://cdnjs.cloudflare.com/ajax/libs/jquery.mask/1.14.0/jquery.mask.min.js" crossorigin="anonymous"></script>
        
        
        <title>Cadastrar Processo</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Cadastrar Processo</h2>
            
            <p><a href="${pageContext.request.contextPath}/">Pagina inicial</a></p>
            <form action="processo-buscar-fornecedor" method="post" modelAttribute="fornecedor" enctype="utf8">
                <fieldset>
                    <label for="CNPJ">CNPJ do fornecedor</label> <input class="form-control" type="text"
                     name="CNPJ" placeholder="CNPJ" maxlength="18" id="CNPJ"  required  pattern="\d{2}.?\d{3}.?\d{3}/?\d{4}-?\d{2}"/>
                    <div>
                        <input class="btn btn-success" type="submit" value="Buscar" />
                    </div>
                </fieldset>
            </form>
        </div>
</body>

<script type="text/javascript">
    $(document).ready(function(){    
       $("#CNPJ").mask("99.999.999/9999-99");
    });
</script>
</html>