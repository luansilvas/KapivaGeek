/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import br.senac.sp.dao.*;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Gabriel
 */
@WebServlet(name = "Product_Salvar", urlPatterns = {"/Product-Salvar"})
public class Product_Servlet_Save extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession section = request.getSession();
        Product newProduct = (Product) section.getAttribute("newProduct");
        section.removeAttribute("newProduct");

        request.setAttribute("newProduct", newProduct);
        RequestDispatcher dispacher = request.getRequestDispatcher("/cadastrarImagem.jsp");

        dispacher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String productNameStr = request.getParameter("product-name");
        String longNameStr = request.getParameter("long-name");
        String starsStr = request.getParameter("stars");
        String stockStr = request.getParameter("stock");
        String priceStr = request.getParameter("price");
        String statusStr = request.getParameter("status");

        boolean validProductName = (productNameStr.trim().length() > 3 && productNameStr != null);//Validação Nome do produto

        boolean validFields = validProductName;

        if (!validFields) {

            if (!validProductName) {
                request.setAttribute("ProductNameError", "O campo nome do produto deve ter mais de 3 caracters");
            }

            request.setAttribute("product-name", productNameStr);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/Regs_Form_Products.jsp");
            dispatcher.forward(request, response);
            return;
        }

        ProductDAO dao = new ProductDAO();
        Product newProduct = new Product();
        int productId = 0;
        try {
            newProduct.setProductName(productNameStr);
            newProduct.setProductFullName(longNameStr);
            newProduct.setStars(Integer.parseInt(starsStr));
            newProduct.setQuantity(Integer.parseInt(stockStr));
            newProduct.setPrice(Double.parseDouble(priceStr));
            newProduct.setStatus(statusStr);
            productId = dao.addNewProduct(newProduct);
            System.out.println(productId);
        } catch (SQLException ex) {
            System.out.println(ex);
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        }
        response.sendRedirect("UploadImageServlet?codProduto="+productId);

                //

                //request.setAttribute("add", "Produto Registrado");
                //HttpSession sessao = request.getSession();
                // sessao.setAttribute("newProduct", newProduct);

                //response.sendRedirect("Product-Salvar");
    }

}
