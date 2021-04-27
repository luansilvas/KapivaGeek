/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Address;

import br.senac.sp.model.Address;
import br.senac.sp.dao.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adm
 */
public class Alterar_InativarAddr extends HttpServlet {

   
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
      
    }

  
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    
        
       String opExcluir = request.getParameter("Excluir");
       String opAtualizar = request.getParameter("Atualizar");
       String addrId = request.getParameter("addrId");
       String userId = request.getParameter("UserId");

       if(opExcluir.equals("Excluir")){
           try {
               AddressDAO.isInactive(Integer.parseInt(addrId));
               response.sendRedirect("salvarEndereco?id=" + userId);
           } catch (ClassNotFoundException ex) {
               Logger.getLogger(Alterar_InativarAddr.class.getName()).log(Level.SEVERE, null, ex);
           } catch (SQLException ex) {
               Logger.getLogger(Alterar_InativarAddr.class.getName()).log(Level.SEVERE, null, ex);
           }
       }
       else if(opAtualizar.equals("Atualizar")){
       
       }
       
       
    }

   

}
