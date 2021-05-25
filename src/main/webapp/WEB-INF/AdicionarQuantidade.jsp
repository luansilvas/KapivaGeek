<%-- 
    Document   : AdicionarQuantidade
    Created on : 24/05/2021, 14:07:19
    Author     : adm
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
         <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Adicionar quantidade</title>
    </head>
    <body>
        <div class="container">
            <p>Nome: ${prod.productName}</p>
            <form method="post" action="${pageContext.request.contextPath}/quantidade">
                <div class="form-group row">
                    <label style="margin: 10px" >Quantidade:</label>
                    <input class="form-control col-md-4" type="number" name="quantidade" placeholder="Digite a quantidade a ser adicionada...">
                    <input type="hidden" name="idProd" value="${prod.productId}">
                </div>
                <div>
                    <button type="submit">Adicionar</button>
                </div>
            </form>
            
        </div>
    </body>
</html>
