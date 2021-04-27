<%-- 
    Document   : alterarUsuario
    Created on : 24/04/2021, 16:06:36
    Author     : raque
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/style_Perfil.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
        <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/5.0.0-alpha1/js/bootstrap.min.js" integrity="sha384-oesi62hOLfzrys4LxRF63OJCXdXDipiYWBnvTl9Y9/TRlw5xlKIEHpNyvvDShgf/" crossorigin="anonymous"></script>
        <script>
            function changeImage(objeto, caminhoNovaImagem) {

                document.getElementById(objeto).src = caminhoNovaImagem;
            }

        </script>
        <title>Document</title>
    </head>
    <body>
       

        <section id="main" class="container">
            <a href="<c:url value="/Home_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form id="FormAlterar" method="post" action="<c:url value="/RegisterCustomer_Servlet"/>" novalidate class="form">
                <fieldset>
                    <legend>Meus dados</legend>
                    
                    <div class="divsForm infosForm">
                        <label>Nome:</label>
                        <br>
                        <input type="text" name="name" placeholder="Nome completo" value="${user.customer_name}">
                    </div>
                    <div class="divsForm infosForm">  
                        <label>CPF:</label>
                        <br>
                        <input type="text" name="cpf" placeholder="CPF" value="${user.customer_cpf}">
                    </div>
                    <div class="divsForm infosForm">
                        <label>email:</label>
                        <br>
                        <input type="email" name="email" value="${user.customer_email}">
                    </div>

                    <div  class="infosForm">
                        <button type="submit" style="margin-left:30%">Alterar</button>
                    </div> 
                </fieldset>
            </form>

            <div id="endCadastrado">
                <legend>Endereços cadastrados:</legend>
                <c:forEach items="${addr}" var="a">
                    <form id="formulario" method="post" action="${pageContext.request.contextPath}/Alterar_InativarAddr">
                      <input type="hidden" name="UserId" value="${user.customer_id}">
                        <input type="text" name="addrId" value="${a.address_id}">
                    <div class="divsForm infosForm">
                        <input type="text" name="titulo"  id="titulo" value="${a.address_title}" readonly>
                        <br>
                    </div>
                    <div class="divsForm infosForm">
                        <label>CEP:</label>
                        <br>
                        <input type="text" name="cep" placeholder="CEP" value="${a.address_code}" readonly="" >
                        <br>
                    </div>
                    <div class=" divsForm infosForm" id="senha">
                        <label>Rua:</label>
                        <br>
                        <input type="text" value="${a.address_street}" readonly>
                        <input type="text"  value="${a.address_number}" readonly>
                    </div>

                    <div class="divsForm infosForm">
                        <label>Complemento:</label>
                        <br>
                        <input type="text" value="${a.address_complement}" readonly>
                    </div>
                    <div class="divsForm infosForm">
                        <label>Bairro:</label>
                        <br>
                        <input type="text" value="${a.address_neighborhood}" readonly>
                    </div>
                    <div class="divsForm infosForm" id="estado">
                        <label>Estado:</label>
                        <br>
                        <input type="text" value="${a.address_state_abbreviation}" readonly>
                    </div>
                    <div>
                        <br>
                        <button type="submit" name="Atualizar" value="Atualizar">Atualizar</button>
                        <button type="submit" name="Excluir" value="Excluir">Excluir</button>
                    </div>
                  </form>
                </c:forEach>
            </div>
        </section>

        <div class="container">
            <legend>Adicionar Novo Endereço:</legend>
            <a class="imgCollapse" type="button" data-toggle="collapse" data-target="#demo"
               onclick="changeImage('image', 'images/minus.png')"><img id="image" src="images/add.png"></a>
            <div id="demo" class="collapse">
                <form id="formulario" method="post" action="${pageContext.request.contextPath}/salvarEndereco">
                    <input type="hidden" name="UserId" value="${user.customer_id}">
                    <div class="divsForm infosForm">
                        <input type="text" name="NovoTitulo" placeholder="Digite um nome de verificação" id="titulo">
                        <br>
                    </div>
                    <div class="divsForm infosForm">
                        <label>CEP:</label>
                        <br>
                        <input type="text" name="Novocep" placeholder="CEP" id="cep" >
                        <br>
                    </div>
                    <div class=" divsForm infosForm" id="senha">
                        <label>Rua:</label>
                        <br>
                        <input type="text" placeholder="Rua" name="NovaRua" id="logradouro" readonly>
                        <input type="text" placeholder="Número" name="NovoNumero" id="numero">
                    </div>

                    <div class="divsForm infosForm">
                        <label>Complemento:</label>
                        <br>
                        <input type="text" name="NovoComplemento" id="complemento">
                    </div>
                    <div class="divsForm infosForm">
                        <label>Bairro:</label>
                        <br>
                        <input type="text" name="NovoBairro" id="bairro" readonly>
                    </div>
                    <div class="divsForm infosForm">
                        <label>Estado:</label>
                        <select id="uf" name="Novouf" readonly="readonly" tabindex="-1" aria-disabled="true">
                            <option>Escolha...</option>
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
                    <div class="infosForm">
                        <button type="submit">Salvar</button>
                        <button type="reset">Cancelar</button>
                    </div>
                </form>
            </div>
        </div>

        <a class="nav-link" href="${pageContext.request.contextPath}/UserLogout">Sair</a>

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
