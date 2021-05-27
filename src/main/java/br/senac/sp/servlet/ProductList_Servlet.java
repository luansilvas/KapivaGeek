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
import javax.servlet.http.HttpSession;

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
        atualizaStatusProduto(lista);
        request.setAttribute("productList", lista);
        request.setAttribute("ultimoId", lista.get(lista.size() - 1));
        request.setAttribute("primeiroId", lista.get(0));
        System.out.println(lista.get(0));
        

        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       
        
       ProductDAO productDAO = new ProductDAO();
        String pesquisa = request.getParameter("pesquisa");

    
        List<Product> lista = new ArrayList(); 
        lista = productDAO.findProduct(pesquisa);

        
        request.setAttribute("productList", lista);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/listarProdutos.jsp");
        dispatcher.forward(request, response);
    }

    public void atualizaStatusProduto(List<Product> prod){
        ProductDAO dao = new ProductDAO();
        for(Product p: prod){
            if(p.getQuantity()< 10)
                dao.StatusUpdate(p.getProductId(), "Inativo");
            else
                dao.StatusUpdate(p.getProductId(), "Ativo");
                
        }
    }
    
}
