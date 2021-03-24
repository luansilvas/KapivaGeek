<%-- 
    Document   : index
    Created on : 02/03/2021, 22:26:42
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Principal.css" type="text/css">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <title>Home</title>
    </head>
    <body>
        <a href="<c:url value="/ProductList_Servlet"/>">
            Listar produtos
        </a>
        <section id="principal" class="container">
            <div id="boasVindas">
                <h1>Bem Vindos!</h1>
                <figure>
                    <img src="images/mario.png">
                </figure>
            </div>
           
                <div class="row">
                    <c:forEach items="${produtos}" var="p">
                        <div id="cards" class="">
                            <div class="card" style="width:300px">
                                <img class="card-img-top" src="${p.path_MainImg}" alt="Card image" style="width:100%">
                                <div class="card-body">
                                    <h4 class="card-title">${p.productName}</h4>
                                    <p class="card-text">${p.productFullName}</p>
                                    <p class="card-text">${p.price}</p>
                                    <a href="#" class="btn btn-primary">Detalhes</a>
                                </div>
                            </div>
                        </div>
                    </c:forEach>

                </div>
           

        </section>

        <footer>
            <c:import url="footer.jsp" />
        </footer>   
    </body>
</html>
