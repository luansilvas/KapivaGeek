/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet.Orders;

import br.senac.sp.dao.AddressDAO;
import br.senac.sp.dao.OrderDAO;
import br.senac.sp.dao.PaymentDAO;
import br.senac.sp.model.Address;
import br.senac.sp.model.Order;
import br.senac.sp.model.Payment;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raque
 */
public class VerDetalhes_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
            String idURL = request.getParameter("orderId");

            System.out.println(idURL);
            List<Order> orders = OrderDAO.getOrderById(idURL);
            Order order = orders.get(0);

            Address address = AddressDAO.getAddressWithList(order.getAddress_address_id());

            Payment payment = PaymentDAO.getPaymentWithList(order.getPayment_payment_id());

            List<Product> ord = OrderDAO.getProdPedido(idURL);

            System.out.println(ord.toString());

            double valorTotal = 0.0, vlrFrete = 0.0;

            for (Product p : ord) {
                valorTotal = valorTotal + (p.getPrice() * p.getQuantity());
            }
            vlrFrete = order.getPurchaseorder_amount() - valorTotal;

            request.setAttribute("valorFrete", vlrFrete);
            request.setAttribute("valorTotal", valorTotal);
            request.setAttribute("detalhesPedido", ord);
            request.setAttribute("endEntrega", address);
            request.setAttribute("pagamento", payment);

            request.getRequestDispatcher("/WEB-INF/DetalhesProduto.jsp").forward(request, response);
        } catch (Exception e) {
            System.out.println(e.getCause());
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
    }

}
