/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.filter;

import br.senac.sp.model.Employee;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.io.StringWriter;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Gabriel
 */
public class AutorizacaoFilter implements Filter {

    @Override
    public void doFilter(ServletRequest request, ServletResponse response,
            FilterChain chain) throws IOException, ServletException {
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;

        HttpSession sessao = httpRequest.getSession();
        if (sessao.getAttribute("emp") == null) {
            // Usuario não logado -> redirecionar para tela de login
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/login");
            return;
        }
        Employee usuario = (Employee) sessao.getAttribute("emp");
        
        if(verificarAcesso(usuario, httpRequest)){
            chain.doFilter(request, response);
        }
        else{
            httpResponse.sendRedirect(httpRequest.getContextPath() + "/erro.jsp");
        }
    }

    @Override
    public void destroy() {

    }

    @Override
    public void init(FilterConfig filterconfig) {

    }

    private boolean verificarAcesso(Employee emp, HttpServletRequest httprequest) {
        String pagenaAcessada = httprequest.getRequestURI();
        String role = "Administrador";
       
        if(pagenaAcessada.endsWith("/ProductList_Servlet")){
        return true;
        }
       else if(pagenaAcessada.endsWith("/Product_Servlet") 
               && emp.getEmployeeRole().equals(role)) {
 
            System.out.println(emp.getEmployeeRole() );
                   return true;
        }
 
        return false;
                
    }
    

}
