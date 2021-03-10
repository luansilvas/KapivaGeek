
package br.senac.sp.servlet;

import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raque
 */
public class ProductList_Servlet extends HttpServlet {


    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ProductDAO productDAO = new ProductDAO();
        List<Product> lista = new ArrayList(); 
        lista = productDAO.findProduct();
        request.setAttribute("productList", lista);
        request.setAttribute("ultimoId", lista.get(lista.size()-1));
        
            RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String id = request.getParameter("lastId");
        System.out.println(id);
        
        response.sendRedirect("Pagination_Servlet?id="+id);
        
       /* ProductDAO productDAO = new ProductDAO();
        String pesquisa = request.getParameter("pesquisa");
    
        List<Product> lista = new ArrayList(); 
        lista = productDAO.findProduct(pesquisa);
        
        request.setAttribute("productList", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);*/
        
        
    }

  

}
