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
            <fieldset>
                <legend>Produto</legend>
                <form method="post" action="Product-Salvar" novalidate class="form">
                <h1></h1>
                
                <div class="divsForm">
                    <label>Nome do Produto:</label>
                    <br>
                    <input type="text" name="product-name" >
                   
                </div>
                <div id="nomeExtenso" class="divsForm">
                    <label>Nome Extenso:</label>
                      <br>
                    <textarea name="long-name" rows="4" cols="50" ></textarea>
                </div>
                <div class="divsForm">
                    <label>Quantidade de estrelas:</label>
                     <br>
                    <input type="text" name="stars">
                    

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
                    <button type="submit">Alterar - Ir Imagens</button>
                </div>              
            </form>
        </section>
    </body>
</html>

