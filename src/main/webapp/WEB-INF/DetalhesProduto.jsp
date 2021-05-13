<%-- 
    Document   : DetalhesProduto
    Created on : 11/05/2021, 21:26:38
    Author     : raque
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>JSP Page</title>
    </head>
    <body>
        <h1 id="titulo" >Detalhes da compra</h1>
        <a href="${pageContext.request.contextPath}/OrderHistory_Servlet" id="go-back" style="margin-top:70px;margin-left: 20%;">
            <img src="icons/left-arrow.png">
        </a>
        <table class="highlight" id="product-listing">
            <thead>
                <tr>
                    <th class="tituloTabela">
                        <p id="prod" class="titulos">Nome do produto</p>
                    </th>
                    <th class="tituloTabelaQtd">
                        <p class="titulos">Valor Unit.</p>
                    </th>
                    <th class="valores">
                        <p class="titulos">Quantidade</p>
                    </th>


                </tr>
            </thead>
            <c:forEach items="${detalhesPedido}" var="p">
                <tbody>
                    <tr>
                        <td id="produto">
                            <p>${p.productName}</p>
                        </td>
                        <td id="qtd" class="borda">
                            <p>R$ ${p.price}</p>
                        </td>
                        <td class="preco">
                            <p> ${p.quantity}</p>
                        </td>

                    </tr>

                </tbody>
            </c:forEach>
        </table>

    </body>
</html>
