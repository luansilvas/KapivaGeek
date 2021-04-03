/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.model.*;
import br.senac.sp.dao.*;

/**
 *
 * @author Gabriel
 */
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpSession;
public class LoginServlet extends HttpServlet {

   

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/login2.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
       
       String username = request.getParameter("username");
        String senha = request.getParameter("password");
        
        
       
        
        try {
            Employee emp = new Employee();
             emp = EmployeeDAO.getFuncionario(username);
           
            System.out.println(emp.toString());
            if(!emp.verifyStatus(emp.getEmployeeStatus())){
                System.out.println(emp.verifyStatus(emp.getEmployeeStatus()));
                request.setAttribute("UserErro", "Seu usuário foi desativado, entre em contato com um administrador!!");
                request.getRequestDispatcher("/login2.jsp").forward(request, response);
            }

           else if(emp!= null && emp.validarSenha(senha)){
                HttpSession sessao = request.getSession();
                sessao.setAttribute("emp", emp);
                response.sendRedirect(request.getContextPath() + "/ProductList_Servlet");
            }
            
            else{
            request.setAttribute("msgErro", "Usuário ou senha Inválidos");
           request.getRequestDispatcher("/login2.jsp").forward(request, response);
            }
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(LoginServlet.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
    }

   
}
