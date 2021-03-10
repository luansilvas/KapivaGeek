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
import br.senac.sp.model.*;
import br.senac.sp.dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
public class Inactive_Reactive_Prod_Servlet extends HttpServlet {

    

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("codProduto"));
        System.out.println(productId);
        try {
            ProductDAO dao = new ProductDAO();
            Product prod = dao.findProductById(productId);
            boolean statusValue = prod.getValueStatus(prod.getStatus());
            request.setAttribute("IdProduto", productId);
            request.setAttribute("statusValue", statusValue);
            request.setAttribute("product", prod);
 
 
         RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Inactive_Reactive_Product.jsp");
        dispatcher.forward(request, response);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
      
       
       
    }
    
 @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String productId = request.getParameter("prodId");
        String newStatus = request.getParameter("novoStatus");
        
        ProductDAO dao = new ProductDAO();
        dao.StatusUpdate(Integer.parseInt(productId), newStatus);
        response.sendRedirect("ProductList_Servlet");
        
    }
  
   

}
