<%-- 
    Document   : revisarPedido
    Created on : 05/05/2021, 23:37:23
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style_menu.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">

    </head>

    <body>

        <nav>
            <div class="nav-wrapper brown">
                <div class="col s12" id="step">
                    <a href="${pageContext.request.contextPath}/Home_Servlet" class="breadcrumb white-text">Loja</a>
                    <a href="${pageContext.request.contextPath}/EscolherEnderecoEntrega" class="breadcrumb white-text">Endereco</a>
                    <a href="${pageContext.request.contextPath}/choosePayment_Servlet" class="breadcrumb white-text" disabled>Pagamento</a>                                     
                    <a href="${pageContext.request.contextPath}/ReviewOrder" class="breadcrumb white-text">Revisar</a>                 
                    <a href="#!" class="breadcrumb grey-text">Confirma</a>
                </div>
            </div>
        </nav>
                <h1 id="titulo">Revisar o meu Pedido</h1>
        <c:choose >
            <c:when test="${sessionScope.listaCarrinho != null && !sessionScope.itensSelecionados.isEmpty()}">

                <section id="listaCarrinho">
                    <table class="highlight" id="product-listing">
                        <thead>
                            <tr>
                                <th class="tituloTabela">Foto</th>
                                <th class="tituloTabela">Produto</th>
                                <th class="tituloTabelaQtd">Quantidade</th>
                                <th class="valores">Valor Unit</th>
                                <th>Acões</th>

                            </tr>
                        </thead>

                        <tbody>
                            <c:forEach items="${listaCarrinho}" var="p">
                                <tr>
                                    <td><img class = "prod-img"src="${p.path_MainImg}"></td>
                                    <td>${p.productName}</td>
                                    <td>
                                        <a href="<c:url value="/ChangeCartItem_Servlet?prodId=${p.productId}&acao=diminuir"/>"><i><img class="change-quantity" src="icons/minus24px.png"></i></a>
                                        ${p.quantity}
                                        <a  href="<c:url value="/ChangeCartItem_Servlet?prodId=${p.productId}&acao=adicionar"/>"><i><img class="change-quantity" src="icons/add24px.png"></i></a>
                                    </td>
                                    <td>R$ ${p.price}</td>
                                    <td>
                                        <a href="<c:url value="/ChangeCartItem_Servlet?prodId=${p.productId}&acao=deletar"/>">
                                            <i><img src="icons/delete.png"></i></td>
                                    </a>
                                </tr>
                            </c:forEach>

                            <tr>
                                <td></td>
                                <td></td>
                                <td>Frete:</td>
                                <td>R$ 14.0</td>
                                <td></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td></td>
                                <td>Total:</td>
                                <td>R$ ${valorTotal+14}</td>
                                <td></td>
                            </tr>
                        </tbody>

                    </table>  
                        <a class="btn-large" id="go-address" href="${pageContext.request.contextPath}/choosePayment_Servlet">Ir para Pagamento</a>    

                </section>

            </c:when>
            <c:otherwise>
                <p>Carrinho vazio</p>
            </c:otherwise>
        </c:choose>  



        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
    </body>
</html>

