<%-- 
    Document   : FormProducts
    Created on : 01/03/2021, 19:18:44
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ProductStyle.css" type="text/css">
        <title>Cadastro de Produto</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <section id="main" class="containerMain">
            <a href="<c:url value="/ProductList_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form id="formCadastro" method="post" action="Product-Salvar" novalidate class="form">
                <fieldset>

                    <legend>Cadastro de Produto</legend>
                    <div class="divsForm">
                        <label>Produto</label>
                        <br>
                        <input type="text" name="product-name" placeholder="Nome do produto" >
                        <c:if
                            test="${ProductNameError != null}">
                            <span><c:out value="${ProductNameError}" /></span>
                        </c:if>
                    </div>
                    <div id="nomeExtenso">   
                        <br>
                        <textarea name="long-name" rows="4" cols="50" placeholder="Descrição do produto"></textarea>
                    </div>
                    
                    <div class="divsForm">  
                        
                        <label>Tipo</label>
                        <br>
                        
                        <select id="" name="status">
                            <option value="Ativo">Escolha...</option>
                            <option value="Objeto">Objeto</option>
                            <option value="Roupa">Roupa</option>
                            <option value="Acessório">Acessório</option>
                        </select>
                        <c:if
                            test="${CategoryError != null}">
                            <span><c:out value="${CategoryError}"/></span>
                        </c:if>
                    </div>
                    
                    <div class="divsForm">
                        <label>Estrelas</label>
                        <br>
                        <input type="number" name="stars" max="5" value="0" placeholder="Estrelas">
                        <c:if test="${StarsValueError != null}">
                            <span><c:out value="${StarsValueError}"/></span>
                        </c:if>
                    </div>
                    
                    <div class="divsForm">
                       <label>Status</label>
                        <br>
                        <select id="" name="status">
                            <option value="Ativo">Escolha...</option>
                            <option value="Ativo">Ativo</option>
                            <option value="Inativo">Inativo</option>
                        </select>
                    </div>
                    <div class="divsForm">
                        

                        <label>Quantidade</label>
                        <input type="text" name="stock" placeholder="Quantidade" >
                    </div>
                    <div class="divsForm">
                      <label>Preço</label>
                        <input type="text" name="price" placeholder="Preço">
                    </div>
                </fieldset>
                <div id="Botoes" class="divsForm" >
                    <button type="reset">Cancelar</button>
                    <button type="submit">Cadastrar - Imagens</button>
                    
                    
                </div>         
            </form>



        </section>
    </body>
</html>
