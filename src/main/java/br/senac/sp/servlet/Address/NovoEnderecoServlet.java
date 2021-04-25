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
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author adm
 */
public class NovoEnderecoServlet extends HttpServlet {

   

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
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
        
        Address addr = new Address(userId, ruaStr, cepStr, ufStr, numeroStr, bairroStr, complementoStr, "Entrega", "Ativo");
        
        try {
            AddressDAO.addAddress(addr);
            response.sendRedirect(request.getContextPath() + "/alterRegister_Costumer");
        } catch (SQLException ex) {
            Logger.getLogger(NovoEnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(NovoEnderecoServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }



}
