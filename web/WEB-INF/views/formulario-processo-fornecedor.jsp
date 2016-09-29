<%-- 
    Document   : formulario-processo-fornecedor
    Created on : 28/09/2016, 21:17:23
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

            <form action="salvar-processo" method="post" modelAttribute="fornecedor" enctype="utf8">
                  <fieldset>
                      <legend>Fornecedor</legend>
                <div>
                    <label >CNPJ: ${processo.fornecedor.CNPJ}</label> </br>
                    <label >Razao Social: ${processo.fornecedor.razaoSocial}</label> </br>                   
                    <label >Inscricao Municipal: ${processo.fornecedor.inscricaoMunicipal}</label> </br>
                </div>
                   </fieldset>
                
                <fieldset>
                    <legend>Processo</legend>
                <div>
                    <form:errors path="fornecedor.CNPJ" cssStyle="color:red"/>
                </div>  
                
                <div>
                    <label for="relatorioFiscalizacao">Relato da Fiscalizaçãol</label> </br>
                    <textarea rows="4" cols="50" name="relatorioFiscalizacao" required>
                        <c:out value="${processo.relatorioFiscalizacao}" />
                    </textarea>
                    
                    
                    
                    
                </div>                
                <div>
                    <form:errors path="relatorioFiscalizacao" cssStyle="color:red"/>
                </div>
                
                <div>
                   
                    <label for="dateRelatorio">Data Relatoriol</label> 
                    <input class="form-control" value="<c:out value="${processo.dateRelatorio}" />" type="text" maxlength="10"
                                                                    name="dateRelatorio" placeholder="Data Relatorio" id="dateRelatorio" />
                </div>                
                <div>
                    <form:errors path="dateRelatorio" cssStyle="color:red"/>
                </div>
                
                <div>
                    <label for="fiscalResponsavel">Fiscal Responsavel</label> <input class="form-control" type="text" value="<c:out value="${processo.fiscalResponsavel}" />" 
                                                           name="fiscalResponsavel" placeholder="Fiscal Responsavel" maxlength="100" required id="fiscalResponsavel"/>
                </div>                
                <div>
                    <form:errors path="fiscalResponsavel" cssStyle="color:red"/>
                </div>
                
                <input class="form-control" type="hidden" value="${processo.idFornecedor}"
                                                           name="idFornecedor" placeholder="Fiscal Responsavel" maxlength="100" required id="idFornecedor"/>
                
                </fieldset>        
                <div>
                    <input class="btn btn-success" type="submit" value="Cadastrar" />
                </div>
                
            </form>
        </div>
</body>

<script type="text/javascript">
    $(document).ready(function(){    
       $("#dateRelatorio").mask("99/99/9999");
    });
</script>
</html>