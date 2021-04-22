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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.CustomerDataValidation;

/**
 *
 * @author luans
 */
public class RegisterCustomer_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String cpf = request.getParameter("cpf");
        String email = request.getParameter("email");
        String password = request.getParameter("pass");
        String confPassword = request.getParameter("Confpass");

        String street = request.getParameter("street");
        String cep = request.getParameter("cep");
        String number = request.getParameter("number");
        String complement = request.getParameter("complement");
        String neighborhood = request.getParameter("neighborhood");
        String uf = request.getParameter("uf");

        Customer customer = new Customer(name, cpf, email, password);

        CustomerDataValidation customerData = new CustomerDataValidation();
        List<String> errorList = customerData.validParamethers(name, cpf, email, "Ativo", password, confPassword);
        Address address = new Address(street, cep, uf, number, neighborhood, complement, "Faturamento", "Ativo");
        errorList = customerData.validaEndereco(street, cep, uf, number, neighborhood, complement, cep, street, errorList);
        if (errorList.size() == 0) {
            try {

                int idCustomer = CustomerDAO.addCustomer(customer);                            
                Address addressWithCustomerId = new Address(idCustomer,street, cep, uf, number, neighborhood, complement, "Faturamento", "Ativo");            
                try{
                AddressDAO.addAddress(addressWithCustomerId);               
                }catch(Exception e){
                CustomerDAO.deleteCustomer(idCustomer);
                System.out.println(e.getMessage());
                errorList.add("Houve erro ao salvar o endereço. Tente novamente mais tarde.");
                request.setAttribute("customer", customer);
                request.setAttribute("address", address);
                request.setAttribute("hasError", "true");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                requestDispatcher.forward(request, response);
                
                }                             
                request.setAttribute("hasError", "false");
                
            } catch (SQLException ex) {
                if (ex.getMessage().contains("Duplicate")) {
                    System.out.println("E-mail ou CPF já existe no banco.");
                    errorList.add("E-mail ou CPF já existem no banco.");
                    request.setAttribute("customer", customer);
                    request.setAttribute("address", address);
                    request.setAttribute("hasError", "true");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                    requestDispatcher.forward(request, response);
                } else {
                    System.out.println(ex.getMessage());
                    errorList.add("Houve erro inesperado. Tente novamente mais tarde.");
                    request.setAttribute("customer", customer);
                    request.setAttribute("address", address);
                    request.setAttribute("hasError", "true");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException ex) {
                System.out.println(ex.getMessage());
                errorList.add("Houve erro. Tente novamente mais tarde.");
                request.setAttribute("customer", customer);
                request.setAttribute("address", address);
                request.setAttribute("hasError", "true");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                requestDispatcher.forward(request, response);

            }

        } else {
            request.setAttribute("customer", customer);
            request.setAttribute("address", address);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
