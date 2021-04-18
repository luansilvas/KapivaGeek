<%-- 
    Document   : NovoUsuario
    Created on : 18/04/2021, 01:10:06
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

            <a href="<c:url value="/Home_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form class="formCadastro" method="post" action="<c:url value="/RegisterCustomer_Servlet"/>" novalidate class="form">
                <fieldset>

                    <legend>Cadastro</legend>

                    <div class="divsForm">
                        <label>Nome</label>
                        <br>
                        <input type="text" name="name" placeholder="Nome completo" value="${customer.name}">
                    </div>
                    <div class="divsForm">  
                        <label>CPF</label>
                        <br>
                        <input type="text" name="cpf" placeholder="CPF" value="${customer.cpf}">
                    </div>
                    <div class="divsForm">
                        <label>email</label>
                        <br>
                        <input type="email" value="${customer.email}">
                    </div>
                    <div class="divsForm" id="senha">
                        <label>Senha</label>
                        <input type="password" name="pass" placeholder="Senha">
                        <input type="password" name="passConf" placeholder="Confirme a senha">
                    </div>
                    <legend id="end-faturamento">Endereço</legend>
                    <div class="divsForm">
                        <label>CEP</label>
                        <br>
                        <input type="text" name="cep" placeholder="CEP" id="cep">
                        <br>
                    </div>
                    <div class="divsForm" id="senha">
                        <label>Logradouro</label>
                        <br>
                        <input type="text" placeholder="Logradouro" name="address" id="logradouro">
                        <input type="text" placeholder="Número" name="number" id="numero">
                    </div>

                    <div class="divsForm">
                        <label>Complemento</label>
                        <br>
                        <input type="text" value="" name="complement" id="complemento">
                    </div>
                    <div class="divsForm">
                        <label>Bairro</label>
                        <br>
                        <input type="text" value=""  name="neighborhood" id="bairro">
                    </div>
                    <div class="divsForm">
                        <label>Estado</label>
                        <select id="uf" name="uf">
                            <option value="">Estado</option>
                            <option value="AC">Acre</option>
                            <option value="AL">Alagoas</option>
                            <option value="AP">Amapá</option>
                            <option value="AM">Amazonas</option>
                            <option value="BA">Bahia</option>
                            <option value="CE">Ceará</option>
                            <option value="DF">Distrito Federal</option>
                            <option value="ES">Espírito Santo</option>
                            <option value="GO">Goiás</option>
                            <option value="MA">Maranhão</option>
                            <option value="MT">Mato Grosso</option>
                            <option value="MS">Mato Grosso do Sul</option>
                            <option value="MG">Minas Gerais</option>
                            <option value="PA">Pará</option>
                            <option value="PB">Paraíba</option>
                            <option value="PR">Paraná</option>
                            <option value="PE">Pernambuco</option>
                            <option value="PI">Piauí</option>
                            <option value="RJ">Rio de Janeiro</option>
                            <option value="RN">Rio Grande do Norte</option>
                            <option value="RS">Rio Grande do Sul</option>
                            <option value="RO">Rondônia</option>
                            <option value="RR">Roraima</option>
                            <option value="SC">Santa Catarina</option>
                            <option value="SP">São Paulo</option>
                            <option value="SE">Sergipe</option>
                            <option value="TO">Tocantins</option>
                        </select>
                    </div>
                    <div id="Botoes" class="divsForm">
                        <button type="submit" style="margin-left:30%">Cadastrar</button>
                    </div> 
                </fieldset>
            </form>

        </section>

        <c:if test="${hasError eq 'true'}">
            <script>Toasty( )</script>  





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
//                var option =
//                        {
//                            animation: true,
//                            delay: 9000
//                        };
//                function Toasty( )
//                {
//                    var toastHTMLElement = document.getElementById('EpicToast');
//
//                    var toastElement = new bootstrap.Toast(toastHTMLElement, option);
//
//                    toastElement.show( );
//                }
//                Toasty( );

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
