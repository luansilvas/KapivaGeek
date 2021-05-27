/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.productManagement;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author adm
 */
public class AtualizarQuantidadeProduto_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int idProduto = Integer.parseInt(request.getParameter("id"));

        Product prod = ProductDAO.findProductById(idProduto);
        System.out.println(prod.toString());
        request.setAttribute("prod", prod);
        request.getRequestDispatcher("/WEB-INF/AdicionarQuantidade.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int novaQuantidade = Integer.parseInt(request.getParameter("quantidade"));
        int idProduto = Integer.parseInt(request.getParameter("idProd"));
        System.out.println(idProduto);

        if (novaQuantidade <= 0) {
                  ProductDAO productDAO = new ProductDAO();
        List<Product> lista = new ArrayList();
        lista = productDAO.findProduct();
        request.setAttribute("productList", lista);
        request.setAttribute("ultimoId", lista.get(lista.size() - 1));
        request.setAttribute("primeiroId", lista.get(0));
        System.out.println("QUANTIDADE INVÁLIDA!");
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
        }else{

        if (ProductDAO.updateQtd(idProduto, novaQuantidade)) {
        ProductDAO productDAO = new ProductDAO();
        List<Product> lista = new ArrayList();
        lista = productDAO.findProduct();
        request.setAttribute("productList", lista);
        request.setAttribute("ultimoId", lista.get(lista.size() - 1));
        request.setAttribute("primeiroId", lista.get(0));
        System.out.println(lista.get(0));
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
        } else {
            System.out.println("deu ruim");
        }
        }
    }

}
