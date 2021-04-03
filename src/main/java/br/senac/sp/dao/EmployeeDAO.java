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

/**
 *
 * @author luans
 */
public class EmployeeDAO {

    public static boolean addEmployee(Employee emp) throws SQLException, ClassNotFoundException {

        boolean retorno = false;
        Connection conexao;
        PreparedStatement instrucaoSQL = null;
        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("insert into employee(name_employee,role_employee,email_employee,password_employee,status_employee) values(?,?,?,?,?);", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setString(1, emp.getEmployeeName());
            instrucaoSQL.setString(2, emp.getEmployeeRole());
            instrucaoSQL.setString(3, emp.getEmployeeEmail());
            instrucaoSQL.setString(4, emp.codificarSenha(emp.getEmployeePassword()));
            instrucaoSQL.setString(5, emp.getEmployeeStatus());

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (generatedKeys.next()) {
                    emp.setEmployeeId(generatedKeys.getInt(1));

                } else {
                    throw new SQLException("Falha ao obter o código do Funcionário.");
                }
            } else {

            }

        } catch (SQLException | ClassNotFoundException ex) {
            throw ex;
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

    public static boolean inativateEmployee(int idEmployee) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update employee set status_employee = 'inative' where codFuncionario=?");

            instrucaoSQL.setInt(1, idEmployee);
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

    public static Employee getEmployee(int codFuncionario) {
        Employee emp = null;
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from employee where employee_id=?");
            instrucaoSQL.setInt(1, codFuncionario);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {

                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("name_employee");
                String employeeRole = rs.getString("role_employee");
                String employeeEmail = rs.getString("email_employee");
                String employeePassword = "";
                String employeeStatus = rs.getString("status_employee");

                emp = new Employee(employeeId, employeeName, employeeRole, employeeEmail, employeePassword, employeeStatus);
            }
        } catch (ClassNotFoundException | SQLException ex) {

        }

        return emp;
    }

    public static List<Employee> getEmployeeWithList(int codFuncionario) {

        List<Employee> EmployeeList = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from employee where employee_id=?");
            instrucaoSQL.setInt(1, codFuncionario);
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("name_employee");
                String employeeRole = rs.getString("role_employee");
                String employeeEmail = rs.getString("email_employee");
                String employeePassword = "";
                String employeeStatus = rs.getString("status_employee");

                Employee emp = new Employee(employeeId, employeeName, employeeRole, employeeEmail, employeePassword, employeeStatus);

                EmployeeList.add(emp);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }

        return EmployeeList;
    }
    
    public static List<Employee> getEmployees() {

        List<Employee> EmployeeList = new ArrayList();
        ResultSet rs = null;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();
            instrucaoSQL = conexao.prepareStatement("select * from employee");
            rs = instrucaoSQL.executeQuery();

            while (rs.next()) {
                int employeeId = rs.getInt("employee_id");
                String employeeName = rs.getString("name_employee");
                String employeeRole = rs.getString("role_employee");
                String employeeEmail = rs.getString("email_employee");
                String employeePassword = "";
                String employeeStatus = rs.getString("status_employee");

                Employee emp = new Employee(employeeId, employeeName, employeeRole, employeeEmail, employeePassword, employeeStatus);

                EmployeeList.add(emp);
            }
        } catch (ClassNotFoundException | SQLException ex) {
        }

        return EmployeeList;
    }

    public static boolean updateEmployee(Employee emp) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update employee set name_employee=?,role_employee=?,status_employee=? where employee_id=?");

            instrucaoSQL.setString(1, emp.getEmployeeName());
            instrucaoSQL.setString(2, emp.getEmployeeRole());
            instrucaoSQL.setString(3, emp.getEmployeeStatus());
            instrucaoSQL.setInt(4, emp.getEmployeeId());
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

            return retorno;

        }
    }

    public static boolean updateEmployeePassword(Employee emp) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update employee set password_employee = ? where employee_id=?");

            instrucaoSQL.setString(1, emp.codificarSenha(emp.getEmployeePassword()));
            instrucaoSQL.setInt(2, emp.getEmployeeId());
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

            return retorno;

        }
    }

    public static boolean ActivateEmployee(Employee emp) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update employee set status_employee='Ativo' where employee_id=?");

            instrucaoSQL.setInt(1, emp.getEmployeeId());
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

            return retorno;

        }
    }

    public static boolean InactivateEmployee(Employee emp) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update employee set status_employee='Inativo' where employee_id=?");

            instrucaoSQL.setInt(1, emp.getEmployeeId());
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

            return retorno;

        }
    }

}
