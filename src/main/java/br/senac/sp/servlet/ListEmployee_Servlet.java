/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.EmployeeDAO;
import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Employee;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author raque
 */
public class ListEmployee_Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        List<Employee> lista = new ArrayList();
        List<Employee> listaAuxiliar = new ArrayList();
        EmployeeDAO.getEmployeePaginated(0, 10);
        int currentPage = Integer.parseInt(request.getParameter("currentRecord"));
        String acao = request.getParameter("acao");

        switch (acao) {
            case "FirstAccess":
                lista = EmployeeDAO.getEmployeePaginated(0, 10);
                currentPage = 10;
                break;
            case "Previous":
                lista = EmployeeDAO.getEmployeePaginated(currentPage-10, 10);
                currentPage = currentPage - 10;
                break;
            case "First":
                lista = EmployeeDAO.getEmployeePaginated(0, 10);
                currentPage = 0;
                break;
            case "Next":
                lista = EmployeeDAO.getEmployeePaginated(currentPage+10, 10);
                currentPage = currentPage + 10;
                break;
            case "Last":
                listaAuxiliar = EmployeeDAO.getEmployees();
                for (int i = listaAuxiliar.size() - 10; i < listaAuxiliar.size(); i++) {
                    lista.add(listaAuxiliar.get(i));
                }
                currentPage = listaAuxiliar.size() - 10;
                break;

        }

        request.setAttribute("emp", lista);
        request.setAttribute("currentRecord", currentPage);
        RequestDispatcher dispatcher = request.getRequestDispatcher("/ListaFuncionario.jsp");
        dispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        
        
        
        
    }

}
