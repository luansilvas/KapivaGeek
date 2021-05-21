/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.OrderList;

import br.senac.sp.dao.OrderDAO;
import br.senac.sp.model.Order;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class OrderList_Servlet extends HttpServlet {

   
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
       List<Order> orders  = OrderDAO.getOrders();
       request.setAttribute("order", orders);
        
        request.getRequestDispatcher("/WEB-INF/OrderList.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       String acao = request.getParameter("acao");
       String id = (String) request.getParameter("id");

       
        boolean update = OrderDAO.updateStatus(acao, id);
        if(update)
            response.sendRedirect(request.getContextPath() + "/orderlist");

   
    }

}
