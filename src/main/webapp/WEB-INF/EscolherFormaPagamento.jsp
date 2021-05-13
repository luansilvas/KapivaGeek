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

        href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
    </head>
    <body>
        <%@include file="../menu.jsp" %>

        <nav>
            <div class="nav-wrapper brown" id="nav-stepper">
                <div class="col s12" id="step">
                    <a href="${pageContext.request.contextPath}/Home_Servlet" class="breadcrumb white-text">Loja</a>                
                    <a href="${pageContext.request.contextPath}/carrinho?acao=abrirCarrinho" class="breadcrumb white-text">Meu carrinho</a>                  
                    <a href="${pageContext.request.contextPath}/EscolherEnderecoEntrega" class="breadcrumb white-text">Endereco</a>
                    <a href="${pageContext.request.contextPath}/choosePayment_Servlet" class="breadcrumb white-text">Pagamento</a>
                    <a class="breadcrumb grey-text">Confirma</a>
                </div>
            </div>
        </nav>
        <h1 id="payment-title">Escolha a forma de pagamento</h1>
        <section id="pagamento">
            <a href="${pageContext.request.contextPath}/EscolherEnderecoEntrega" id="go-back" style="margin-top: 10%;">
                <img src="icons/left-arrow.png">
            </a>

            <c:if test="${hasError eq 'true'}">
                <div class="msg msg-error z-depth-3 scale-transition">
                    <ul>
                        <c:forEach items="${errorList}" var="p">
                            <li>${p}</li>
                            </c:forEach>
                    </ul>
                </div>
            </c:if>
            <ul class="collapsible">
                <li>
                    <div class="collapsible-header"><i class="material-icons">feed</i>Boleto</div>
                    <div class="collapsible-body">
                        <form action="<c:url value="/choosePayment_Servlet"/>" method="POST">
                            <input type="radio" id="boleto" name="boleto" value="boleto" required>
                            <label for="boleto" value="boleto"class="black-text">1x de ${Math.ceil(valorTotal+valorFrete)}</label>


                            <button class="btn waves-effect brown" id="pay-boleto" type="submit" name="action">Pagar com boleto
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
                                <option value="1">1x de ${Math.ceil((valorTotal+valorFrete))}</option>
                                <option value="2">2x de ${Math.ceil((valorTotal+valorFrete)/2)}</option>
                                <option value="3">3x de ${Math.ceil((valorTotal+valorFrete)/3)}</option>
                                <option value="4">4x de ${Math.ceil((valorTotal+valorFrete)/4)}</option>
                                <option value="5">5x de ${Math.ceil((valorTotal+valorFrete)/5)}</option>
                                <option value="6">6x de ${Math.ceil((valorTotal+valorFrete)/6)}</option>
                                <option value="7">7x de ${Math.ceil((valorTotal+valorFrete)/7)}</option>
                                <option value="8">8x de ${Math.ceil((valorTotal+valorFrete)/8)}</option>
                                <option value="9">9x de ${Math.ceil((valorTotal+valorFrete)/9)}</option>
                                <option value="10">10x de ${Math.ceil((valorTotal+valorFrete)/10)}</option>
                                <option value="11">11x de ${Math.ceil((valorTotal+valorFrete)/11)}</option>
                                <option value="12">12x de ${Math.ceil((valorTotal+valorFrete)/12)}</option>
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

                            <button class="btn waves-effect waves-light brown" type="submit" name="action">Salvar
                                <i class="material-icons right"></i>
                            </button>

                        </form>
                    </div>
                </li>
            </ul>
        </section>

    </body>
</html>
