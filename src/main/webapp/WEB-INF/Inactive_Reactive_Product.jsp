<%-- 
    Document   : Ective_Reactive_Product
    Created on : 06/03/2021, 23:59:51
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ProductStyle.css" type="text/css">
        <title>Inativar e Reativar Produto</title>
    </head>
    <body>
        <section id="main" class="containerMain">
            <a href="<c:url value="/ProductList_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form method="post" action="InactiveReactive" novalidate class="form">
                <fieldset>
                    <input type="hidden" id="ProductId" name="prodId" value="${IdProduto}" readonly>
                    <legend>Produto</legend>
                    <h1></h1>

                    <div class="divsForm">
                        <label>Nome do Produto:</label>
                        <br>
                        <input type="text" name="product-name" value="${product.getProductName()}" readonly>

                    </div>
                    <div id="nomeExtenso" class="divsForm">
                        <label>Nome Extenso:</label>
                        <br>
                        <textarea name="long-name" rows="4" cols="50" readonly >${product.getProductFullName()}</textarea>
                    </div>
                      <div>
                        <label>Categoria</label>
                        <br>
                        <input type="text" name="category" value="${product.getCategory()}">
                       
                    </div>
                    <div class="divsForm">
                        <label>Quantidade de estrelas:</label>
                        <br>
                        <input type="text" name="stars" value="${product.getStars()}" readonly>


                    </div>
                    <div class="divsForm">
                        <label>Status:</label>
                        <br>
                        <input type="text" name="status" value="${product.getStatus()}" readonly>
                    </div>
                    <div class="divsForm">
                        <label>Quantidade estoque</label>
                        <br>
                        <input type="text" name="stock" value="${product.getQuantity()}" readonly>
                    </div>
                    <div class="divsForm">
                        <label>Preço:</label>
                        <br>
                        <input type="text" name="price" value="${product.getPrice()}" readonly>
                    </div>

                </fieldset>
                <div id="Botoes" class="divsForm" >
                    <button type="reset">Cancelar</button>

                    <c:if test="${statusValue == true}">
                        <button type="submit" name="Inativo">Inativar</button>
                        <input type="hidden" name="novoStatus" value="Inativo">
                    </c:if> 

                    <c:if test="${statusValue == false}">
                        <button type="submit" name="Ativo">Ativar</button>
                        <input type="hidden" name="novoStatus" value="Ativo">
                    </c:if>  


                </div>              

            </form>
        </section>
    </body>
</html>


