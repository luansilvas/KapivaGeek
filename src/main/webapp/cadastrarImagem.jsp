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
        <title>KapivaGeek - carregar imagem</title>
        <link href="imageUploadStyle.css" rel="stylesheet" type="text/css">

        <meta charset=utf-8 />
    </head>
    <a href="cadastrarImagem.jsp"></a>
    <body>


        <fieldset class="general-fieldset">
            <legend>Adicionar/remover Imagens</legend>


            <p class="image-label">Caminho Arquivo Upload  <div class="search-bar"> </div></p>
        <form action="<c:url value="/UploadImageServlet"/>" method="POST" enctype="multipart/form-data">

           
                <input type="text" name="productId" value="${productId}" style="display:none">
           
            <input type="file" name="image" id="image" >
            <label for="image">
                <img src="icons/search.png">
            </label>

            <input type="checkbox" name="mainimage" id="mainimage">
            <label for="mainimage">Imagem da pagina Inicial</label>

            <input type="submit">
        </form>
        <fieldset>


        </fieldset>
        <form action="<c:url value="/DeleteImageServlet"/>" method="POST">
            <c:forEach items="${imageList}" var="image">
                <input type="checkbox" name = "deleteSelected" value="${image.imageId}">
                <img src="images/customer.png" width="100" height="100">
                <input type="text" name="productId" value="${image.productId}" style="display: none">
            </c:forEach>

            <input type="submit">
        </form>

    </fieldset>

    <script type="text/javascript">
        // var file = document.getElementById("image");

        ///file.addEventListener("change", function () {
        // var filePath = file.val();
        // alert("oie");
        //}, false);

        //const field = document.getElementById("teste");
        //field.innerHTML = OIIII;

    </script>


</body>

</html>
