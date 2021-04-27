/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.AddressDAO;
import br.senac.sp.model.Address;
import java.io.IOException;
import java.io.PrintWriter;
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
public class alterRegister_Costumer extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       // int costumerId = Integer.parseInt(request.getParameter("costumerId"));
         // List<Address> addr = AddressDAO.getCustomerAddresses(costumerId);
          //request.setAttribute("addr", addr);
        
        
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alterarUsuario.jsp");
        dispatcher.forward(request, response);
    }


    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
