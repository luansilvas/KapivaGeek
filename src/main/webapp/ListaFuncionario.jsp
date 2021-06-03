<%-- 
    Document   : ListaFuncionario
    Created on : 01/04/2021, 19:10:34
    Author     : raque
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
        <%@include file="menuFuncionario.jsp" %>  

            <div class="containerMain">
                <fieldset>
                    <legend>Lista funcionários</legend>  

                    <form id="barraPesquisa" method="post" action="ListEmployee_Servlet?currentRecord=0&acao=FirstAccess">
                        <div id="input" class="form-group row">
                            <p class="col-md-1"></p>
                            <input class="form-control" id="pesquisar"type="text" name="pesquisa" placeholder="Pesquise um funcionário">
                            <input type="hidden" name="firstId" value="${primeiroId.getProductId()}">                       
                            <button id="lupa" style="border: none;color:white;background-color: white">
                                <label>
                                    <img src="icons/search.png" alt="Lupa">
                                </label>
                                <input type="submit" value="" style="border: none;color:white;background-color: white">

                            </button>
                            <input type="hidden" name="lastId" value="${ultimoId.getProductId()}">


                            <c:if test="${sessionScope.emp.employeeRole.equals('Administrador')}">
                                <a href="<c:url value="/RegisterEmployee_Servlet"/>"><img src="icons/simbolo-de-adicao-de-espessura.png" id="imgAdd" ></a>
                                </c:if>
                        </div>

                    </form>


                    <br>
                    <div>
                        <table class="table table-striped" >
                            <thead class="thead-dark">   
                                <tr >
                                    <th >Nome</th> 
                                    <th>Tipo</th>
                                    <th>Status</th>
                                        <c:if test="${sessionScope.emp.employeeRole.equals('Administrador')}">
                                        <th>Editar</th>
                                        <th>Inativar/Reativar</th>
                                        </c:if>
                                </tr>
                            </thead>

                            <c:forEach items="${emp}" var="p">

                                <tr>

                                    <td>${p.employeeName}</td>
                                    <td>${p.employeeRole}</td>
                                    <td>${p.employeeStatus}</td>
                                    <c:if test="${sessionScope.emp.employeeRole.equals('Administrador')}">
                                        <td><a href="<c:url value="/AlterEmployee_Servlet?employeeId=${p.employeeId}"/>">Editar</a></td>
                                        <td><a href="<c:url value="/ActivateInactivateEmployee_Servlet?employeeId=${p.employeeId}&acao=consulta"/>">Inativar/Reativar</a></td>
                                    </c:if>


                                </tr>
                            </c:forEach>                    

                        </table>

                    </div>

                    <div id="setas">

                        <c:if test="${hasFirst eq 'true'}">
                            <a href ="<c:url value="ListEmployee_Servlet?currentRecord=${currentRecord}&acao=First"/>">
                                <img src="icons/seta2-left.png" alt="icone next">
                            </a>
                        </c:if>
                        <c:if test="${hasPrevious eq 'true'}">
                            <a href ="<c:url value="ListEmployee_Servlet?currentRecord=${currentRecord}&acao=Previous"/>">
                                <img src="icons/seta-left.png" alt="icone next">
                            </a>
                        </c:if>
                        <c:if test="${hasNext eq 'true'}">
                            <a href ="<c:url value="ListEmployee_Servlet?currentRecord=${currentRecord}&acao=Next"/>">
                                <img src="icons/seta-right.png" alt="icone next" >
                            </a>
                        </c:if>
                        <c:if test="${hasLast eq 'true'}">
                            <a href ="<c:url value="ListEmployee_Servlet?currentRecord=${currentRecord}&acao=Last"/>">
                                <img src="icons/seta2-right.png" alt="icone next">
                            </a>
                        </c:if>
                    </div>

                </fieldset>
            </div>
    </body>
</html>
