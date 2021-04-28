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
import utils.CustomerDataValidation;

/**
 *
 * @author luans
 */
public class AlterCustomerAddress_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int address_id = Integer.parseInt(request.getParameter("address_id"));
        Address address = AddressDAO.getAddress(address_id);
        request.setAttribute("address", address);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/atualizaEnderecoUsuario.jsp");

        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String complement = " ";
        int addressId = Integer.parseInt(request.getParameter("addressId"));
        int customerId = Integer.parseInt(request.getParameter("customerId"));
        String title = request.getParameter("titulo");
        String street = request.getParameter("street");
        String cep = request.getParameter("cep");
        String number = request.getParameter("number");
        if (request.getParameter("complement") != null) {
            complement = request.getParameter("complement");
        }

        String neighborhood = request.getParameter("neighborhood");
        String uf = request.getParameter("uf");

        CustomerDataValidation customerData = new CustomerDataValidation();
        List<String> errorList = customerData.validaAtualizaEndereco(street, cep, uf, number, neighborhood, complement, cep, street);

        Address currentAddress = AddressDAO.getAddress(addressId);
        Address address = new Address(addressId,customerId,title,street, cep, uf, number, neighborhood, complement, currentAddress.getAddress_type(), "Ativo");

        if (errorList.size() == 0) {
            try {

                AddressDAO.updateAddress(address);
                address = AddressDAO.getAddress(addressId);
                
                Customer customer = CustomerDAO.getCustomer(address.getCustomer_customer_id());
                List<Address> addr = AddressDAO.getCustomerAddresses(customer.getCustomer_id());
                Address addrFat = AddressDAO.getCustomerIncomeAddresses(customer.getCustomer_id());
                HttpSession sessao = request.getSession(); 
                sessao.removeAttribute("addr");
                sessao.removeAttribute("addrFat");
                sessao.setAttribute("addr", addr);
                sessao.setAttribute("addrFat", addrFat);
                errorList.add("Endreco atualizado com sucesso");
                request.setAttribute("errorList", errorList);
                request.setAttribute("address", address);
                request.setAttribute("hasError", "true");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/atualizaEnderecoUsuario.jsp");
                requestDispatcher.forward(request, response);
            } catch (Exception e) {
                errorList.add("Houve erro. Tente novamente mais tarde.");
                request.setAttribute("errorList", errorList);
                request.setAttribute("address", address);
                request.setAttribute("hasError", "true");
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/atualizaEnderecoUsuario.jsp");
                requestDispatcher.forward(request, response);
            }
        } else {
            request.setAttribute("errorList", errorList);
            request.setAttribute("address", address);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/atualizaEnderecoUsuario.jsp");
            requestDispatcher.forward(request, response);

        }

    }

}
