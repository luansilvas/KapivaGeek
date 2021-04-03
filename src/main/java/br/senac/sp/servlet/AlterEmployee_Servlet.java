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
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import utils.EmployeeDataValidation;

/**
 *
 * @author luans
 */
public class AlterEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int EmployeeId = Integer.parseInt(request.getParameter("employeeId"));

        List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(EmployeeId);
        Employee emp = employeeList.get(0);

        request.setAttribute("employee", emp);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String status = request.getParameter("status");

        EmployeeDataValidation EmployeeData = new EmployeeDataValidation();
        List<String> errorList = EmployeeData.validateChanges(name, role, status);
        Employee emp = new Employee(id, name, role, "", "", status);

        if (errorList.size() == 0) {
            EmployeeDAO.updateEmployee(emp);
            request.setAttribute("hasError", "false");
            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(id);
            Employee employee = employeeList.get(0);
            request.setAttribute("employee", employee);
            errorList.add("O usuário foi alterado com sucesso");
            request.setAttribute("errorList", errorList);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp");
            requestDispatcher.forward(request, response);

        }
        if (errorList.size() > 0) {
            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(id);
            Employee employee = employeeList.get(0);
            request.setAttribute("employee", employee);
            request.setAttribute("errorList", errorList);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
