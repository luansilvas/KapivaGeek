<%-- 
    Document   : OrderList
    Created on : 18/05/2021, 22:22:58
    Author     : adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js" integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js" integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM" crossorigin="anonymous"></script>

        <title>Lista de Pedidos</title>


    </head>
    <body>
        <h1>Pedidos</h1>
        <table class="highlight" id="product-listing">
            <thead>
                <tr>
                    <th class="tituloTabela">
                        <p id="prod" class="titulos">Id do Pedido</p>
                    </th>
                    <th class="tituloTabelaQtd">
                        <p class="titulos">Data</p>
                    </th>
                    <th class="valores">
                        <p class="titulos">Valor Total sem frete</p>
                    </th>
                    <th class="valores">
                        <p class="titulos">Status</p>
                    </th>
                    <th>
                        <p>Acões</p>
                    </th> 


                </tr>
            </thead>
            <c:forEach items="${order}" var="o">
                <tbody>
                    <tr>
                        <td id="produto">
                            <p>${o.purchaseorder_id}</p>
                        </td>
                        <td id="qtd" class="borda">
                            <p>${o.diaPedido}</p>
                        </td>
                        <td class="preco">
                            <p>R$ ${o.purchaseorder_amount}</p>
                        </td>
                        <td>
                            <p>${o.purchaseorder_status}</p>
                        </td>

                        <td>
                            <form method="post" action="${pageContext.request.contextPath}/orderlist?id=${o.purchaseorder_id}">
                                <div class="dropdown show">
                                    <a class="btn btn-primary dropdown-toggle" href="" role="button" id="dropdownMenuLink" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        Atualizar Status
                                    </a>

                                    <div class="dropdown-menu" aria-labelledby="dropdownMenuLink">
                                        <input type="submit" class="dropdown-item" name="acao" value="Aguardando Pagamento">
                                        <input type="submit" class="dropdown-item" name="acao" value="Pagamento Rejeitado">
                                        <input type="submit" class="dropdown-item" name="acao" value="Pagamento com sucesso">
                                        <input type="submit" class="dropdown-item" name="acao" value="Aguardando retirada">
                                        <input type="submit" class="dropdown-item" name="acao" value="Em trânsito">
                                        <input type="submit" class="dropdown-item" name="acao" value="Entrege">
                                    </div>
                                </div>

                            </form>
                        </td>

                    </tr>

                </tbody>
            </c:forEach>
        </table>
        <script>
            const elemsDropdown = document.querySelector(".dropdown-trigger");
            const instanceDropdown = M.Dropdown.init(elemsDropdown);


        </script>

    </body>
</html>
