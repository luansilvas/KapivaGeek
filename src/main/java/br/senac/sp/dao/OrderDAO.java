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
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luans
 */
public class OrderDAO {

    public static boolean addOrder(Order o){

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
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }finally {
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
}
