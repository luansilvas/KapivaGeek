<%-- 
    Document   : substituirImagem
    Created on : 08/03/2021, 06:49:10
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link href="css/replaceImage.css" rel="stylesheet" type="text/css">
    </head>
    <body>
        <div class="general-content">
            <h1>Alterar Imagem</h1>


            <c:forEach items="${imageList}" var="image">
                <div class="old-image">
                    <p>Foto a ser alterada:</p>
                    <img src="${image.path}" width="100" height="100">
                    <input type="text" name="productId" value="${image.productId}" hidden="hidden">

                </div>

            </c:forEach>



            <form action="<c:url value="/ReplaceProductImageServlet"/>" method="POST" enctype="multipart/form-data">

                <input type="file" name="image" id="image" hidden="hidden">  
                <label id="escolhaArquivoLabel">Escola o novo arquivo:</label>    
                <div class="search-field">
                    <span id="custom-text"></span>
                </div>
                <button type="button" id="custom-button"><img src="icons/search.png"></button>

                <br>
                <input type="checkbox" name="mainimage" id="mainimage">            
                <label for="mainimage" class="mainimage">Imagem da pagina Inicial</label>
                <br>
                <input type="text"  value="${productId}" name="productId" hidden="hidden">
                <input type="text" value="${imageId}" name="imageId" hidden="hidden">
                <input type="submit" value="alterar" id="replace">

            </form>
        </div>

        <script>
            const realFileBtn = document.getElementById("image");
            const customBtn = document.getElementById("custom-button");
            const customTxt = document.getElementById("custom-text");

            customBtn.addEventListener("click", function () {
                realFileBtn.click();
            });

            image.addEventListener("change", function () {
                if (realFileBtn.value) {
                    customTxt.innerHTML = realFileBtn.value;
                } else {
                    customTxt.innerHTML = "No file chosen, yet."
                }
            });
        </script>
    </body>
</html>
