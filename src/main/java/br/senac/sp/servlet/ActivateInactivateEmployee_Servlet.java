/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.EmployeeDAO;
import br.senac.sp.model.Employee;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author luans
 */
public class ActivateInactivateEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        if (!request.getParameter("employeeId").equals(null) && request.getParameter("acao").equals("consulta")) {
            int EmployeeId = Integer.parseInt(request.getParameter("employeeId"));

            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(EmployeeId);
            Employee emp = employeeList.get(0);

            String acao = "";
            if (emp.getEmployeeStatus().equals("Ativo")) {
                acao = "Inativar";
            } else {
                acao = "Ativar";
            }
            request.setAttribute("employee", emp);
            request.setAttribute("acao", acao);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AtivarInativarFuncionario.jsp");
            requestDispatcher.forward(request, response);
        }else {
            int EmployeeId = Integer.parseInt(request.getParameter("employeeId"));
            String acao = request.getParameter("acao");
            Employee emp = new Employee(EmployeeId,"", "", "", "","");
            if (acao.equals("Ativar")) {
              EmployeeDAO.ActivateEmployee(emp);
            }else{
            EmployeeDAO.InactivateEmployee(emp);
            }
            
            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(EmployeeId);
            Employee empAtualizado = employeeList.get(0);

            String NovaAcao = "";
            if (empAtualizado.getEmployeeStatus().equals("Ativo")) {
                NovaAcao = "Inativar";
            } else {
                NovaAcao = "Ativar";
            }
            
            request.setAttribute("employee", empAtualizado);
            request.setAttribute("acao", NovaAcao);

            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AtivarInativarFuncionario.jsp");
            requestDispatcher.forward(request, response);
            
            
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

}
