<%-- 
    Document   : listarProdutos
    Created on : 04/03/2021, 22:33:47
    Author     : luans
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>KapivaGeek - listar produtos</title>
    </head>
    <body>
        <fieldset class= "general-fieldset">
            <legend>Listar produtos</legend>  
            <form methodo="post">
                <div>
                    <label>Procurar</label>
                    <input type="text">
                    <label><img src="icons/search.png" alt="Lupa"></label>
                </div>
            </form>
                <br>
                <div>
                    <table border=1>
                    <tr>
                        <th>Nome do produto</th>
                        <th>Qnt. Estoque</th> 
                        <th>Status</th>
                        <th>Editar</th>
                        <th>Inativar/Reativar</th>
                        <th>Visualizar</th>
                    </tr>
                    
                    <tr>
                        <td>Camiseta StarWars</td>
                        <td>30</td>
                        <td>Ativo</td>
                        <td><a href="#">EDITAR</a></td>
                        <td><a href="#">INATIVAR/REATIVAR</a></td>
                        <td><a href="#">VISUALIZAR</a></td>
                    </tr>
                    <tr>
                        <td>Funko Pop - Harry Potter</td>
                        <td>30</td>
                        <td>Ativo</td>
                        <td><a href="#">EDITAR</a></td>
                        <td><a href="#">INATIVAR/REATIVAR</a></td>
                        <td><a href="#">VISUALIZAR</a></td>
                    </tr>                      
                    </table>

                </div>
            
            <div>
                <img src="icons/seta2-left.png" alt="icone next">
                <img src="icons/seta-left.png" alt="icone next">
                <img src="icons/seta-right.png" alt="icone next">
                <img src="icons/seta2-right.png" alt="icone next">
                
                
                
            </div>
        </fieldset>
    </body>
</html>
