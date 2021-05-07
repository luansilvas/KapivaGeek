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

    private int quantidade =1;

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    
    
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        HttpSession sessao = request.getSession();
        List<Product> listaCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
        
        
        
        String acao = request.getParameter("acao");
        System.out.println(acao);

        if (acao.equals("abrirCarrinho")) {
            if (sessao.getAttribute("listaCarrinho") != null) {
                double valorTotal = 0;
               
                request.setAttribute("quantidade", getQuantidade());
                valorTotal = valorTotal(listaCarrinho);
                request.setAttribute("valorTotal", valorTotal);
                
            }

        }
        
       else if(acao.equals("adicionar")){
           int id = Integer.parseInt(request.getParameter("productId"));
       
           int qtd = (getQuantidade()+1);
            setQuantidade(qtd);
             request.setAttribute("quantidade", getQuantidade());
        }
        
       else if(acao.equals("excluir")){
            int prodId = Integer.parseInt(request.getParameter("productId"));
           
            listaCarrinho.remove(findProduct(prodId, listaCarrinho));
          
            
        }

       request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);

    }

    public double valorTotal(List<Product> li) {
        double valorTotal = 0;
        for (Product p : li) {
            valorTotal += p.getPrice();
        }

        return valorTotal;
    }
    
    public Product findProduct(int id, List<Product> li){
      
        for(Product p: li){
            if(p.getProductId() == id)
                return p;
        }
        return null;
    }

}
