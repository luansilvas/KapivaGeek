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
        <div class="container">


            <table class="centered" id="product-listing">
                <thead>
                    <tr>
                        <th>
                        </th>
                        <th class="tituloTabela">
                            <p id="prod" class="titulos">Nome do produto</p>
                        </th>

                        <th class="tituloTabelaQtd">
                            <p class="titulos">Valor Unit.</p>
                        </th>
                        <th class="valores">
                            <p class="titulos">Quantidade</p>
                        </th>
                        <th class="valores">
                            <p class="titulos">Subtotal</p>
                        </th>


                    </tr>
                </thead>
                <tbody>
                <c:forEach items="${detalhesPedido}" var="p">
                    
                        <tr style="border-top-color: white;">
                            <td><img class = "prod-img" src="${p.path_MainImg}"></td>
                            <td id="produto">
                                <p>${p.productName}</p>
                            </td>
                            <td id="qtd" class="borda">
                                <p>R$ ${p.price}</p>
                            </td>
                            <td class="preco">
                                <p> ${p.quantity}</p>
                            </td>
                            <td class="preco">
                                <p> ${Math.ceil(p.quantity*p.price)}</p>
                            </td>

                        </tr>
                </c:forEach>
                        
                        
                        <tr>
                            <td></td>
                            <td id="produto">
                                
                            </td>
                            <td id="qtd" class="borda">
                           
                            </td>
                            <td class="preco">
                              Subtotal
                            </td>
                            <td class="preco">
                                <p> ${valorTotal}</p>
                            </td>

                        </tr>
                                                <tr>
                            <td></td>
                            <td id="produto">
                                
                            </td>
                            <td id="qtd" class="borda">
                           
                            </td>
                            <td class="preco">
                              Frete
                            </td>
                            <td class="preco">
                                <p> ${valorFrete}</p>
                            </td>

                        </tr>
                                                                        <tr>
                            <td></td>
                            <td id="produto">
                                
                            </td>
                            <td id="qtd" class="borda">
                           
                            </td>
                            <td class="preco">
                              Total
                            </td>
                            <td class="preco">
                                <p> ${valorTotal+valorFrete}</p>
                            </td>

                        </tr>
                        </tbody>
            </table>

            <div class="card"  style="width:60%;margin-left: 20%;">
                <h3>
                    Endereço de entrega
                </h3>
                <h5>
                    ${endEntrega.address_title}

                </h5>
                <p>${endEntrega.address_street}, ${endEntrega.address_number} - ${endEntrega.address_neighborhood},${endEntrega.address_state_abbreviation} - ${endEntrega.address_code}</p>
            </div>    
                    
                <div class="card"  style="width:60%;margin-left: 20%;">
                <h3>
                    Forma de pagamento
                </h3>
                <p>
                    Feito em ${pagamento.payment_instalments}x no ${pagamento.payment_way} 
                </p>
                </div>
                
                </div>

                </body>
                </html>
