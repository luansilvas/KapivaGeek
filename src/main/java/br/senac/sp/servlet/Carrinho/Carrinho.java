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
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 *
 * @author adm
 */
public class Carrinho extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        System.out.println("AGORA POR AQUI HEIN");
        HttpSession sessao = request.getSession();
        List<Product> listaCarrinho = (List<Product>) sessao.getAttribute("listaCarrinho");
        int qtdeCarrinho = (int)sessao.getAttribute("qtdeItensCarrinho");
        
        double valorTotal = 0;
        String acao = request.getParameter("acao");

        if (acao.equals("abrirCarrinho")) {
            if (sessao.getAttribute("listaCarrinho") != null) {

                valorTotal = valorTotal(listaCarrinho);
                sessao.setAttribute("valorTotal", valorTotal);
            }
        } 
        
        else if (acao.equals("adicionar")) {

            if (sessao.getAttribute("listaCarrinho") == null) {
                request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);
            }

            int id = Integer.parseInt(request.getParameter("productId"));
            Product p = findProduct(id, listaCarrinho);
            int qtd = p.getQuantity();
            
            qtdeCarrinho+=1;

            listaCarrinho = addQuantidade(listaCarrinho, id, qtd);
            valorTotal = valorTotal(listaCarrinho);
            sessao.removeAttribute("qtdeItensCarrinho");
            sessao.setAttribute("qtdeItensCarrinho",qtdeCarrinho);
          
            sessao.setAttribute("valorTotal", valorTotal);

        } else if (acao.equals("excluir")) {
            int prodId = Integer.parseInt(request.getParameter("productId"));
               
            qtdeCarrinho-=contarQtdeProduto(listaCarrinho,prodId);
            if (qtdeCarrinho<0) qtdeCarrinho=0;  
            listaCarrinho.remove(findProduct(prodId, listaCarrinho));
            
            sessao.removeAttribute("qtdeItensCarrinho");
            sessao.setAttribute("qtdeItensCarrinho",qtdeCarrinho);
            valorTotal = valorTotal(listaCarrinho);
            sessao.setAttribute("valorTotal", valorTotal);

        } else if (acao.equals("subtrair")) {

            if (sessao.getAttribute("listaCarrinho") == null) {
                request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);
            }

            int id = Integer.parseInt(request.getParameter("productId"));
            Product p = findProduct(id, listaCarrinho);
            int qtd = p.getQuantity();
            if (qtdeCarrinho<0) qtdeCarrinho=0;  
            if (qtd > 1) {
                qtdeCarrinho-=1;
                listaCarrinho = subQuantidade(listaCarrinho, id, qtd);
            }

            sessao.removeAttribute("qtdeItensCarrinho");
            sessao.setAttribute("qtdeItensCarrinho",qtdeCarrinho);
            valorTotal = valorTotal(listaCarrinho);
            sessao.setAttribute("valorTotal", valorTotal);
        }

        request.getRequestDispatcher("/WEB-INF/Carrinho.jsp").forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        String ruaStr = request.getParameter("rua");
        String bairooStr = request.getParameter("bairro");
        String cidadeStr = request.getParameter("cidade");
        String ufStr = request.getParameter("uf");
        
        Address addr = new Address();
        addr.setAddress_street(ruaStr);
        addr.setAddress_state_abbreviation(ufStr);
        addr.setAddress_neighborhood(bairooStr);
        addr.setAddress_complement(cidadeStr);
        
        request.setAttribute("addre", addr);
        request.setAttribute("valorCarrinho", geraValorCEP());
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
                p.setTotalPrice(p.getPrice()*(quantidade+1));
            }
        }
        return li;

    }

    public static List<Product> subQuantidade(List<Product> li, int id, int quantidade) {
        for (Product p : li) {
            if (p.getProductId() == id) {
                p.setQuantity(quantidade - 1);
                p.setTotalPrice(p.getTotalPrice() - p.getPrice());
            }
        }
        return li;
    }
    
        public static int contarQtdeProduto(List<Product> li, int id) {
        int qtde =0;
        for (Product p : li) {
            if (p.getProductId() == id) {
                qtde = p.getQuantity();
            }
        }
            System.out.println("O PRODUTO EXCLUID TEM "+qtde+"UNIDADES");
        return qtde;
    }
    
    
    
    
    public static int geraValorCEP(){
      return  (int) (1 + Math.random() * 20);
    }
    
}
