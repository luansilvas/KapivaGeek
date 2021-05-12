/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Orders;

import br.senac.sp.dao.OrderDAO;
import br.senac.sp.model.Order;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raque
 */
public class VerDetalhes_Servlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idURL = request.getParameter("orderId");
        System.out.println(idURL);
        List<Product> ord = OrderDAO.getProdPedido(idURL);
        System.out.println(ord.toString());
        request.setAttribute("detalhesPedido", ord);
        request.getRequestDispatcher("/WEB-INF/DetalhesProduto.jsp").forward(request, response);
    }

 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
