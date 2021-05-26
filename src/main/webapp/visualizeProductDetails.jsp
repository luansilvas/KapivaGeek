<%-- 
    Document   : visualizeProductDetails
    Created on : 25/05/2021, 18:05:03
    Author     : luans
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/visualizeProductDetailsStyle.css" rel="stylesheet" type="text/css">
        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="menu.jsp" %>
        <div id="content-wrapper">
            <div class="column">
                <img id="featured" src="${mainImage.path}">

                <div id="slide-wrapper">
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
                <h3>
                    <p>R$ ${product.price}</p>
                </h3>
                <br>

                <div id="product-full-name">
                    <h5>Descrição:</h5>
                    <p>${product.productFullName}</p>
                    <p>Classificação:<c:forEach items="${Stars}" var="stars">
                            <img src="icons/mushroom.png" class="mushrooms">
                        </c:forEach> </p>
                </div>
                <div class="botao">
                    <a class="btn btn-dark" href="${pageContext.request.contextPath}/getProduct_Servlet?productId=${product.productId}">Eu quero!</a>
                </div>


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
    </div>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>
    <script>


            $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 300
                edge: 'left', // Choose the horizontal origin
                closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                draggable: true // Choose whether you can drag to open on touch screens,
            }
            );

            document.addEventListener('DOMContentLoaded', function () {
                var elems = document.querySelectorAll('.sidenav');
                var instances = M.Sidenav.init(elems);
            });


            $(document).ready(function () {
                $('.slider').slider();
            });
    </script>
</body>
</html>
