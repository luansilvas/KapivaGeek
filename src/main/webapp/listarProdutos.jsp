<%-- 
    Document   : listarProdutos
    Created on : 04/03/2021, 22:33:47
    Author     : luans

<input type="text" name="idTeste" value="${productList.getProductId()}">
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KapivaGeek - listar produtos</title>
        <link href="css/ProductStyle.css" rel="stylesheet">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    </head>
    <body>
        <script>
            $(function () {
                $('[data-toggle="tooltip"]').tooltip()
            })
        </script>
        <%@include file="menuFuncionario.jsp" %>  

        <c:choose>
            <c:when test="${sessionScope.emp!= null}">
                <div class="containerMain">

                    <a type="button" class="btn " data-toggle="modal" data-target="#exampleModalCenter">
                        <img src="icons/car.png">
                    </a>
                    <form method="post" action="${pageContext.request.contextPath}/quantidade" >

                        <!-- Modal -->
                        <div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
                            <div class="modal-dialog modal-dialog-centered" role="document">
                                <div class="modal-content">
                                    <div class="modal-header">
                                        <h5 class="modal-title" id="exampleModalLongTitle">Adicionar quantidade</h5>
                                        <button type="button" class="close" data-dismiss="modal" aria-label="Close" >
                                            <span aria-hidden="true">&times;</span>
                                        </button>
                                    </div>

                                    <div class="modal-body">
                                        <div class="row">
                                            <div class="col-md-4">
                                                <label>Id do Produto: </label>
                                                <input class="form-control" type="number" name="idProd">
                                            </div >
                                            <div class="col-md-6" >
                                                <label>Adicionar quantidade: </label>
                                                <input class="form-control" type="text" name="quantidade">
                                            </div>
                                        </div>
                                    </div>

                                    <div class="modal-footer">
                                        <button type="button" class="btn btn-secondary" data-dismiss="modal">Close</button>
                                        <input type="submit" class="btn btn-primary">
                                    </div>

                                </div>
                            </div>
                        </div>
                    </form>




                    <fieldset>
                        <legend>Listar produtos</legend>  

                        <form id="barraPesquisa" method="post" action="ProductList_Servlet">
                            <div id="input" class="form-group row">
                                <p class="col-md-1"></p>
                                <input class="form-control" id="pesquisar" type="text" name="pesquisa" placeholder="Pesquise um produto">
                                <input type="hidden" name="firstId" value="${primeiroId.getProductId()}">                       
                                <button id="lupa" style="border: none;color:white;background-color: white">
                                    <label>
                                        <img src="icons/search.png" alt="Lupa">
                                    </label>
                                    <input type="submit" value="" style="border: none;color:white;background-color: white">

                                </button>
                                <input type="hidden" name="lastId" value="${ultimoId.getProductId()}">


                                <c:if test="${sessionScope.emp.employeeRole.equals('Administrador')}">
                                    <a href="<c:url value="/Product_Servlet"/>"><img src="icons/simbolo-de-adicao-de-espessura.png" id="imgAdd" ></a>
                                    </c:if>

                            </div>

                        </form>


                        <br>
                        <div>
                            <table class= "table  table table-striped" >
                                <thead class="thead-dark">   
                                    <tr >
                                        <th>  </th>
                                        <th>Código do Produto</th>
                                        <th>Nome do produto</th>
                                        <th>Qnt. Estoque</th> 
                                        <th >Status</th>
                                        <th>Editar</th>
                                        <th>Inativar/Reativar</th>
                                        <th>Visualizar</th>
                                    </tr>
                                </thead>

                                <c:forEach items="${productList}" var="p">

                                    <tr>
                                        <td>
                                            <c:if test="${p.quantity eq 10}">
                                                <span><img src="icons/atencao.png"  data-toggle="tooltip" data-placement="left" title="Atenção a quantidade de produtos em estoque"></span>
                                                </c:if>

                                            <c:if test="${p.quantity < 10}">
                                                <span><img src="icons/marca-x.png"  data-toggle="tooltip" data-placement="left" title="Baixa quantidade em estoque seu produto foi Inativado"></span>
                                                </c:if>     

                                            <c:if test="${p.quantity > 10}">
                                                <span><img src="icons/simbolo-correto.png"  data-toggle="tooltip" data-placement="left" title="Estoque Ok"></span>
                                                </c:if> 
                                        </td>
                                        <td>${p.productId}</td>
                                        <td>${p.productName}</td>
                                        <td class="row">
                                            ${p.getQuantity()}  
                                            <a style="margin:0 10px;" href="<c:url value="/quantidade?id=${p.productId}" />" style="margin-right: 10px;"><img src="icons/add24px.png"></a>
                                        </td>
                                        <td>${p.getStatus()}</td>
                                        <td><a href="<c:url value="/AlterarProduto?codProduto=${p.productId}"/>">EDITAR</a></td>
                                        <td><a href="<c:url value="/InactiveReactive?codProduto=${p.productId}"/>">INATIVAR/REATIVAR</a></td>
                                        <td><a href="<c:url value="/seeProductDetail?productId=${p.productId}"/>">VISUALIZAR</a></td>
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
            </c:when>
            <c:otherwise>
                <div>
                    <p>Usuário não logado no sistema</p>
                </div>

            </c:otherwise>
        </c:choose>


    </body>
</html>
