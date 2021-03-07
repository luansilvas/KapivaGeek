<%-- 
    Document   : listarProdutos
    Created on : 04/03/2021, 22:33:47
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KapivaGeek - listar produtos</title>
        <link href="css/ProductStyle.css" rel="stylesheet">
    </head>
    <body>
        <fieldset class= "general-fieldset">
            <div id="corpo">
                <legend>Listar produtos</legend>  

                <form methodo="post">
                    <div id="input">
                        <label>Procurar</label>
                        <input type="text">
                        <label><img src="icons/search.png" alt="Lupa"></label>
                    </div>
                </form>

                <br>
                <div>
                    <table border=1>

                        <tr>
                            <th>Nome do produto</th>
                            <th>Qnt. Estoque</th> 
                            <th>Status</th>
                            <th>Editar</th>
                            <th>Inativar/Reativar</th>
                            <th>Visualizar</th>
                        </tr>

                        <c:forEach items="${productList}" var="p">

                            <tr>
                                <td>${p.productName}</td>
                                <td>30</td>
                                <td>Ativo</td>
                                <td><a href="<c:url value="/AlterarProduto?codProduto=${p.productId}"/>">EDITAR</a></td>
                                <td><a href="<c:url value="/AlterarProduto?codProduto=${p.productId}"/>">INATIVAR/REATIVAR</a></td>
                                <td><a href="<c:url value="/AlterarProduto?codProduto=${p.productId}"/>">VISUALIZAR</a></td>
                            </tr>
                        </c:forEach>                    

                    </table>

                </div>

                <div id="setas">
                    <img src="icons/seta2-left.png" alt="icone next">
                    <img src="icons/seta-left.png" alt="icone next">
                    <img src="icons/seta-right.png" alt="icone next">
                    <img src="icons/seta2-right.png" alt="icone next">

                </div>
            </div>
        </fieldset>
    </body>
</html>
