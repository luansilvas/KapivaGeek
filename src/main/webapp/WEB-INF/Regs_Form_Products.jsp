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
        <title>JSP Page</title>
    </head>
    <body>
        <section id="main">
            <form method="post" action="Product-Salvar" novalidate>
                <h1></h1>
                <div>
                    <label>Nome do Produto</label>
                    <input type="text" name="product-name" >
                    <c:if test="${ProductNameError != null}">
                        <span><c:out value="${ProductNameError}" /></span>
                    </c:if>
                </div>
                <div>
                    <label>Nome Extenso:</label>
                    <textarea name="long-name" rows="4" cols="50" ></textarea>
                </div>
                <div>
                    <label>Quantidade de estrelas:</label>
                    <input type="text" name="stars">

                </div>
                <div>
                    <label>Status:</label>
                    <select id="" name="status">
                        <option value="Ativo">Escolha...</option>
                        <option value="Ativo">Ativo</option>
                        <option value="Inativo">Inativo</option>
                    </select>
                </div>
                <div>
                    <label>Quantidade estoque</label>
                    <input type="text" name="stock">
                </div>
                <div>
                    <label>Preço:</label>
                    <input type="text" name="price">
                </div>
                
                <div>
                    <button type="reset">Cancelar</button>
                    <button type="submit">Cadastrar - Ir Imagens</button>
                </div>
                
                
                
            </form>
            <c:if test="${add != null}">
                    <span><c:out value="${add}"/></span>
                </c:if>
        </section>
    </body>
</html>
