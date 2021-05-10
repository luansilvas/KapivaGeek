<%-- 
    Document   : Carrinho
    Created on : 04/05/2021, 00:19:24
    Author     : adm
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>

        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">

        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection" />
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">


        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    </head>

    <body>

        <%@include file="../menu.jsp" %>

        <c:choose >
            <c:when test="${sessionScope.listaCarrinho != null && !sessionScope.itensSelecionados.isEmpty()}">

                <section id="listaCarrinho">

                    <table class="highlight" id="product-listing">
                        <thead>
                            <tr>
                                <th class="tituloTabela">
                                    <p id="prod" class="titulos">Produto</p>
                                </th>
                                <th class="tituloTabelaQtd">
                                    <p class="titulos">Quantidade</p>
                                </th>
                                <th class="valores">
                                    <p class="titulos">Valor Unit.</p>
                                </th>
                                <th>
                                    <p>Acões</p>
                                </th>

                            </tr>
                        </thead>
                        <c:forEach items="${listaCarrinho}" var="p">
                            <tbody>
                                <tr>
                                    <td id="produto">
                                        <img class = "prod-img" src="${p.path_MainImg}">
                                        <p>${p.productName}</p>
                                    </td>
                                    <td id="qtd" class="borda">
                                        <div id="input">
                                            <a  href="${pageContext.request.contextPath}/carrinho?productId=${p.productId}&acao=subtrair" ><img class="change-quantity" src="icons/minus24px.png"></a>
                                                ${p.quantity}
                                            <a href="${pageContext.request.contextPath}/carrinho?productId=${p.productId}&acao=adicionar" ><img class="change-quantity" src="icons/add24px.png"></a>
                                        </div>
                                    </td>
                                    <td class="preco">
                                        <p>R$ ${p.price}</p>
                                    </td>
                                    <td>
                                        <a href="${pageContext.request.contextPath}/carrinho?productId=${p.productId}&acao=excluir" ><img id="delete" src="icons/delete2.png"></a>
                                    </td>

                                </tr>

                            </tbody>
                        </c:forEach>
                    </table>
                    
                    <h3 id="valorTotal"  >Valor total: R$ ${valorTotal}</h3>
                    <a id="finalizar" href="${pageContext.request.contextPath}/ReviewOrder" >Finalizar</a>
                </section>

            </c:when>
            <c:otherwise>
                <p>Carrinho vazio</p>
            </c:otherwise>
        </c:choose>  
        <a href="${pageContext.request.contextPath}/Home_Servlet">Continuar comprando</a>
    </body>
</html>
