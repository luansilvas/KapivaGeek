<%-- 
    Document   : UserLogin
    Created on : 19/04/2021, 23:18:20
    Author     : adm
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <link rel="stylesheet" href="css/styleLoginUsr.css">
        <title>Login Usuário</title>
    </head>
    <body class="">
        <section id="container" class="container-fluid">
            <div id="logo" class="">
                <img src="images/kapiva(logo).png">
            </div>
            <div id="loginusr">
                <c:if test="${msgErro!= null}">
                    <span class="msgErro"><c:out value="${msgErro}"/></span>
                </c:if>
                <form method="post" action="${pageContext.request.contextPath}/Loginusr" >
                    <div id="usuario">
                        <label>Usuário:</label>
                        <input type="text" name="username"/>
                    </div>
                    <div id="senha" >
                        <label>Senha:</label>
                        <input type="password" name="password"/>
                    </div>
                    <div id="botoes">
                        <input type="submit" value="Entrar">
                        <input type="reset" value="Cancelar">
                    </div>

                </form>

            </div>
        </section>
    </body>
</html>
