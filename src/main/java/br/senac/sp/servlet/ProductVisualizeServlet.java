/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ImageDAO;
import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Image;
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
 * @author luans
 */
public class ProductVisualizeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));

        ProductDAO productDAO = new ProductDAO();

        Product product = new Product();
        try {
            product = productDAO.findProductById(productId);
        } catch (SQLException ex) {
            Logger.getLogger(ProductVisualizeServlet.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ProductVisualizeServlet.class.getName()).log(Level.SEVERE, null, ex);
        }

        List<Image> imageList = new ArrayList();
        imageList = ImageDAO.getImages(productId);

        Image mainPic = imageList.get(0);

        List<String> stars = new ArrayList();

        for (int i = 0; i < product.getStars(); i++) {
            stars.add("estrela 1");
            System.out.println("estrela" + i);
        }
        request.setAttribute("mainImage", mainPic);
        request.setAttribute("product", product);
        request.setAttribute("Stars", stars);

        request.setAttribute("imageList", imageList);
        request.setAttribute("productId", productId);

        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/visualizarProduto.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
