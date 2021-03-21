<%-- 
    Document   : alterarImagem
    Created on : 08/03/2021, 06:00:57
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KapivaGeek - carregar imagem</title>
        <link href="css/imageUploadStyle.css" rel="stylesheet" type="text/css">
        <meta charset=utf-8 />
    </head>
    <a href="cadastrarImagem.jsp"></a>
    <body>


        <fieldset class="general-fieldset">
            <legend id="titulo">Alterar Imagens</legend>

            <form id="formCadastro" action="<c:url value="/UploadImageServlet"/>" method="POST" enctype="multipart/form-data">

                <input type="file" name="image" id="image" hidden="hidden">  
                <input type="text" hidden="hidden" value="${productId}" name="productId">
                <label id="escolhaArquivoLabel">Escolha seu arquivo:</label>    
                <div class="search-field">
                    <span id="custom-text"></span>
                </div>
                <button id="custom-button" type="button"><img src="icons/search.png"></button>

                <br>
                <c:if test="${hasMainImage eq ''}">
                <input type="checkbox" name="mainimage" id="mainimage" value="true">            
                <label for="mainimage">Imagem da pagina Inicial</label>
                </c:if>
                <br>
                <input type="submit" value="upload">
            </form>
            <fieldset>
                <form action="<c:url value="/DeleteAlterImageServlet"/>" method="POST">
                    <c:forEach items="${imageList}" var="image">
                        <input type="checkbox" name = "deleteSelected" value="${image.imageId}">
                        <a href="<c:url value="/ReplaceProductImageServlet?imageId=${image.imageId}&productId=${image.productId}"/>">
                            <img src="${image.path}" width="100" height="100">
                        </a>
                        <input type="text" name="productId" value="${image.productId}" hidden="hidden">
                    </c:forEach>
                    <input type="text" value="${productId}" name="productId" hidden="hidden">
                    <input type="submit" value="remover">
                </form>
            </fieldset>
                    <button id="confirmar" style="float:right">
                <a href="<c:url value="/ProductList_Servlet"/>" style="text-decoration: none; color: black;">
                    pronto
                </a>
            </button>
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

