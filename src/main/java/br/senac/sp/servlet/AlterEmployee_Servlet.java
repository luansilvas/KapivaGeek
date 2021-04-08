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
public class AlterEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try{
        int EmployeeId = Integer.parseInt(request.getParameter("employeeId"));

        List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(EmployeeId);
        Employee emp = employeeList.get(0);

        request.setAttribute("employee", emp);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp");
        requestDispatcher.forward(request, response);
        }catch(Exception e){
         List<Employee> lista = new ArrayList();
        List<Employee> listaAuxiliar = EmployeeDAO.getEmployees();
        EmployeeDAO.getEmployeePaginated(0, 10);
        int currentPage = 0;
        String acao = "FirstAccess";

        System.out.println("Quero o registro a partir de " + currentPage);

        switch (acao) {
            case "FirstAccess":
                lista = EmployeeDAO.getEmployeePaginated(0, 10);
                currentPage = 10;
                break;
            case "Previous":
                if (currentPage % 10 != 0) {
                    currentPage += 10 - (currentPage % 10);
                }
                lista = EmployeeDAO.getEmployeePaginated(currentPage - 20, 10);

                currentPage = currentPage - 10;
                break;
            case "First":
                lista = EmployeeDAO.getEmployeePaginated(0, 10);
                currentPage = 10;
                break;
            case "Next":
                lista = EmployeeDAO.getEmployeePaginated(currentPage, 10);
                currentPage = currentPage + 10;
                break;
            case "Last":
                for (int i = listaAuxiliar.size() - 10; i < listaAuxiliar.size(); i++) {
                    lista.add(listaAuxiliar.get(i));
                }
                currentPage = listaAuxiliar.size() - 10;
                break;
        }
        String hasFirst = "", hasPrevious = "", hasNext = "", hasLast = "";

        if (currentPage > 10) {
            hasFirst = "true";
            hasPrevious = "true";
        }else if(acao.equals("Last")||acao.equals("Next")){
        hasFirst = "true";
        }
        int diferenca = listaAuxiliar.size() - (currentPage);

        if (diferenca > 0 && lista.size() == 10 && !acao.equals("Last")) {
            hasNext = "true";
            hasLast = "true";
        }
        System.out.println("Depois vou querer o registro a partir de " + currentPage);
//        if (lista.size() == 0 && acao.equals("Previous")) {
//            lista = EmployeeDAO.getEmployeePaginated(0, 10);
//            currentPage = 10;
//            if (diferenca > 0 && lista.size() == 10) {
//                hasNext = "true";
//                hasLast = "true";
//            }
//        }

//else if (lista.size() == 0 && acao.equals("Next")) {
//            for (int i = listaAuxiliar.size() - 10; i < listaAuxiliar.size(); i++) {
//                lista.add(listaAuxiliar.get(i));
//            }
//            currentPage = listaAuxiliar.size() - 10;
//
//        }
        request.setAttribute("hasPrevious", hasPrevious);
        request.setAttribute("hasFirst", hasFirst);
        request.setAttribute("hasLast", hasLast);
        request.setAttribute("hasNext", hasNext);
        request.setAttribute("emp", lista);
        request.setAttribute("currentRecord", currentPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaFuncionario.jsp");

        dispatcher.forward(request, response);       
 
        }
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
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp?employeeId="+employee.getEmployeeId());
            requestDispatcher.forward(request, response);

        }
        if (errorList.size() > 0) {
            List<Employee> employeeList = EmployeeDAO.getEmployeeWithList(id);
            Employee employee = employeeList.get(0);
            request.setAttribute("employee", employee);
            request.setAttribute("errorList", errorList);
            request.setAttribute("hasError", "true");
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/WEB-INF/AlterarFuncionario.jsp?employeeId="+employee.getEmployeeId());
            requestDispatcher.forward(request, response);
        }

    }

}
