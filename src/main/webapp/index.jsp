<%-- 
    Document   : index
    Created on : 02/03/2021, 22:26:42
    Author     : luans
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/Principal.css" type="text/css">


        <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
        <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

        <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/css/materialize.min.css">
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/icon?family=Material+Icons">
        <title>Home</title>
    </head>
    <body>
        <a href="<c:url value="/ProductList_Servlet"/>">
            Listar produtos
        </a>
        <a href="<c:url value="/ProductList_Servlet"/>">
            Cadastrar Cliente
        </a>
            
        <section id="principal" class="container">
            <div id="boasVindas">
                <h1>4Geeks<img src="images/mario.png"></h1>
            </div>



            <div class="carousel carousel-slider center">

                <div class="carousel-item white-text" href="#one!" style="background-image: url('icons/smaug.jpg');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                    <h2><b>Seja muito bem-vindo!</b></h2>
                    <h5 class="white-text">4Geeks A maior loja geek da península!</h5>
                </div>
                <div class="carousel-item white-text" href="#two!"  style="background-image: url('icons/yoda3.gif');background-position: center center;background-repeat: no-repeat;background-size: cover;">

                    <h2><b>A qualidade vai te surpreender</b></h2>

                    <h5 class="white-text"><b>Melhores estampas e o melhor material pra você</b></h5>
                </div>
                <div class="carousel-item white-text" href="#three!" style="background-image: url('icons/stranger.jpg');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                    <h2><b>MELHORES PREÇOS</b></h2>
                    <h5 class="white-text">Sempre com as melhores ofertas</h5>
                </div>
                <div class="carousel-item white-text" href="#four!" style="background-image: url('icons/daredevil.jpg');background-position: center center;background-repeat: no-repeat;background-size: cover;">
                    <h2>Maior variedade de produtos</h2>
                    <h5 class="white-text">Temos canecas, acessórios, camisetas e muito mais</h5>
                </div>
            </div>

            <div class="row">
                <form class="col s12" action="Home_Servlet" method="POST">
                    <div class="row" style="margin-right:2%;">
                        <div class="input-field col s8">
                            <input id="icon_prefix" type="text" class="validate" name="categoria">
                            <label for="icon_prefix">Pesquise aqui</label>
                            <i class="material-icons prefix">search</i>
                        </div>
                    </div>
                </form>
            </div>

            <div class="row" id="links">
                <div class="col s12">
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=Boneco"/>">Boneco<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id=""href="<c:url value="/Home_Servlet?categoria=Camiseta+masculina"/>">t-shirt M<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=Camiseta+feminina"/>">t-shirt F<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=Caneca"/>">Canecas<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=Acessorio"/>">Acessórios<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=variedade"/>">Variedades<i class="material-icons right"></i></a></div>
                    <div class="select-field col s2"><a class="btn-flat"  id="" href="<c:url value="/Home_Servlet?categoria=all"/>">Tudo<i class="material-icons right"></i></a></div>
                </div>
            </div>

<c:if test="${hasBonecos eq 'true'}">
            <h2>Bonecos</h2>
            <div class="row">
                <c:forEach items="${bonecos}" var="b">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${b.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${b.productName}</h4>
                                <p class="card-text">${b.productFullName}</p>
                                <p class="card-text">${b.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${b.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
</c:if>            
            <c:if test="${hasCM eq 'true'}">
            <h2>Camiseta masculina</h2>
            <div class="row">
                <c:forEach items="${camisetasMasc}" var="cm">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${cm.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${cm.productName}</h4>
                                <p class="card-text">${cm.productFullName}</p>
                                <p class="card-text">${cm.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${cm.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            
            </c:if>
            <c:if test="${hasCF eq 'true'}">
            <h2>Camiseta feminina</h2>
            <div class="row">
                <c:forEach items="${camisetasFem}" var="cf">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${cf.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${cf.productName}</h4>
                                <p class="card-text">${cf.productFullName}</p>
                                <p class="card-text">${cf.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${cf.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
            
            <c:if test="${hasCanecas eq 'true'}">
            <h2>Canecas</h2>
            <div class="row">
                <c:forEach items="${canecas}" var="c">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${c.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${c.productName}</h4>
                                <p class="card-text">${c.productFullName}</p>
                                <p class="card-text">${c.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${c.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
            <c:if test="${hasAcessorios eq 'true'}">
            <h2>Acessórios</h2>
            <div class="row">
                <c:forEach items="${acessorios}" var="a">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${a.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${a.productName}</h4>
                                <p class="card-text">${a.productFullName}</p>
                                <p class="card-text">${a.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${a.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
            <c:if test="${hasVariedades eq 'true'}">
            <h2>Variedades</h2>
            <div class="row">
                <c:forEach items="${variedades}" var="v">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${v.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${v.productName}</h4>
                                <p class="card-text">${v.productFullName}</p>
                                <p class="card-text">${v.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${v.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
            
            
            <c:if test="${hasFiltro eq 'true'}">
            <h2>${filtro}</h2>
            <div class="row">
                <c:forEach items="${resultado}" var="r">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${r.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${r.productName}</h4>
                                <p class="card-text">${r.productFullName}</p>
                                <p class="card-text">${r.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${r.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
            
            <c:if test="${hasFiltro eq 'pesquisa'}">
            <h2>Resultados para '${filtro}'</h2>

            <div class="row">
                <c:forEach items="${resultado}" var="r">
                    <div id="cards" class="">
                        <div class="card" style="width:300px; height:500px;">
                            <img class="card-img-top" src="${r.path_MainImg}" alt="Card image">
                            <div class="card-body">
                                <h4 class="card-title">${r.productName}</h4>
                                <p class="card-text">${r.productFullName}</p>
                                <p class="card-text">${r.price}</p>
                                <a href="<c:url value="/seeProductDetail?productId=${r.productId}"/>" class="btn btn-primary">Detalhes</a>
                            </div>
                        </div>
                    </div>
                </c:forEach>

            </div>
            </c:if>
                        <c:if test="${hasFiltro eq 'naoachouresultado'}">
            <h2>Resultados para '${filtro}'</h2>

            <div class="row">
                <h5>Não achamos nenhum produto nesse nome</h5>

            </div>
            </c:if>
            
            

        </section>

        <footer>
            <c:import url="footer.jsp" />
        </footer> 


        <script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.98.0/js/materialize.min.js"></script>


        <script>
            autoplay()
            function autoplay() {
                $('.carousel').carousel('next');
                setTimeout(autoplay, 4500);
            }

            $('.carousel.carousel-slider').carousel({
                dist: 0,
                padding: 0,
                fullWidth: true,
                indicators: true,
                duration: 200,
            });


        </script>
    </body>
</html>
