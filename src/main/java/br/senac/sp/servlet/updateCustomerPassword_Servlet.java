/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.CustomerDAO;
import br.senac.sp.model.Customer;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CustomerDataValidation;

public class updateCustomerPassword_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int idCustomer = Integer.parseInt(request.getParameter("customerId"));
        Customer customer = CustomerDAO.getCustomer(idCustomer);
        request.setAttribute("customer", customer);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/atualizarSenhaUsuario.jsp");
        dispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String password = request.getParameter("pass");
        int idCustomer = Integer.parseInt(request.getParameter("idCustomer"));
        String confPassword = request.getParameter("Confpass");

        CustomerDataValidation customerData = new CustomerDataValidation();
        Customer customer = new Customer(idCustomer, "", "", "", password);
        List<String> errorList = customerData.validParamethersUpdatePassword(password, confPassword);
        if (errorList.size() == 0) {
            try {
                CustomerDAO.updateCustomerPassword(customer);

                errorList.add("Senha atualizado com sucesso");
            } catch (Exception e) {
                errorList.add(e.getLocalizedMessage());
            }

        }
        request.setAttribute("errorList", errorList);
        request.setAttribute("customer", customer);
        request.setAttribute("hasError", "true");
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/atualizarSenhaUsuario.jsp");
        requestDispatcher.forward(request, response);

    }

}
