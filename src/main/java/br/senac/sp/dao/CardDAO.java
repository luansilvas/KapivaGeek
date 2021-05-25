/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import bd.ConexaoDB;
import br.senac.sp.model.Card;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 *
 * @author luans
 */
public class CardDAO {
    public static int addCard(Card c){
      
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into card(card_number,card_cvv,card_exp,card_printed_name,customer_customer_id) values(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, c.getCard_number());
            instrucaoSQL.setString(2, c.getCvv());
            instrucaoSQL.setString(3, c.getExp());
            instrucaoSQL.setString(4, c.getPrintedName());
            instrucaoSQL.setInt(5, c.getCustomerId());

            



            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    c.setCard_id(generatedKeys.getInt(1));
                } else {
                    throw new SQLException("Falha ao obter o código do Cartão.");
                }
            } else {

            }

        } catch (ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
        }catch(SQLException ex){
            System.out.println(ex.getMessage());
        }
        
        finally {
            try {
                if (instrucaoSQL != null) {
                    ConexaoDB.fecharConexao();
                }
            } catch (SQLException ex) {
                System.out.println("Houve erro ao encerrar sua conexão. Tente novamente.");
            }
        }
        return c.getCard_id();
    }
}
