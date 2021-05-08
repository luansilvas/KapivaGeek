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
        List<Product> listaCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
        double valorTotal = 0;
        String acao = request.getParameter("acao");

        if (acao.equals("abrirCarrinho")) {
            if (sessao.getAttribute("listaCarrinho") != null) {

                valorTotal = valorTotal(listaCarrinho);
                sessao.setAttribute("valorTotal", valorTotal);

            }

        } else if (acao.equals("adicionar")) {

            if (sessao.getAttribute("listaCarrinho") == null) {
                request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);
            }

            int id = Integer.parseInt(request.getParameter("productId"));
            Product p = findProduct(id, listaCarrinho);
            int qtd = p.getQuantity();

            listaCarrinho = addQuantidade(listaCarrinho, id, qtd);
            valorTotal = valorTotal(listaCarrinho);
            sessao.setAttribute("valorTotal", valorTotal);

        } else if (acao.equals("excluir")) {
            int prodId = Integer.parseInt(request.getParameter("productId"));

            listaCarrinho.remove(findProduct(prodId, listaCarrinho));
            valorTotal = valorTotal(listaCarrinho);
            sessao.setAttribute("valorTotal", valorTotal);

        } else if (acao.equals("subtrair")) {

            if (sessao.getAttribute("listaCarrinho") == null) {
                request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);
            }

            int id = Integer.parseInt(request.getParameter("productId"));
            Product p = findProduct(id, listaCarrinho);
            int qtd = p.getQuantity();

            if (qtd > 1) {
                listaCarrinho = subQuantidade(listaCarrinho, id, qtd);
            }

            valorTotal = valorTotal(listaCarrinho);
            sessao.setAttribute("valorTotal", valorTotal);
        }

        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);

    }

    public double valorTotal(List<Product> li) {
        double valorTotal = 0;
        for (Product p : li) {
            valorTotal += (p.getPrice() * p.getQuantity());
        }

        return valorTotal;
    }

    public Product findProduct(int id, List<Product> li) {

        for (Product p : li) {
            if (p.getProductId() == id) {
                return p;
            }
        }
        return null;
    }

    public static List<Product> addQuantidade(List<Product> li, int id, int quantidade) {

        for (Product p : li) {
            if (p.getProductId() == id) {
                p.setQuantity(quantidade + 1);
            }
        }
        return li;

    }

    public static List<Product> subQuantidade(List<Product> li, int id, int quantidade) {
        for (Product p : li) {
            if (p.getProductId() == id) {
                p.setQuantity(quantidade - 1);
            }
        }
        return li;

    }
    
}
