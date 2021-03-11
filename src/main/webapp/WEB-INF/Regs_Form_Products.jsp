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
    </head>
    <body>
        <section id="main" class="containerMain">
            <fieldset>
                <legend>Produto</legend>
                <form method="post" action="Product-Salvar" novalidate class="form">
                    <div class="divsForm">
                        <label>Nome do Produto:</label>
                        <br>
                        <input type="text" name="product-name" >
                        <c:if
                            test="${ProductNameError != null}">
                            <span><c:out value="${ProductNameError}" /></span>
                        </c:if>
                    </div>
                    <div id="nomeExtenso" class="divsForm">
                        <label>Nome Extenso:</label>
                        <br>
                        <textarea name="long-name" rows="4" cols="50" ></textarea>
                    </div>
                    <div class="divsForm">
                        <label>Quantidade de estrelas:</label>
                        <br>
                        <input type="number" name="stars" max="5" value="0">
                        <c:if test="${StarsValueError != null}">
                            <span><c:out value="${StarsValueError}"/></span>
                        </c:if>
                    </div>
                    <div class="divsForm">
                        <label>Status:</label>
                        <br>
                        <select id="" name="status">
                            <option value="Ativo">Escolha...</option>
                            <option value="Ativo">Ativo</option>
                            <option value="Inativo">Inativo</option>
                        </select>
                    </div>
                    <div class="divsForm">
                        <label>Quantidade estoque</label>
                        <br>
                        <input type="text" name="stock">
                    </div>
                    <div class="divsForm">
                        <label>Preço:</label>
                        <br>
                        <input type="text" name="price">
                    </div>
            </fieldset>
            <div id="Botoes" class="divsForm" >
                <button type="reset">Cancelar</button>
                <button type="submit">Cadastrar - Ir Imagens</button>
            </div>         
        </form>



    </section>
</body>
</html>
