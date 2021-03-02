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

        <meta charset=utf-8 />
    </head>
    <a href="cadastrarImagem.jsp"></a>
    <body>
        


        <form action="<c:url value="/UploadImageServlet"/>" method="POST" enctype="multipart/form-data">

            <input type="file" name="image">
            <input type="submit">
        </form>
    </body>

</html>
