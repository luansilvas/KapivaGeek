<%-- 
    Document   : ListaFuncionario
    Created on : 01/04/2021, 19:10:34
    Author     : raque
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista Funcionários</title>
        
        <link href="css/ProductStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>
         <div class="containerMain">
            <fieldset>
                <legend>Lista funcionários</legend>  

                <form id="barraPesquisa" method="post" action="ProductList_Servlet">
                    <div id="input">
                     
                        <input id="pesquisar"type="text" name="pesquisa" placeholder="Pesquise um funcionário">
                        <input type="hidden" name="firstId" value="${primeiroId.getProductId()}">                       
                        <button id="lupa" style="border: none;color:white;background-color: white">
                            <label>
                                <img src="icons/search.png" alt="Lupa">
                            </label>
                            <input type="submit" value="" style="border: none;color:white;background-color: white">

                        </button>
                        <input type="hidden" name="lastId" value="${ultimoId.getProductId()}">

 
                        
                        <a href="<c:url value="/Product_Servlet"/>"><img src="icons/simbolo-de-adicao-de-espessura.png" id="imgAdd" ></a>
                        
                    </div>

                </form>


                <br>
                <div>
                    <table border =1 class="table table-striped" >
                    <thead class="thead-dark">   
                        <tr >
                            <th>Nome</th> 
                            <th>Tipo</th>
                            <th>Status</th>
                            <th>Inativar/Reativar</th>
                        </tr>
                    </thead>

                        <c:forEach items="${productList}" var="p">

                            <tr>

                                <td>${p.productName}</td>
                                <td>${p.getStatus()}</td>
                                <td>${p.getStatus()}</td>
                                <td><a href="<c:url value="/InactiveReactive?codProduto=${p.productId}"/>">INATIVAR/REATIVAR</a></td>
                                
                            </tr>
                        </c:forEach>                    

                    </table>

                </div>

                <div id="setas">

                    <img src="icons/seta2-left.png" alt="icone next">
                    <img src="icons/seta-left.png" alt="icone next">
                    <c:if test="${UltimiItem == null}">
                        <a href ="<c:url value="Pagination_Servlet?id=${ultimoId.getProductId()}"/>"><img src="icons/seta-right.png" alt="icone next" ></a>
                        </c:if>
                    <img src="icons/seta2-right.png" alt="icone next">

                </div>

            </fieldset>
        </div>
    </body>
</html>
