<%-- 
    Document   : menuFuncionario
    Created on : 03/04/2021, 18:05:43
    Author     : luans
--%>    <style>
    @import url('https://fonts.googleapis.com/css2?family=Press+Start+2P&display=swap');
    #logo{
       width: 150px;
    }
    #navItem{
        font-size: 20px;
        
    }
    
    #navItem-transp a{
        margin: 5px;
        text-indent: -9999px;
        font-size: 20px;
        
    }
    
    
    #sair{
       font-size: 20px;
       
    }
    
 

        </style>

        <nav class="navbar navbar-expand-lg navbar-light bg-light">
            <div class="container-fluid">
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarTogglerDemo03" aria-controls="navbarTogglerDemo03" aria-expanded="false" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>
                <a class="navbar-brand" href="#"><img src="images/kapiva(logo).png" alt="Kapiva Logo" id="logo"></a>
                
                <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
                    <ul class="navbar-nav me-auto mb-2 mb-lg-0">
                        
                         <li class="nav-item" id="navItem">
                             <a class="nav-link active"><c:out value="Welcome ${sessionScope.emp.employeeName}"/></a>
                        </li>
                      
                        
                        <li class="nav-item" id="navItem-transp">
                            <a class="nav-link" aria-current="page" href="#">Produtos</a>
                        </li>
                        
                        <li class="nav-item" id="navItem">
                            <a class="nav-link" aria-current="page" href="ProductList_Servlet#">Produtos</a>
                        </li>
                        
                       
                        
                        <li class="nav-item" id="navItem" >
                            <a class="nav-link" href="${pageContext.request.contextPath}/ListEmployee_Servlet?currentRecord=10&acao=FirstAccess">Funcionários</a>
                        </li>
                        
                         <li class="nav-item" id="navItem" >
                             <a class="nav-link" rel="external" target="blank_" href="${pageContext.request.contextPath}/Home_Servlet">Loja</a>
                        </li>
                        
                       
                         <li class="nav-item" id="sair" >
                            <a class="nav-link" href="${pageContext.request.contextPath}/LogoutServlet">Sair</a>
                        </li>
                        
                       
                                           
                    </ul>
                    
                </div>
            </div>
        </nav>
