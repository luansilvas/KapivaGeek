/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.EmployeeDAO;
import br.senac.sp.model.Employee;
import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
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
public class RegisterEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        RequestDispatcher dispacher = request.getRequestDispatcher("/WEB-INF/CadastrarFuncionario.jsp");

        dispacher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String name = request.getParameter("name");
        String role = request.getParameter("role");
        String email = request.getParameter("email");
        String status = request.getParameter("status");
        String password = request.getParameter("pass");
        String confPassword = request.getParameter("passConf");

        EmployeeDataValidation EmployeeData = new EmployeeDataValidation();
        List<String> errorList = EmployeeData.validParamethers(name, role, email, status, password, confPassword);
        Employee emp = new Employee(0, name, role, email, password, status);
        if (errorList.size() == 0) {

            try {
                EmployeeDAO.addEmployee(emp);
                request.setAttribute("hasError", "false");
                List<Employee> lista = new ArrayList();
                List<Employee> listaAuxiliar = EmployeeDAO.getEmployees();
                EmployeeDAO.getEmployeePaginated(0, 10);

                lista = EmployeeDAO.getEmployeePaginated(0, 10);
                int currentPage = 10;

                String hasFirst = "", hasPrevious = "", hasNext = "", hasLast = "";

                if (currentPage > 10) {
                    hasFirst = "true";
                    hasPrevious = "true";
                }
                int diferenca = listaAuxiliar.size() - (currentPage);

                if (diferenca > 0 && lista.size() == 10) {
                    hasNext = "true";
                    hasLast = "true";
                }

                request.setAttribute("hasPrevious", hasPrevious);
                request.setAttribute("hasFirst", hasFirst);
                request.setAttribute("hasLast", hasLast);
                request.setAttribute("hasNext", hasNext);
                request.setAttribute("emp", lista);
                request.setAttribute("currentRecord", currentPage);
                RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaFuncionario.jsp");

                dispatcher.forward(request, response);

            } catch (SQLException ex) {
                Logger.getLogger(RegisterEmployee_Servlet.class.getName()).log(Level.SEVERE, null, ex);
                if (ex.getMessage().contains("Duplicate")) {
                    System.out.println("E-mail já existe no banco.");
                    errorList.add("E-mail já existe no banco.");
                    request.setAttribute("employee", emp);
                    request.setAttribute("hasError", "true");
                    request.setAttribute("errorList", errorList);
                    RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CadastrarFuncionario.jsp");
                    requestDispatcher.forward(request, response);
                }
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RegisterEmployee_Servlet.class.getName()).log(Level.SEVERE, null, ex);
                System.out.println("Houve erro no registro no banco.");
                errorList.add("Houve erro no registro no banco.");
                request.setAttribute("employee", emp);
                request.setAttribute("hasError", "true");
                request.setAttribute("errorList", errorList);
                RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CadastrarFuncionario.jsp");
                requestDispatcher.forward(request, response);
            }
        }
        if (errorList.size() > 0) {
            request.setAttribute("employee", emp);
            request.setAttribute("errorList", errorList);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/CadastrarFuncionario.jsp");
            requestDispatcher.forward(request, response);
        }

    }
}
