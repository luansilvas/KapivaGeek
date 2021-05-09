<%-- 
    Document   : EscolherFormaPagamento
    Created on : 08/05/2021, 14:36:34
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Carrinho</title>
        <link href="css/EstiloRevisarPedido.css" type="text/css" rel="stylesheet">

        <meta charset="utf-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" type="text/css" href="css/style_menu.css">
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/5.10.2/css/all.min.css">
        <link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <link type="text/css" rel="stylesheet" href="materialize/css/materialize.min.css" media="screen,projection" />
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
        <link rel="stylesheet" type="text/css"
              href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    </head>
    <body>
                <nav>
            <div class="nav-wrapper brown">
                <div class="col s12" id="step">
                    <a href="${pageContext.request.contextPath}/Home_Servlet" class="breadcrumb white-text">Loja</a>
                    <a href="${pageContext.request.contextPath}/ReviewOrder" class="breadcrumb white-text">Meu carrinho</a>
                    <a href="${pageContext.request.contextPath}/choosePayment_Servlet" class="breadcrumb white-text" disabled>Pagamento</a>
                    <a class="breadcrumb grey-text">Endereco</a>
                    <a class="breadcrumb grey-text">Confirma</a>
                </div>
            </div>
        </nav>
        <h1>Escolha a forma de pagamento</h1>
        <section id="pagamento">
            <ul class="collapsible">
                <li>
                    <div class="collapsible-header"><i class="material-icons">feed</i>Boleto</div>
                    <div class="collapsible-body">
                        <form action="<c:url value="/choosePayment_Servlet"/>" method="POST">
                            <input type="radio" id="boleto" name="boleto" value="boleto">
                            <label for="boleto" value="boleto">1x de ${valorTotal}</label>
                            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                                <i class="material-icons right"></i>
                            </button>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header"><i class="material-icons">credit_card</i>Cartão de crédito</div>
                    <div class="collapsible-body">
                        <form action="<c:url value="/choosePayment_Servlet"/>" method="POST">
                            <label>Browser Select</label>
                            <select class="browser-default" name="parcelas">
                                <option value="" disabled selected>Choose your option</option>
                                <option value="1">1x de ${Math.ceil(valorTotal)}</option>
                                <option value="2">2x de ${Math.ceil(valorTotal/2)}</option>
                                <option value="3">3x de ${Math.ceil(valorTotal/3)}</option>
                                <option value="4">4x de ${Math.ceil(valorTotal/4)}</option>
                                <option value="5">5x de ${Math.ceil(valorTotal/5)}</option>
                                <option value="6">6x de ${Math.ceil(valorTotal/6)}</option>
                                <option value="7">7x de ${Math.ceil(valorTotal/7)}</option>
                                <option value="8">8x de ${Math.ceil(valorTotal/8)}</option>
                                <option value="9">9x de ${Math.ceil(valorTotal/9)}</option>
                                <option value="10">10x de ${Math.ceil(valorTotal/10)}</option>
                                <option value="11">11x de ${Math.ceil(valorTotal/11)}</option>
                                <option value="12">12x de ${Math.ceil(valorTotal/12)}</option>
                            </select>

                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="numCartao" type="text" class="validate" name="numCartao">
                                    <label for="numCartao">Número do cartão</label>
                                </div>
                                <div class="input-field col s2">
                                    <input id="cvv" type="text" class="validate" name ="cvv">
                                    <label for="cvv">CVV</label>
                                </div>
                                <div class="input-field col s4">
                                    <input id="exp" type="month" class="exp" name="exp">
                                    <label for="exp">Data exp.</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s8">
                                    <input id="printedName" type="text" class="validate" name="printedName">
                                    <label for="printedName">Nome impresso</label>
                                </div>
                            </div>

                            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                                <i class="material-icons right"></i>
                            </button>

                        </form>
                    </div>
                </li>
            </ul>
        </section>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js">
            $(document).ready(function () {
                $('.collapsible').collapsible();
            });
        </script>
    </body>
</html>
