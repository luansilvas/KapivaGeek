/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import br.senac.sp.dao.*;
import br.senac.sp.model.*;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;

/**
 *
 * @author Gabriel
 */
public class Pagination_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int prodId = Integer.parseInt(request.getParameter("id"));
        ProductDAO dao = new ProductDAO();
        ArrayList<Product> pagList = new ArrayList();
        pagList = dao.findProductPaginationProx(prodId);
        request.setAttribute("productList", pagList);
        request.setAttribute("ultimoId", pagList.get(pagList.size() - 1));

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        //int primeiroId = Integer.parseInt(request.getParameter("firstId"));
    }

}
