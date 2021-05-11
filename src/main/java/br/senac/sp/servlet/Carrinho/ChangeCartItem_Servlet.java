/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Carrinho;

import br.senac.sp.model.Product;
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
public class ChangeCartItem_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            HttpSession sessao = request.getSession();
            List<Product> carrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
            double valorTotal = (Double) sessao.getAttribute("valorTotal");
            int prodId = Integer.parseInt(request.getParameter("prodId"));
            Product produtoSelecionado = new Product();
            if (request.getParameter("acao").equals("adicionar")) {
                for (Product p : carrinho) {
                    if (p.getProductId() == prodId) {
                        p.setQuantity(p.getQuantity() + 1);
                        valorTotal = valorTotal + p.getPrice();
                    }
                }

            } else if (request.getParameter("acao").equals("diminuir")) {
                for (Product p : carrinho) {
                    if (p.getProductId() == prodId) {

                        p.setQuantity(p.getQuantity() - 1);
                        valorTotal = valorTotal - p.getPrice();
                        produtoSelecionado = p;
                    }
                }
                if (produtoSelecionado.getQuantity() <= 0) {
                    carrinho.remove(produtoSelecionado);
                }

            } else if (request.getParameter("acao").equals("deletar")) {
                for (Product p : carrinho) {
                    if (p.getProductId() == prodId) {
                        for (int i = 0; i < p.getQuantity(); i++) {
                            valorTotal = valorTotal - p.getPrice();
                        }
                        produtoSelecionado = p;
                    }
                }
                carrinho.remove(produtoSelecionado);
            }
            if (carrinho.size() == 0) {
                sessao.setAttribute("listaCarrinho", null);
            } else {
                sessao.removeAttribute("listaCarrinho");
                sessao.setAttribute("listaCarrinho", carrinho);
            }

            valorTotal = Math.round(valorTotal);

            sessao.removeAttribute("valorTotal");
            sessao.setAttribute("valorTotal", valorTotal);
            request.getRequestDispatcher("/WEB-INF/revisarPedido.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e);
            request.getRequestDispatcher("/WEB-INF/UserLogin.jsp").forward(request, response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}