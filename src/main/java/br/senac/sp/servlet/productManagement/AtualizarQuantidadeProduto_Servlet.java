/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.productManagement;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class AtualizarQuantidadeProduto_Servlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         int idProduto = Integer.parseInt(request.getParameter("id"));
        
       
            Product prod = ProductDAO.findProductById(idProduto);
            System.out.println(prod.toString());
            request.setAttribute("prod", prod);
            request.getRequestDispatcher("/WEB-INF/AdicionarQuantidade.jsp").forward(request, response); 

     
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int novaQuantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idProduto = Integer.parseInt(request.getParameter("idProd"));
        System.out.println(idProduto);
        
       
        
        if(ProductDAO.updateQtd(idProduto, novaQuantidade))
            response.sendRedirect(request.getContextPath() +"/ProductList_Servlet");
        
        else
            System.out.println("deu ruim");
    }

    
}
