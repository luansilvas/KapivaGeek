<%-- 
    Document   : Form_Alter_Prod
    Created on : 06/03/2021, 00:00:49
    Author     : Gabriel
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/ProductStyle.css" type="text/css">
        <title>Alterar Produto</title>
    </head>
    <body>

        <section id="main" class="containerMain">
            <a href="<c:url value="/ProductList_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form id="formCadastro" method="post" action="SaveChage" class="form">
                <fieldset >
                    <input type="hidden" name="Product-id" value="${id}">
                    <legend>Editar Produto</legend>
                    <h1></h1>

                    <div class="divsForm">
                        <label>Nome do Produto:</label>
                        <br>
                        <input type="text" name="product-name" value="${res.productName}">
                        <c:if
                            test="${ProductNameError != null}">
                            <span><c:out value="${ProductNameError}" /></span>
                        </c:if>

                    </div>
                    <div id="nomeExtenso" class="divsForm">
                        <label>Nome Extenso:</label>
                        <br>
                        <textarea name="long-name" rows="4" cols="50" >${res.productFullName}</textarea>
                    </div>
                    <div class="divsForm">
                        <label>Categoria</label>
                        <br>
                        <select id="" name="category">
                            <option value="${res.getCategory()}">${res.getCategory()}</option>
                            <option value="Boneco">Boneco</option>
                            <option value="Camiseta masculina">Camiseta masculina</option>
                            <option value="Camiseta feminina">Camiseta feminina</option>
                            <option value="Caneca">Caneca</option>
                            <option value="Acessorio">Acessório</option>
                            <option value="Variedade">Variedade</option>
                        </select>



                        <c:if
                            test="${CategoryError != null}">
                            <span><c:out value="${CategoryError}"/></span>
                        </c:if>
                    </div>



                    <div class="divsForm">
                        <label>Quantidade de estrelas:</label>
                        <br>
                        <input type="number" name="stars"  max="5"value="${res.stars}">
                        <c:if test="${StarsValueError != null}">
                            <span><c:out value="${StarsValueError}"/></span>
                        </c:if>
                    </div>
                    <div class="divsForm">
                        <label>Status:</label>
                        <br>
                        <input type="text" name="status" value="${res.getStatus()}" readonly>

                    </div>
                    <div class="divsForm">
                        <label>Quantidade estoque</label>
                        <br>
                        <input type="text" name="stock" value="${res.getQuantity()}">
                    </div>
                    <div class="divsForm">
                        <label>Preço:</label>
                        <br>
                        <input type="text" name="price" value="${res.getPrice()}">
                    </div>

                </fieldset>
                <div class="divsForm" >
                    <!-- <button type="reset">Cancelar</button>-->
                    <button id="alterar" type="submit">Alterar Produto</button>
                </div>  
            </form>


        </section>
    </body>
</html>

