<%-- 
    Document   : escolherEnderecoEntrega
    Created on : 09/05/2021, 09:41:36
    Author     : luans
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">

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
                    <a href="${pageContext.request.contextPath}/ReviewOrder" class="breadcrumb white-text">Meu carrinho</a>
                    <a href="${pageContext.request.contextPath}/choosePayment_Servlet" class="breadcrumb white-text" disabled>Pagamento</a>
                    <a href="${pageContext.request.contextPath}/EscolherEnderecoEntrega" class="breadcrumb white-text">Endereco</a>
                    <a class="breadcrumb grey-text">Revisar</a>
                </div>
            </div>
        </nav>
        <div id="endCadastrado">
            <form action="<c:url value="/EscolherEnderecoEntrega"/>" method="POST">
                <table class="table" style="border: none">
                    <thead>
                        <tr>
                            <th>Endereços cadastrados</th>
                            <th>Valor do frete</th>
                        </tr>
                    </thead>
                    <tbody>

                        <c:forEach items="${addr}" var="a">

                            <tr>
                                <td>
                                    <input type="radio" id="${a.address_code}" name="end" value="${a.address_id}" required>
                                    <label for="${a.address_code}" class="radiobutton-label">
                                        <b>${a.address_title}</b>
                                        <br>
                                        ${a.address_street},${a.address_number} - ${a.address_neighborhood},${a.address_state_abbreviation} - ${a.address_code}
                                    </label>
                                </td>
                                <td>R$ ${Math.ceil(valorTotal*0.2)}<td>

                            </tr>
                        </c:forEach>               

                    </tbody>
                </table>
                <button class="btn waves-effect waves-light" type="submit" name="action" id="send-button">Submit
                    <i class="material-icons right"></i>
                </button>

            </form>
        </div>
    </body>
</html>
