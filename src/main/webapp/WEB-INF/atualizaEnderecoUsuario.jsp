<%-- 
    Document   : atualizaEnderecoUsuario
    Created on : 27/04/2021, 18:56:31
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Cadastro</title>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/EmployeeFormStyle.css" type="text/css">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <section id="main" class="containerMain">

            <a href="<c:url value="/alterRegister_Costumer"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form class="formCadastro" method="post" action="<c:url value="/AlterCustomerAddress_Servlet"/>" novalidate class="form">
                <fieldset>
                    <legend>Atualiza Endereco</legend>

                    <div class="divsForm">
                        <label>Titulo</label>
                        <br>
                        <input type="text" name="title" placeholder="Digite um titulo de identificação" value="${address.address_title}">
                    </div>
                    <div class="divsForm">
                        <label>CEP</label>
                        <br>
                        <input type="text" name="cep" placeholder="CEP" id="cep" value="${address.address_code}">
                        <br>
                    </div>
                    <div class="divsForm" id="senha">
                        <label>Logradouro</label>
                        <br>
                        <input type="text" placeholder="Logradouro" name="street" id="logradouro" value="${address.address_street}" readonly>
                        <input type="text" placeholder="Número" name="number" id="numero" value="${address.address_number}">
                    </div>

                    <div class="divsForm">
                        <label>Complemento</label>
                        <br>
                        <input type="text" name="complement" id="complemento" value="${address.address_complement}">
                    </div>
                    <div class="divsForm">
                        <label>Bairro</label>
                        <br>
                        <input type="text" name="neighborhood" id="bairro" value="${address.address_neighborhood}" readonly>
                    </div>
                    <div class="divsForm">
                        <label>Estado</label>
                        <select id="uf" name="uf" readonly="readonly" tabindex="-1" aria-disabled="true">
                            <option value="${address.address_state_abbreviation}">${address.address_state_abbreviation}</option>
                            <option value="AC">Ac</option>
                            <option value="AL">AL</option>
                            <option value="AP">AP</option>
                            <option value="AM">AM</option>
                            <option value="BA">BH</option>
                            <option value="CE">CE</option>
                            <option value="DF">DF</option>
                            <option value="ES">ES</option>
                            <option value="GO">GO</option>
                            <option value="MA">MA</option>
                            <option value="MT">MT</option>
                            <option value="MS">MS</option>
                            <option value="MG">MG</option>
                            <option value="PA">PA</option>
                            <option value="PB">PB</option>
                            <option value="PR">PR</option>
                            <option value="PE">PE</option>
                            <option value="PI">PI</option>
                            <option value="RJ">RJ</option>
                            <option value="RN">RN</option>
                            <option value="RS">RS</option>
                            <option value="RO">RO</option>
                            <option value="RR">RR</option>
                            <option value="SC">SC</option>
                            <option value="SP">SP</option>
                            <option value="SE">SE</option>
                            <option value="TO">TO</option>
                        </select>
                    </div>
                    <input type="text" name="addressId" value="${address.address_id}" readonly style="display:none">
                    <input type="text" name="customerId" value="${address.customer_customer_id}" readonly style="display:none">

                    <div id="Botoes" class="divsForm">
                        <button type="submit" style="margin-left:30%">Atualiza</button>
                    </div> 

                </fieldset>
            </form>

        </section>

        <c:if test="${hasError eq 'true'}">
            <script>Toasty();</script>  
            <div class="toast" id="EpicToast" role="alert" aria-live="assertive" aria-atomic="true" style="position: absolute; top: 20px; right: 20px;">
                <div class="toast-header">
                    <strong class="mr-auto">Mensagem</strong>
                    <button type="button" class="ml-2 mb-1 close" data-dismiss="toast" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>

                <div class="toast-body">
                    <ul>
                        <c:forEach items="${errorList}" var="p">

                            <li>${p}</li>
                            </c:forEach>
                    </ul>
                </div>
            </div>
        </c:if>


        <!-- Optional JavaScript -->
        <!-- Popper.js first, then Bootstrap JS -->
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js" integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>

        <script>
                var option =
                        {
                            animation: true,
                            delay: 9000
                        };
                function Toasty( )
                {
                    var toastHTMLElement = document.getElementById('EpicToast');
                    var toastElement = new bootstrap.Toast(toastHTMLElement, option);
                    toastElement.show( );
                }
            <c:if test="${hasError eq 'true'}">
                Toasty();
            </c:if>




                $("#cep").focusout(function () {
                    $.ajax({
                        url: 'https://viacep.com.br/ws/' + $(this).val() + '/json/unicode/',
                        dataType: 'json',
                        success: function (resposta) {
                            $("#logradouro").val(resposta.logradouro);
                            $("#complemento").val(resposta.complemento);
                            $("#bairro").val(resposta.bairro);
                            $("#cidade").val(resposta.localidade);
                            $("#uf").val(resposta.uf);
                            $("#numero").focus();
                        }
                    });
                });




        </script>
    </body>
</html>
