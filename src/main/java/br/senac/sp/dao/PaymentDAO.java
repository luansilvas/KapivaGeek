/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import bd.ConexaoDB;
import br.senac.sp.model.Address;
import br.senac.sp.model.Employee;
import br.senac.sp.model.Payment;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author luans
 */
public class PaymentDAO {

    public static int addPaymentWithoutCard(Payment p) {

        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into payment(payment_way,instalments,payment_status) values(?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, p.getPayment_way());
            instrucaoSQL.setInt(2, p.getPayment_instalments());
            instrucaoSQL.setString(3, p.getPayment_status());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    p.setPayment_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
                }
            } else {

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
        return p.getPayment_id();
    }

    public static int addPaymentWithCard(Payment p) {

        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into payment(payment_way,instalments,card_card_id,payment_status) values(?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, p.getPayment_way());
            instrucaoSQL.setInt(2, p.getPayment_instalments());
            instrucaoSQL.setInt(3, p.getCard_id());
            instrucaoSQL.setString(4, p.getPayment_status());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    p.setPayment_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
                }
            } else {

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
        return p.getPayment_id();
    }

    public static Payment getPaymentByList(int paymentId) {
        Payment payment = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from payment where payment_id=?;");
            instrucaoSQL.setInt(1, paymentId);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                int id = rs.getInt("payment_id");
                String payment_way = rs.getString("payment_way");
                int cardId = rs.getInt("card_card_id");
                int instalments = rs.getInt("instalments");
                String payment_status = rs.getString("payment_status");

                payment = new Payment(id, payment_way, instalments, payment_status, cardId);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println("Não conseguimos encontrar um cliente com o ID passado.");
        }

        return payment;
    }
        public static Payment getPaymentWithList(int paymentId) {

        List<Payment> paymentList = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from payment where payment_id=? ");
            instrucaoSQL.setInt(1, paymentId);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

               int id = rs.getInt("payment_id");
                String payment_way = rs.getString("payment_way");
                int cardId = rs.getInt("card_card_id");
                int instalments = rs.getInt("instalments");
                String payment_status = rs.getString("payment_status");
                Payment  payment= new Payment(id, payment_way, instalments, payment_status, cardId);
                System.out.println("ESSE DAQUI É O PAGAMENTO QUE PEGUEI" + payment);
                paymentList.add(payment);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
        }
        
        return paymentList.get(0);
    }
}
