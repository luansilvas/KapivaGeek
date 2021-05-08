<%-- 
    Document   : EscolherFormaPagamento
    Created on : 08/05/2021, 14:36:34
    Author     : luans
--%>

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
        <h1>Escolha a forma de pagamento</h1>
        <section id="pagamento">
            <ul class="collapsible">
                <li>
                    <div class="collapsible-header"><i class="material-icons">feed</i>Boleto</div>
                    <div class="collapsible-body">
                        <form action="action">
                            <input type="radio" id="boleto">
                            <label for="boleto">1x de ${valorTotal}</label>
                            <button class="btn waves-effect waves-light" type="submit" name="action">Submit
                                <i class="material-icons right">send</i>
                            </button>
                        </form>
                    </div>
                </li>
                <li>
                    <div class="collapsible-header"><i class="material-icons">credit_card</i>Cartão de crédito</div>
                    <div class="collapsible-body">
                        <form action="action">
                            <label>Browser Select</label>
                            <select class="browser-default">
                                <option value="" disabled selected>Choose your option</option>
                                <option value="1">1x de ${valorTotal}</option>
                                <option value="2">2x de ${valorTotal/2}</option>
                                <option value="2">3x de ${valorTotal/3}</option>
                                <option value="2">4x de ${valorTotal/4}</option>
                                <option value="2">5x de ${valorTotal/5}</option>
                                <option value="2">6x de ${valorTotal/6}</option>
                                <option value="2">7x de ${valorTotal/7}</option>
                                <option value="2">8x de ${valorTotal/8}</option>
                                <option value="2">9x de ${valorTotal/9}</option>
                                <option value="2">10x de ${valorTotal/10}</option>
                                <option value="2">11x de ${valorTotal/11}</option>
                                <option value="2">12x de ${valorTotal/12}</option>
                            </select>

                            <div class="row">
                                <div class="input-field col s6">
                                    <input id="first_name" type="text" class="validate">
                                    <label for="first_name">Número do cartão</label>
                                </div>
                                <div class="input-field col s2">
                                    <input id="last_name" type="text" class="validate">
                                    <label for="last_name">CVV</label>
                                </div>
                                <div class="input-field col s4">
                                    <input id="first_name" type="month" class="validate">
                                    <label for="first_name">Data exp.</label>
                                </div>
                            </div>

                            <div class="row">
                                <div class="input-field col s8">
                                    <input id="last_name" type="text" class="validate">
                                    <label for="last_name">Nome impresso</label>
                                </div>
                            </div>

  <button class="btn waves-effect waves-light" type="submit" name="action">Submit
    <i class="material-icons right">send</i>
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
