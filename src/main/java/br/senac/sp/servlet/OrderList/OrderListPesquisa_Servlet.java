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
import java.time.LocalDate;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class OrderListPesquisa_Servlet extends HttpServlet {
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        
       
        
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String id = (String) request.getParameter("pesquisa");
        LocalDate data =  LocalDate.parse(request.getParameter("dataPesq"));
        System.out.println(data);
        
       if(!id.equals("")){
        List<Order> orders = OrderDAO.getOrderById(id);
        request.setAttribute("order", orders);
       }
       else if(!data.equals("")){
           System.out.println("passou");
       List<Order> orders = OrderDAO.getOrderByDate(data);
        request.setAttribute("order", orders);
       }
        request.getRequestDispatcher("/WEB-INF/OrderList_ResultadoPesquisa.jsp").forward(request, response);

        
    }

   

}
