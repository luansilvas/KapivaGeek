<%-- 
    Document   : cadastrarImagem
    Created on : 01/03/2021, 17:53:23
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KapivaGeek - Carregar imagem</title>
        <link href="css/imageUploadStyle.css" rel="stylesheet" type="text/css">
        <meta charset=utf-8 />
    </head>
    <a href="cadastrarImagem.jsp"></a>
    <body>


        <fieldset class="general-fieldset">
            <legend>Adicionar imagens</legend>

            <form action="<c:url value="/UploadImageServlet"/>" method="POST" enctype="multipart/form-data">

                <input type="file" name="image" id="image" hidden="hidden" required="required" accept=".png, .jpg, .jpeg">  
                <input type="text" hidden="hidden" value="${productId}" name="productId">
                <label id="escolhaArquivoLabel">Escola seu arquivo:</label>    
                <div class="search-field">
                    <span id="custom-text"></span>
                </div>
                <button type="button" id="custom-button"><img src="icons/search.png"></button>

                <br>
                <c:if test="${hasMainImage eq ''}">
                <input type="checkbox" name="mainimage" id="mainimage" value="true">            
                <label for="mainimage">Imagem da pagina Inicial</label>
                </c:if>
                <br>
                <input type="submit">
            </form>

        </fieldset>
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
