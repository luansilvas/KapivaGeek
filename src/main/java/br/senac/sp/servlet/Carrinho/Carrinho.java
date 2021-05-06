/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Carrinho;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.model.*;
import br.senac.sp.dao.*;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adm
 */
public class Carrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        if (sessao.getAttribute("listaCarrinho") != null) {
            double valorTotal = 0;

            List<Product> listaCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
            valorTotal = valorTotal(listaCarrinho);

            request.setAttribute("valorTotal", valorTotal);
        }
        
        
        
        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);

    }

    public double valorTotal(List<Product> li) {
        double valorTotal = 0;
        for (Product p : li) {
            valorTotal += p.getPrice();
        }

        return valorTotal;
    }

}
