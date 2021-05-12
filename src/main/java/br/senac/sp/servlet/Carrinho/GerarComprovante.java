/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Carrinho;

import br.senac.sp.dao.CartDAO;
import br.senac.sp.dao.OrderDAO;
import br.senac.sp.dao.PaymentDAO;
import br.senac.sp.model.Address;
import br.senac.sp.model.Customer;
import br.senac.sp.model.Order;
import br.senac.sp.model.Payment;
import br.senac.sp.model.Product;
import br.senac.sp.model.ProductOrder;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author luans
 */
public class GerarComprovante extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        HttpSession sessao = request.getSession();
        UUID codPedido = UUID.randomUUID();
        sessao.setAttribute("codPedido", codPedido);
        
        
        
        Payment formaPagamento = (Payment) sessao.getAttribute("pagamento");
        int codPagamento = PaymentDAO.addPayment(formaPagamento);
        Customer usuario = (Customer) sessao.getAttribute("user");
        Address addr = (Address) sessao.getAttribute("deliveryAddress");
        List<Product> listaProdutos = (List<Product>) sessao.getAttribute("listaCarrinho");
        Order order = new Order(codPedido.toString(), (Double) sessao.getAttribute("valorTotal"), usuario.getCustomer_id(), codPagamento, "Aguardando pagamento", addr.getAddress_id());
        if (OrderDAO.addOrder(order)) {
            for (Product p : listaProdutos) {
                ProductOrder po = new ProductOrder(codPedido.toString(), p.getProductId(), p.getQuantity(), p.getPrice());
                CartDAO.addProductOrder(po);
            }

        }
        sessao.removeAttribute("listaCarrinho");
        sessao.setAttribute("qtdeItensCarrinho",0);
        request.getRequestDispatcher("/WEB-INF/CompraFinalizada.jsp").forward(request, response);
        }catch(Exception e){
        request.getRequestDispatcher("/WEB-INF/UserLogin.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/WEB-INF/CompraFinalizada.jsp").forward(request, response);
    }

    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
