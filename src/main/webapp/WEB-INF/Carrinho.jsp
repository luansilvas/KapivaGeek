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
        <link href="css/EstiloCarrinho.css" type="text/css" rel="stylesheet">
    </head>

    <body>
        <h1>Hello World!</h1>
        <c:choose >
            <c:when test="${sessionScope.listaCarrinho != null && !sessionScope.itensSelecionados.isEmpty()}">

                <section id="listaCarrinho">

                    <table class="table">
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
                                        <img src="${p.path_MainImg}">
                                        <p>${p.productName}</p>
                                    </td>
                                    <td id="qtd" class="borda">
                                        <div id="input">
                                            <a id="add" href="${pageContext.request.contextPath}/carrinho?productId=${p.productId}&acao=adicionar" ><img src="icons/add.png"></a>
                                            <p id="valorQuantidade">${quantidade}</p>
                                            <a id="sub" href="#" ><img src="icons/sub.png"></a>
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

                    <h3>Valor total: R$ ${valorTotal}</h3>
                </section>

            </c:when>
            <c:otherwise>
                <p>Carrinho vazio</p>
            </c:otherwise>
        </c:choose>  
        <a href="${pageContext.request.contextPath}/Home_Servlet">Voltar</a>
    </body>
</html>
