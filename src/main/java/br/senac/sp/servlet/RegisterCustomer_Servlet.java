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
import java.util.ArrayList;
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
        List<String> errorList = new ArrayList();

        try {

            String name = request.getParameter("name");
            String cpf = request.getParameter("cpf");
            String email = request.getParameter("email");
            String password = request.getParameter("pass");
            String confPassword = request.getParameter("Confpass");
            String title = " ";
            if (request.getParameter("titulo")!=null) {
                title = request.getParameter("titulo");
            }
            String street = request.getParameter("street");
            String cep = request.getParameter("cep");
            String number = request.getParameter("number");
            String complement = " ";
            if (request.getParameter("complement")!=null) {
            complement = request.getParameter("complement");    
            }
            String neighborhood = request.getParameter("neighborhood");
            String uf = request.getParameter("uf");
            String destino = "";
            String copiarEnderecoFaturamento = "";

            if (request.getParameter("copiarFaturamento") != null) {
                copiarEnderecoFaturamento = request.getParameter("copiarFaturamento");
            }

            Customer customer = new Customer(name, cpf, email, password);
            System.out.println(customer);
            CustomerDataValidation customerData = new CustomerDataValidation();
            errorList = customerData.validParamethers(name, cpf, email, "Ativo", password, confPassword);
            Address address = new Address(street, cep, uf, number, neighborhood, complement, "Faturamento", "Ativo");
            errorList = customerData.validaEndereco(street, cep, uf, number, neighborhood, complement, cep, street, errorList);
            if (errorList.size() == 0) {
                try {
                    int idCustomer = CustomerDAO.addCustomer(customer);

                    Address addressWithCustomerId = new Address(idCustomer, title,street, cep, uf, number, neighborhood, complement, "Faturamento", "Ativo");
                    Address addressWithCustomerIdToDeliver = new Address(idCustomer,title ,street, cep, uf, number, neighborhood, complement, "Entrega", "Ativo");
                    try {
                        AddressDAO.addAddress(addressWithCustomerId);
                        if (copiarEnderecoFaturamento != "") {
                            AddressDAO.addAddress(addressWithCustomerIdToDeliver);
                            destino = "/WEB-INF/UserLogin.jsp";
                        } else {
                            Address addressCustomerId = new Address(idCustomer, "","", "", "", "", "", "", "", "");
                            request.setAttribute("address", addressCustomerId);                                                 
                            destino = "/adicionarEnderecoEntrega.jsp";
                        }

                    } catch (Exception e) {//no caso de existirem erros ao salvar o endereco.
                        CustomerDAO.deleteCustomer(idCustomer);
                        System.out.println(e.getMessage());
                        errorList.add("Houve erro ao salvar o endereço. Tente novamente mais tarde.");
                        request.setAttribute("errorList", errorList);
                        request.setAttribute("customer", customer);
                        request.setAttribute("address", address);
                        request.setAttribute("hasError", "true");
                        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                        requestDispatcher.forward(request, response);

                    }
                    request.setAttribute("hasError", "false");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(destino);
                    requestDispatcher.forward(request, response);

                } catch (Exception ex) { //no caso de erros ao salvar o usuario
                    System.out.println(ex.getMessage());
                    errorList.add("Houve erro. Tente novamente mais tarde.");
                    System.out.println(ex.getMessage());
                    request.setAttribute("errorList", errorList);
                    request.setAttribute("customer", customer);
                    request.setAttribute("address", address);
                    request.setAttribute("hasError", "true");
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                    requestDispatcher.forward(request, response);

                }

            } else { //no caso de existirem erros
                request.setAttribute("customer", customer);
                request.setAttribute("address", address);
                request.setAttribute("hasError", "true");
                request.setAttribute("errorList", errorList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
                requestDispatcher.forward(request, response);
            }

        } catch (Exception e) {
            errorList.add("Erro desconhecido");
            System.out.println(e.getMessage());
            request.setAttribute("hasError", "true");
            request.setAttribute("errorList", errorList);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/NovoUsuario.jsp");
            requestDispatcher.forward(request, response);

        }

    }
}
