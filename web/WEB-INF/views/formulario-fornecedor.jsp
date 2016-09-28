<%-- 
    Document   : formulario-fornecedor
    Created on : 25/09/2016, 16:58:04
    Author     : rafael
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
        
        
        <title>Cadastrar Fornecedor</title>
    </head>
    <body>
        <div id="content" class="col-lg-4">
            <h2>Cadastrar Fornecedor</h2>
            <form action="salvar-fornecedor" method="post" modelAttribute="fornecedor" enctype="utf8">
                <div>
                    
                    <label for="CNPJ">CNPJ</label> <input class="form-control" type="text"
                                                          name="CNPJ" placeholder="CNPJ" maxlength="18" id="cnpj" required  pattern="\d{2}.?\d{3}.?\d{3}/?\d{4}-?\d{2}"/>
                </div>                
                <div>
                    <form:errors path="fornecedor.CNPJ" cssStyle="color:red"/>
                </div>  
                
                <div>
                    <label for="razaoSocial">Razao social</label> <input class="form-control" type="text"
                                                           name="razaoSocial" placeholder="Razao Social" required />
                </div>                
                <div>
                    <form:errors path="fornecedor.razaoSocial" cssStyle="color:red"/>
                </div>
                
                <div>
                   
                    <label for="inscricaoMunicipal">Inscricao Municipal</label> <input class="form-control" type="text"
                                                                    name="inscricaoMunicipal" placeholder="Inscricao Municipal" maxlength="11" id="inscricaoMunicipal" pattern="\d{1}.?\d{3}.?\d{3}-?\d{1}"/>
                </div>                
                <div>
                    <form:errors path="fornecedor.inscricaoMunicipal" cssStyle="color:red"/>
                </div>
                
                <div>
                    <label for="receitaBruta">Receita Bruta</label> <input class="form-control" type="text"
                                                           name="receitaBruta" placeholder="Receita Bruta" maxlength="30" required/>
                </div>                
                <div>
                    <form:errors path="fornecedor.receitaBruta" cssStyle="color:red"/>
                </div>
                <fieldset>
                    <legend>Endereço</legend>
                        <div>
                            <label for="logradouro">Logradouro</label> <input class="form-control" type="text"
                                                                   name="endereco.logradouro" placeholder="Logradouro" maxlength="100" required/>
                        </div>   
                        <div>
                            <label for="numero">Número</label> <input class="form-control" type="text"
                                                                   name="endereco.numero" placeholder="Numero" maxlength="50" required/>
                        </div>   
                        <div>
                            <label for="complemento">Complemento</label> <input class="form-control" type="text"
                                                                   name="endereco.complemento" placeholder="Complemento" maxlength="50" />
                        </div> 
                        <div>
                            <label for="bairro">Bairro</label> <input class="form-control" type="text" path="endereco.bairro"
                                                                   name="endereco.bairro" placeholder="Bairro" maxlength="100" required/>
                        </div>   
                        <div>
                            <label for="cep">CEP</label> <input class="form-control" type="text"
                                                                name="endereco.cep" placeholder="CEP" maxlength="9" id="cep" required pattern="\d{5}-\d{3}"/>
                        </div>  
                        <div>
                            <label for="municipio">Município</label> <input class="form-control" type="text"
                                                                   name="endereco.municipio" placeholder="Município" maxlength="200" required/>
                        </div>  
                    
                        <div>
                            <label for="uf">UF</label>
                            <select id="uf" name="endereco.uf" required>    
                                <option value="AC">AC</option>
                                <option value="AL">AL</option>
                                <option value="AM">AM</option>
                                <option value="AP">AP</option>
                                <option value="BA">BA</option>
                                <option value="CE">CE</option>
                                <option value="DF">DF</option>
                                <option value="ES">ES</option>
                                <option value="GO">GO</option>
                                <option value="MA">MA</option>
                                <option value="MG">MG</option>
                                <option value="MS">MS</option>
                                <option value="MT">MT</option>
                                <option value="PA">PA</option>
                                <option value="PB">PB</option>
                                <option value="PE">PE</option>
                                <option value="PI">PI</option>
                                <option value="PR">PR</option>
                                <option value="RJ">RJ</option>
                                <option value="RN">RN</option>
                                <option value="RS">RS</option>
                                <option value="RO">RO</option>
                                <option value="RR">RR</option>
                                <option value="SC">SC</option>
                                <option value="SE">SE</option>
                                <option value="SP">SP</option>
                                <option value="TO">TO</option>
                            </select>
                        </div>     
                </fieldset>   
                <div>
                    <input class="btn btn-success" type="submit" value="Cadastrar" />
                </div>
            </form>
        </div>
</body>

<script type="text/javascript">
    $(document).ready(function(){    
       $("#cep").mask("99999-999");
       $("#inscricaoMunicipal").mask("9.999.999-9");
       $("#cnpj").mask("99.999.999/9999-99");
    });
</script>
</html>


