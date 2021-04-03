<%-- 
    Document   : AtivarInativarFuncionario
    Created on : 01/04/2021, 02:13:49
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/EmployeeFormStyle.css" type="text/css">
        <title>${acao} Funcionário</title>

        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>
    </head>
    <body>

        <section id="main" class="containerMain">

            <a href="<c:url value="/EmployeeList_Servlet"/>" class="go-back">
                <img src="icons/left-arrow.png">
            </a>
            <form id="formCadastro" novalidate class="form">
                <fieldset>

                    <legend>Visualizar Funcionário</legend>
                    <img src="images/kapiva.jpg" style="width: 180px;height: 140px;margin-left: 40%;border-radius: 100%;">
                    <div class="divsForm">
                        <label>Nome</label>
                        <br>
                        <input type="text" name="name" placeholder="Nome do funcionario" value="${employee.employeeName}" readonly="readonly">

                    </div>

                    <div class="divsForm">  

                        <label>Cargo</label>

                        <input value="${employee.employeeRole}" readonly="readonly">
                    </div>

                    <div class="divsForm">
                        <label>email</label>
                        <br>
                        <input value="${employee.employeeEmail}">
                    </div>

                    <div class="divsForm">
                        <label>Status</label>
                        <br>                            
                        <input value="${employee.employeeStatus}" readonly="readonly">

                    </div>
                </fieldset>         
            </form>
        </section>

        <c:if test="${hasError eq 'true'}">
            <script>Toasty( )</script>  





            <div class="toast" id="EpicToast" role="alert" aria-live="assertive" aria-atomic="true" style="position: absolute; top: 20px; right: 20px;">
                <div class="toast-header">
                    <strong class="mr-auto">Erro ao cadastrar</strong>

                    <small>Mensagem</small>

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
                Toasty( );

        </script>
    </body>
</html>
