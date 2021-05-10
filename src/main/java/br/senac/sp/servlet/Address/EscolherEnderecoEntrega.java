/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Address;

import br.senac.sp.model.Address;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luans
 */
public class EscolherEnderecoEntrega extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
                request.getRequestDispatcher("/WEB-INF/escolherEnderecoEntrega.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (request.getParameter("end")!=null) {
            int idEndereco = Integer.parseInt(request.getParameter("end"));
            
            HttpSession sessao = request.getSession();
            List<Address> addresses = (List<Address>)sessao.getAttribute("addr");
            Address enderecoEscolhido = null;
            
            for (Address a : addresses) {
                if (a.getAddress_id()==idEndereco) {
                    enderecoEscolhido = a;
                }
            }
            sessao.setAttribute("deliveryAddress", enderecoEscolhido);
            request.getRequestDispatcher("/WEB-INF/DoubleCheckPedido.jsp").forward(request, response);
                
        }
        

    }


}
