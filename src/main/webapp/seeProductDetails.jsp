<%-- 
    Document   : seeProductDetails
    Created on : 20/03/2021, 14:21:44
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Comprar ${product.productName}</title>
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
        <link href="css/style.css" rel="stylesheet" type="text/css">


    </head>
    <body>

        <a href="<c:url value="/Home_Servlet?categoria=all"/>" class="go-back">
            <img src="icons/left-arrow.png">
        </a>

        <div id="content-wrapper">

            <div class="column">
                <img id=featured src="${mainImage.path}">

                <div id="slide-wrapper" >
                    <img id="slideLeft" class="arrow" src="icons/left-chevron.png">

                    <div id="slider">

                        <c:forEach items="${imageList}" var="image">
                            <img class="thumbnail" src="${image.path}">

                        </c:forEach>
                    </div>

                    <img id="slideRight" class="arrow" src="icons/right-chevron.png">
                </div>
            </div>

            <div class="column">
                <h1>${product.productName}</h1>
                <br>
                <p>Classificação: </p>
                <c:forEach items="${Stars}" var="stars">
                    <img src="icons/mushroom.png" class="mushrooms">
                </c:forEach>
                <br>
                <div id="product-full-name">
                    <p>${product.productFullName}</p>
                </div>


            </div>
            <div class="column">

                <h3><p>R$ ${product.price}</p></h3>
                <a class="btn btn-dark" href="#">Comprar</a>


            </div>

        </div>

        <script type="text/javascript">
            let thumbnails = document.getElementsByClassName('thumbnail')

            let activeImages = document.getElementsByClassName('active')

            for (var i = 0; i < thumbnails.length; i++) {

                thumbnails[i].addEventListener('mouseover', function () {
                    console.log(activeImages)

                    if (activeImages.length > 0) {
                        activeImages[0].classList.remove('active')
                    }


                    this.classList.add('active')
                    document.getElementById('featured').src = this.src
                })
            }


            let buttonRight = document.getElementById('slideRight');
            let buttonLeft = document.getElementById('slideLeft');

            buttonLeft.addEventListener('click', function () {
                document.getElementById('slider').scrollLeft -= 180
            })

            buttonRight.addEventListener('click', function () {
                document.getElementById('slider').scrollLeft += 180
            })


        </script>

    </body>
</html>