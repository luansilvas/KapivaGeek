/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Carrinho;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
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
public class AdicionarDadosCarrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

        try {

            if (sessao.getAttribute("listaCarrinho") == null) {
                sessao.setAttribute("listaCarrinho", new ArrayList<Product>());
            }

            List<Product> listCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");

            int produto = Integer.parseInt(request.getParameter("productId"));
            Product p = ProductDAO.findProductById(produto);
            listCarrinho.add(p);
            System.out.println(p.toString());

            response.sendRedirect(request.getContextPath() + "/Home_Servlet");

        } catch (SQLException ex) {
            Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Carrinho.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

}
