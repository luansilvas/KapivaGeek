/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import br.senac.sp.servlet.Carrinho.Carrinho;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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
public class getProduct_Servlet extends HttpServlet {

   @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        HttpSession sessao = request.getSession();

       

            if (sessao.getAttribute("listaCarrinho") == null) {
                sessao.setAttribute("listaCarrinho", new ArrayList<Product>());
            }

            List<Product> listCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
            int qtdeCarrinho = 0;
            if (sessao.getAttribute("qtdeItensCarrinho") == null) {
                sessao.setAttribute("qtdeItensCarrinho", 1);
            } else {
                qtdeCarrinho = (int) sessao.getAttribute("qtdeItensCarrinho");
            }

            int produto = Integer.parseInt(request.getParameter("productId"));

            //INICIALIZA A QUANTIDADE DO PRODUTO =1
            Product p = iniciarQtd(ProductDAO.findProductById(produto));
            if (!find(listCarrinho, p.getProductId()) || listCarrinho.isEmpty()) {
                qtdeCarrinho+=1;
                listCarrinho.add(p);
            }else{
                qtdeCarrinho += 1;
            }

            sessao.removeAttribute("qtdeItensCarrinho");
            sessao.setAttribute("qtdeItensCarrinho", qtdeCarrinho);
            response.sendRedirect(request.getContextPath() + "/carrinho?acao=abrirCarrinho");

       

    }

    public static Product iniciarQtd(Product p) {
        p.setQuantity(1);
        return p;
    }

    public static boolean find(List<Product> li, int id) {
        for (Product p : li) {
            if (p.getProductId() == id) {
                Carrinho.addQuantidade(li, id, p.getQuantity());
                System.out.println("TEM NA LISTA HEIN");
                return true;
            }
        }

        return false;
    }

}
