/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Address;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.dao.*;
import br.senac.sp.model.*;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adm
 */
public class NovoEnderecoServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int costumerId = Integer.parseInt(request.getParameter("id"));
        System.out.println(costumerId);
        List<Address> addr = AddressDAO.getCustomerAddresses(costumerId);
        HttpSession sessao = request.getSession();
        sessao.setAttribute("addr", addr);
        response.sendRedirect(request.getContextPath() + "/alterRegister_Costumer");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int userId = Integer.parseInt(request.getParameter("UserId"));
        String tituloStr = request.getParameter("NovoTitulo");
        String cepStr = request.getParameter("Novocep");
        String ruaStr = request.getParameter("NovaRua");
        String numeroStr = request.getParameter("NovoNumero");
        String complementoStr = request.getParameter("NovoComplemento");
        String ufStr = request.getParameter("Novouf");
        String bairroStr = request.getParameter("NovoBairro");
        
        
        boolean validaCEP = validaCEP(cepStr);
        
        if(!validaCEP){
             request.setAttribute("CepError", "CEP inválido");
             
              RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/alterarUsuario.jsp");
            dispatcher.forward(request, response);
             
        }
        
        Address addr = new Address(userId, tituloStr, ruaStr, cepStr, ufStr, numeroStr, bairroStr, complementoStr, "Entrega", "Ativo");

        try {
            AddressDAO.addAddress(addr);
            response.sendRedirect("salvarEndereco?id=" + userId);
        } catch (SQLException ex) {
            Logger.getLogger(NovoEnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoEnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
       public static boolean validaCEP(String cep){
        for(int i =0;i<cep.trim().length();i++){
            if(validaCampo(cep.charAt(i)) == false || cep.length() < 9)
                return false;
        }
        
        return true;
    }
    
    public static boolean validaCampo(char letra){
        String caracter = String.valueOf(letra);
        if(caracter.matches("[0-9]+") || caracter.equalsIgnoreCase("-"))
            return true;
        
        return false;
    
    }
}
