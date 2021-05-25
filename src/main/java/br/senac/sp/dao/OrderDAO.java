/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import bd.ConexaoDB;
import br.senac.sp.model.Employee;
import br.senac.sp.model.Order;
import br.senac.sp.model.Payment;
import br.senac.sp.model.Product;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author luans
 */
public class OrderDAO {

    public static boolean addOrder(Order o) {

        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into purchaseorder(purchaseorder_id,purchaseorder_amount,customer_customer_id,payment_payment_id,purchaseorder_status,address_address_id,diaPedido) values(?,?,?,?,?,?,now());", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, o.getPurchaseorder_id());
            instrucaoSQL.setDouble(2, o.getPurchaseorder_amount());
            instrucaoSQL.setInt(3, o.getCustomer_customer_id());
            instrucaoSQL.setInt(4, o.getPayment_payment_id());
            instrucaoSQL.setString(5, o.getPurchaseorder_status());
            instrucaoSQL.setInt(6, o.getAddress_address_id());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (!generatedKeys.next()) {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
                }
            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
        } finally {
            try {
                if (instrucaoSQL != null) {
                    ConexaoDB.fecharConexao();
                }
            } catch (SQLException ex) {
                System.out.println("Houve erro ao encerrar sua conexão. Tente novamente.");
            }
        }
        return retorno;
    }

    public static List<Order> getOrders(int customerId) {
        String sql = "select * from purchaseorder where customer_customer_id=" + customerId + " order by diaPedido desc;";
        System.out.println(sql);
        ArrayList<Order> prodBd = new ArrayList<>();

        try (Connection conn = ConexaoDB.abrirConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {// enquanto tiver empresas adiciona no array

                Order pedido = new Order();
                pedido.setPurchaseorder_id(rs.getString("purchaseorder_id"));
                pedido.setPurchaseorder_amount(rs.getDouble("purchaseorder_amount"));
                pedido.setCustomer_customer_id(rs.getInt("customer_customer_id"));
                pedido.setPayment_payment_id(rs.getInt("payment_payment_id"));
                pedido.setPurchaseorder_status(rs.getString("purchaseorder_status"));
                pedido.setAddress_address_id(rs.getInt("address_address_id"));
                pedido.setPurchaseorder_status(rs.getString("purchaseorder_status"));
                pedido.setDiaPedido(rs.getString("diaPedido"));
                System.out.println("ESSE É O ID DO PEDIDO " + pedido.getPurchaseorder_id());
                prodBd.add(pedido);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return prodBd;
    }

    public static List<Product> getProdPedido(String id) {
        String sql = "select p.name_prod,p.price,ppo.quantity,pi.path_img from product_purchaseorder as ppo INNER JOIN purchaseorder as po on po.purchaseorder_id = ppo.purchaseorder_purchaseorder_id INNER JOIN products as p on ppo.product_product_id = p.prod_id INNER JOIN product_img as pi on p.prod_id = pi.prod_id where po.purchaseorder_id='" + id + "' and pi.Main_img = 'true'";

        System.out.println(sql);
        ArrayList<Product> prodBd = new ArrayList<>();

        try (Connection conn = ConexaoDB.abrirConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {// enquanto tiver empresas adiciona no array

                Product pedido = new Product();
                pedido.setProductName(rs.getString("name_prod"));
                pedido.setPrice(rs.getDouble("price"));
                pedido.setQuantity(rs.getInt("quantity"));
                pedido.setPath_MainImg(rs.getString("path_img"));
                System.out.println("ESSA É A FOTO + "+pedido.getPath_MainImg());
                prodBd.add(pedido);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return prodBd;
    }

    public static List<Order> getOrders() {
        String sql = "select purchaseorder_id, diaPedido,purchaseorder_amount,purchaseorder_status  from purchaseorder ORDER BY diaPedido";
        List<Order> orders = new LinkedList<>();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        
        try (Connection conn = ConexaoDB.abrirConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
               
                Date data = rs.getDate("diaPedido");
                String dataFormat = dataFormatada.format(data);
            
                Order order = new Order();
                order.setPurchaseorder_id(rs.getString("purchaseorder_id"));
                order.setDiaPedido(dataFormat);
                order.setPurchaseorder_amount(rs.getDouble("purchaseorder_amount"));
                order.setPurchaseorder_status(rs.getString("purchaseorder_status"));
                orders.add(order);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return orders;
    }

    public static boolean updateStatus(String status, String id) {
        String sql = "UPDATE purchaseorder SET purchaseorder_status = ? WHERE purchaseorder_id = ? ";
       

        try (Connection conn = ConexaoDB.abrirConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, status);
            stmt.setString(2, id);
            stmt.execute();
            return true;
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }
        
        return false;
    }
    
    
    
    
    
     public static List<Order> getOrderById( String id) {
        String sql = "select purchaseorder_id, diaPedido,purchaseorder_amount,payment_payment_id,address_address_id,purchaseorder_status  from purchaseorder  WHERE purchaseorder_id = '"+id+"' ORDER BY diaPedido";
        List<Order> orders = new LinkedList<>();
        SimpleDateFormat dataFormatada = new SimpleDateFormat("dd/MM/yyyy");
        
        try (Connection conn = ConexaoDB.abrirConexao(); // abre e fecha a conexão
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
               
                Date data = rs.getDate("diaPedido");
                String dataFormat = dataFormatada.format(data);
            
                Order order = new Order();
                order.setPurchaseorder_id(rs.getString("purchaseorder_id"));
                order.setDiaPedido(dataFormat);
                order.setPayment_payment_id(rs.getInt("payment_payment_id"));
                order.setAddress_address_id(rs.getInt("address_address_id"));
                order.setPurchaseorder_amount(rs.getDouble("purchaseorder_amount"));
                order.setPurchaseorder_status(rs.getString("purchaseorder_status"));
                orders.add(order);
            }
        } catch (ClassNotFoundException ex) {
            System.out.println(ex);
        } catch (SQLException ex) {
            System.out.println(ex);
        }

        return orders;
    }
}
