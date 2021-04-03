<%-- 
    Document   : menu
    Created on : 17/10/2020, 13:55:27
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <link href="https://fonts.googleapis.com/css2?family=Mandali&display=swap" rel="stylesheet">
    </head>
    <body>




        <nav>
            <div class="nav-wrapper grey lighten-1">
                <a href="index.jsp" data-activates="mobile-demo" class="button-collapse show-on-large"><i class="material-icons">arrow_forward_ios</i></a>
                <a href="protegido/index.jsp" class="brand-logo"><img src="<c:url value="/icons/kapiva.png"/>"  style="width: 70px"></a>
                <ul class="right hide">
                    <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Sass</a></li>
                    <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Components</a></li>
                    <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Javascript</a></li>
                    <li><a href="https://codepen.io/collection/nbBqgY/" target="_blank">Mobile</a></li>
                </ul>

                <ul class="side-nav grey darken-2" id="mobile-demo">


                    <li class="sidenav-header grey lighten-1">
                        <div class="row">
                            <div class="col s4" style="align-components:center;">
                                <img src="<c:url value="/icons/person.jpg"/>" width="42px" height="42px" alt="" class="circle responsive-img valign profile-image">

                            </div>



                            <div>
                                <a class="btn-flat dropdown-button waves-effect waves-light white-text" href="#" data-activates="profile-dropdown"><c:out value="${sessionScope.emp.employeeName}"/><i class="mdi-navigation-arrow-drop-down"></i></a>
                                <!--
                                 <ul id="profile-dropdown" class="dropdown-content">
                                     <li><a href="#" ><i class="material-icons">person</i>Profile</a></li>
                                     <li><a href="#" ><i class="material-icons">settings</i>Setting</a></li>
                                     <li><a href="#" ><i class="material-icons">help</i>Help</a></li>
                                     <li class="divider"></li>
                                     <li><a href="#" ><i class="material-icons">lock</i>Lock</a></li>
                                     <li><a href="#"><i class="material-icons">exit_to_app</i>Logout</a></li>
                                 </ul>-->

                                <a href="<c:url value="/LogoutServlet"/>"><i class="material-icons">power_settings_new</i></a>

                            </div>

                        </div>
                    </li>







                        <li class="white"><a href="<c:url value="/Loja?codFuncionario=${sessionScope.usuario.codFuncionario}"/>"><i><img src="<c:url value="/icons/store.png"/>"></i>Loja</a> 

                        <li class="white"><a href="<c:url value="/ListarCliente"/>"><i><img src="<c:url value="/icons/customer.png"/>"></i>Clientes</a> 

                                

                        <li class="white"><a href="<c:url value="/ListarProdutos"/>"><i><img src="<c:url value="/icons/product.png"/>"></i>Produtos</a> 

                        <li class="white"><a href="<c:url value="/ListarFuncionario"/>"><i><img src="<c:url value="/icons/employee.png"/>"></i>Funcionários<span class="new badge right yellow darken-3" data-badge-caption="Novo"></span></a>
 
                        <li class="white"><a href="<c:url value="/ListarVendas"/>"><i><img src="<c:url value="/icons/bar-chart.png"/>"></i>Vendas</a> 

                    <li class="white"><a href="index.jsp" ><i><img src="<c:url value="/icons/bug.png"/>"></i>Chamado<span class="new badge right yellow darken-3" data-badge-caption="Em Breve"></span></a></li>    
                </ul>

            </div>
        </nav>


        <div >




        </div>










        <style>
            .botao{
                padding: 0px;

            }

            img{
                width: 160%;

            }
            .side-nav li
            a {
                padding: 0 16px;

            }


            body{
                font-family: 'Mandali', sans-serif;
            }

            /*.sidenav-header {
            background: url("../images/user-bg.jpg") no-repeat center center;
            background-size: cover;
            padding: 15px 0 0 15px;
              
            }*/

            .row {
                margin-bottom: 0;

            }
            .social-icons {
            }
            a {
                opacity: 1;
                &:hover {
                    background-color:inherit;
                    opacity: 1;
                }
            }





        </style>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>


        <script>


            $('.button-collapse').sideNav({
                menuWidth: 300, // Default is 300
                edge: 'left', // Choose the horizontal origin
                closeOnClick: false, // Closes side-nav on <a> clicks, useful for Angular/Meteor
                draggable: true // Choose whether you can drag to open on touch screens,
            }
            );
        </script>

    </body>
</html>
