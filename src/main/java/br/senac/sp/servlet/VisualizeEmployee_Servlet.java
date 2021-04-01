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
public class VisualizeEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       int EmployeeId = Integer.parseInt(request.getParameter("employeeId"));

            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(EmployeeId);
            Employee emp = employeeList.get(0);
            request.setAttribute("employee", emp);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/VisualizarFuncionario.jsp");
            requestDispatcher.forward(request, response);
    }



}
