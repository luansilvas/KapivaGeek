/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.AddressDAO;
import br.senac.sp.dao.CustomerDAO;
import br.senac.sp.model.Address;
import br.senac.sp.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luans
 */
public class InativateAddress_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("acao").equals("consulta")) {
            int address_id = Integer.parseInt(request.getParameter("address_id"));
            Address address = AddressDAO.getAddress(address_id);
            request.setAttribute("address", address);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/ativaInativaEndereco.jsp");

            requestDispatcher.forward(request, response);
        } else if (request.getParameter("acao").equals("inativa")) {
                int address_id = Integer.parseInt(request.getParameter("address_id"));
                Address address = AddressDAO.getAddress(address_id);
                AddressDAO.inativate(address_id);
                request.setAttribute("address", address);
                HttpSession sessao = request.getSession();  
                
                
                Customer customer = CustomerDAO.getCustomer(address.getCustomer_customer_id());
                List<Address> addr = AddressDAO.getCustomerAddresses(customer.getCustomer_id());
                
                sessao.removeAttribute("addr");
                
                sessao.setAttribute("addr", addr);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/alterarUsuario.jsp");
                requestDispatcher.forward(request, response);
            
        }

    }

}
