<%-- 
    Document   : listarProdutos
    Created on : 04/03/2021, 22:33:47
    Author     : luans

<input type="text" name="idTeste" value="${productList.getProductId()}">
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
        <div class="containerMain">
            <fieldset>
                <legend>Listar produtos</legend>  

                <form method="post" action="ProductList_Servlet">
                    <div id="input">
                        <label>Procurar</label>

                        <input type="text" name="pesquisa">
                        <input type="hidden" name="firstId" value="${primeiroId.getProductId()}">                       
                        <button style="border: none;color:white;background-color: white">
                            <label>
                                <img src="icons/search.png" alt="Lupa">
                            </label>
                            <input type="submit" value="" style="border: none;color:white;background-color: white">

                        </button>
                        <input type="hidden" name="lastId" value="${ultimoId.getProductId()}">

 
                        
                        <a href="<c:url value="/Product_Servlet"/>"><img src="icons/simbolo-de-adicao-de-espessura.png" id="imgAdd" ></a>
                        
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
                                <td>${p.getQuantity()}</td>
                                <td>${p.getStatus()}</td>
                                <td><a href="<c:url value="/AlterarProduto?codProduto=${p.productId}"/>">EDITAR</a></td>
                                <td><a href="<c:url value="/InactiveReactive?codProduto=${p.productId}"/>">INATIVAR/REATIVAR</a></td>
                                <td><a href="<c:url value="/VisualizeProductImageServlet?productId=${p.productId}"/>">VISUALIZAR</a></td>
                            </tr>
                        </c:forEach>                    

                    </table>

                </div>

                <div id="setas">

                    <img src="icons/seta2-left.png" alt="icone next">
                    <img src="icons/seta-left.png" alt="icone next">
                    <c:if test="${UltimiItem == null}">
                        <a href ="<c:url value="Pagination_Servlet?id=${ultimoId.getProductId()}"/>"><img src="icons/seta-right.png" alt="icone next" ></a>
                        </c:if>
                    <img src="icons/seta2-right.png" alt="icone next">

                </div>

            </fieldset>
        </div>
    </body>
</html>
