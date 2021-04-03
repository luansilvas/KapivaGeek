/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.dao;

import bd.ConexaoDB;
import br.senac.sp.model.Employee;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author luans
 */
public class EmployeeDAO {
   /* public static boolean addFuncionario(Employee emp) {

        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into Funcionario(nome,cpf,email,celular,ativo,Unidade_codUnidade) values(?,?,?,?,1,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, func.getNome());
            instrucaoSQL.setString(2, func.getCpf());
            instrucaoSQL.setString(3, func.getEmail());
            instrucaoSQL.setString(4, func.getCelular());
            instrucaoSQL.setInt(5, func.getCodUnidade());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {

                    func.setCodFuncionario(generatedKeys.getInt(1));


                } else {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
                }
            } else {

            }

        } catch (SQLException | ClassNotFoundException ex) {
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
        UsuarioDAO.addFuncionario(func);
        return retorno;
    }*/

    public static boolean deleteFuncionario(int codFuncionario) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update Funcionario set ativo = 0 where codFuncionario=?");

            instrucaoSQL.setInt(1, codFuncionario);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;

    }

    public static Employee getFuncionario(String userName, String password) 
            throws ClassNotFoundException, SQLException {
        Employee emp = new Employee();
        String sql = "select * from employee where email_employee ='"+userName+"' and password_employee ='"+password+"'";
      
        try (Connection conn = ConexaoDB.abrirConexao();
                PreparedStatement stmt = conn.prepareStatement(sql); ResultSet rs = stmt.executeQuery()) {

            if (rs.next()) {
                emp.setEmployeeName(rs.getString("name_employee"));
                emp.setEmployeeRole(rs.getString("role_employee"));
                emp.setEmployeeEmail(rs.getString("email_employee"));
                emp.setEmployeePassword(rs.getString("password_employee"));
                emp.setEmployeeStatus(rs.getString("status_employee"));
                 return emp;
            }

        }
        
        return null;
    }

   /* public static List<Usuario> getFuncionarios(int codFuncionario) {

        List<Usuario> listaFuncionarios = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from usuario inner join Funcionario on Funcionario_codFuncionario = codFuncionario where ativo=1 and codFuncionario<>?");
            instrucaoSQL.setInt(1, codFuncionario);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                int codUsuario = rs.getInt("codUsuario");
                String cargo = rs.getString("cargo");
                String log = rs.getString("login");
                String pass = rs.getString("senha");
                int codFunc = rs.getInt("Funcionario_codFuncionario");
                int idFuncionario = rs.getInt("codFuncionario");
                String nome = rs.getString("nome");
                String cpf = rs.getString("cpf");
                String email = rs.getString("email");
                String celular = rs.getString("celular");
                int codUnidade = rs.getInt("Unidade_codUnidade");

                Usuario func = new Usuario(codUsuario, log, cargo, pass, codFunc, idFuncionario, nome, cpf, email, celular, codUnidade);

                listaFuncionarios.add(func);
            }
        } catch (ClassNotFoundException | SQLException ex) {
            Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }

        return listaFuncionarios;
    }

    public static boolean updateFuncionario(Usuario func) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update Funcionario set nome=?,cpf=?,email=?,celular=?,Unidade_codUnidade=? where codFuncionario=?");

            instrucaoSQL.setString(1, func.getNome());
            instrucaoSQL.setString(2, func.getCpf());
            instrucaoSQL.setString(3, func.getEmail());
            instrucaoSQL.setString(4, func.getCelular());
            instrucaoSQL.setInt(5, func.getCodUnidade());
            instrucaoSQL.setInt(6, func.getCodFuncionario());
            instrucaoSQL.execute();

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }
                retorno = true;
                conexao.close();

            } catch (SQLException ex) {
            }
        }

        UsuarioDAO.updateFuncionario(func);
        return retorno;

}*/
}
