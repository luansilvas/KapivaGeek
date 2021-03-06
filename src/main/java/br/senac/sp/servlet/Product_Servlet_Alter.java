/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.dao.*;

/**
 *
 * @author Gabriel
 */
public class Product_Servlet_Alter extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("codProduto"));
        
        ProductDAO dao = new ProductDAO();
        
         request.setAttribute("productId", productId);
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Form_Alter_Prod.jsp");
         dispatcher.forward(request, response);
        
    }
  
@Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
       
    
    }

}
