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
import utils.EmployeeDataValidation;

/**
 *
 * @author luans
 */
public class AlterEmployeePassword_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
               int id = Integer.parseInt(request.getParameter("id"));
        String password = request.getParameter("pass");
        String confPassword = request.getParameter("passConf");

        EmployeeDataValidation EmployeeData = new EmployeeDataValidation();
        List<String> errorList = EmployeeData.validatePassword(password,confPassword);
        Employee emp = new Employee(id, "", "", "",password , "");

        if (errorList.size() == 0) {
            EmployeeDAO.updateEmployeePassword(emp);
            
            request.setAttribute("hasError", "false");
            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(id);
            Employee employee = employeeList.get(0);
            request.setAttribute("employee", employee);
            errorList.add("A senha foi alterado com sucesso");
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
