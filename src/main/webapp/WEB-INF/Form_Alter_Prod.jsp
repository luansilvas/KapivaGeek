<%-- 
    Document   : Form_Alter_Prod
    Created on : 06/03/2021, 00:00:49
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ProductStyle.css" type="text/css">
        <title>Alterar Produto</title>
    </head>
    <body>
        <section id="main" class="containerMain">

            <form method="post" action="AlterarProduto" class="form">
                <fieldset>
                    <input type="hidden" name="Product-id" value="${id}">
                    <legend>Produto</legend>
                    <h1></h1>

                    <div class="divsForm">
                        <label>Nome do Produto:</label>
                        <br>
                        <input type="text" name="product-name" value="${res.getProductName()}" >
                        <c:if
                            test="${ProductNameError != null}">
                            <span><c:out value="${ProductNameError}" /></span>
                        </c:if>

                    </div>
                    <div id="nomeExtenso" class="divsForm">
                        <label>Nome Extenso:</label>
                        <br>
                        <textarea name="long-name" rows="4" cols="50" >${res.getProductFullName()}</textarea>
                    </div>
                    <div class="divsForm">
                        <label>Quantidade de estrelas:</label>
                        <br>
                        <input type="number" name="stars"  max="5"value="${res.getStars()}">
                        <c:if test="${StarsValueError != null}">
                            <span><c:out value="${StarsValueError}"/></span>
                        </c:if>
                    </div>
                    <div class="divsForm">
                        <label>Status:</label>
                        <br>
                        <input type="text" name="status" value="${res.getStatus()}" disabled>

                    </div>
                    <div class="divsForm">
                        <label>Quantidade estoque</label>
                        <br>
                        <input type="text" name="stock" value="${res.getQuantity()}">
                    </div>
                    <div class="divsForm">
                        <label>Preço:</label>
                        <br>
                        <input type="text" name="price" value="${res.getPrice()}">
                    </div>
                    
                </fieldset>
                    <div id="Botoes" class="divsForm" >
                        <button type="reset">Cancelar</button>
                        <button type="submit">Alterar - Ir Imagens</button>
                    </div>  
            </form>


        </section>
    </body>
</html>

