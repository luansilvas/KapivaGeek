<%-- 
    Document   : AtualizarDadosUsuario
    Created on : 27/04/2021, 13:21:38
    Author     : luans
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Atualizar dados cadastrais</title>
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
            <form class="formCadastro" method="post" action="<c:url value="/updateCustomer_Servlet"/>" novalidate class="form">
                <fieldset>

                    <legend>Atualizar cadastro</legend>

                    <div class="divsForm">
                        <label>Nome</label>
                        <br>
                        <input type="text" name="name" placeholder="Nome completo" value="${customer.customer_name}">
                    </div>
                    <div class="divsForm">  
                        <label>CPF</label>
                        <br>
                        <input type="text" name="cpf" placeholder="CPF" value="${customer.customer_cpf}" readonly>
                    </div>
                    <div class="divsForm">
                        <label>email</label>
                        <br>
                        <input type="email" name="email" value="${customer.customer_email}" readonly>
                    </div>
                    <input type="text" name="idCustomer" placeholder="" value="${customer.customer_id}" readonly style="display:none">

                    <div id="Botoes" class="divsForm">
                        <button type="submit" style="margin-left:30%">Atualizar</button>
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
