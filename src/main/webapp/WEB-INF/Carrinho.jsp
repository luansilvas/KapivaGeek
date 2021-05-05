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
    </head>
    <body>
        <h1>Hello World!</h1>
        <c:choose >
            <c:when test="${sessionScope.listaCarrinho != null && !sessionScope.itensSelecionados.isEmpty()}">
        <c:forEach items="${listaCarrinho}" var="p">
            <ul>
                <li>${p.productName}</li>
                <li>${p.price}</li>
                <li>${p.quantity}</li>
              
            </ul>
        </c:forEach>
        </c:when>
            <c:otherwise>
                <p>Carrinho vazio</p>
            </c:otherwise>
     </c:choose>  
        <a href="${pageContext.request.contextPath}/Home_Servlet">Voltar</a>
    </body>
</html>
