/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raque
 */
public class ProductList_Servlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> lista = new ArrayList(); 
        lista = productDAO.findProduct();
        System.out.println(lista.get(0).getProductName());
        request.setAttribute("productList", lista);
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        String pesquisa = request.getParameter("pesquisa");
    
        List<Product> lista = new ArrayList(); 
        lista = productDAO.findProduct(pesquisa);
        
        request.setAttribute("productList", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
        
        
    }

  

}
