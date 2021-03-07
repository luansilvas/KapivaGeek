<%-- 
    Document   : visualizarProduto
    Created on : 06/03/2021, 19:34:56
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/visualizeProductStyle.css" rel="stylesheet" type="text/css">
        <script src="jquery-3.5.1.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

    </head>
    <body>
            <a href="<c:url value="/ProductList_Servlet"/>" class="go-back">
                <img src="icons/arrow_back.png">
            </a>
        <fieldset class="detail-field">

            <legend>Detalhes do produto</legend>
            <div class="product-images">

                <img src="${mainImage.path}" class="mainPic">
                <img src="icons/arrow_back.png" class="arrows">
                <c:forEach items="${imageList}" var="image">
                    
                    <img src="${image.path}" class="Pic">
                </c:forEach>
                <img src="icons/arrow_foward.png" class="arrows">
            </div>
            <div class="product-detail">
                <p>${product.productName}</p>

                <c:forEach items="${Stars}" var="stars">
                    <img src="icons/mushroom.png" class="mushrooms">
                </c:forEach>
                <div class="full-name-field">
                    <p>${product.productFullName}</p>
                </div>

            </div>


        </fieldset>
        <fieldset class="buy-field">
            <legend>Venda</legend>

            <p>R$ ${product.price}</p>

            <button>Comprar</button>
        </fieldset>
            <script>       
                $(document).ready(function(){
                   $('.Pic').click(function(){
                      $smallImages = $(this).attr('src');
                      console.log('OIIII');
                      $('.mainPic').attr('src',$smallImages);
                   }) ;
                    
                });
            </script>



    </body>
</html>
