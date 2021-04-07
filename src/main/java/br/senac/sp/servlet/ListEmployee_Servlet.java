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
        List<Employee> listaAuxiliar = EmployeeDAO.getEmployees();
        EmployeeDAO.getEmployeePaginated(0, 10);
        int currentPage = Integer.parseInt(request.getParameter("currentRecord"));
        String acao = request.getParameter("acao");

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

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String pesquisa = request.getParameter("pesquisa");

            List<Employee> lista = new ArrayList();
            List<Employee> listaAuxiliar = EmployeeDAO.getEmployeesBySearch(pesquisa);
            EmployeeDAO.getEmployeePaginated(0, 10);



            lista = EmployeeDAO.getEmployeePaginatedBySeach(0, 10,pesquisa);
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
            System.out.println("Depois vou querer o registro a partir de " + currentPage);
            request.setAttribute("search", pesquisa);
            request.setAttribute("hasPrevious", hasPrevious);
            request.setAttribute("hasFirst", hasFirst);
            request.setAttribute("hasLast", hasLast);
            request.setAttribute("hasNext", hasNext);
            request.setAttribute("emp", lista);
            request.setAttribute("currentRecord", currentPage);
            RequestDispatcher dispatcher = request.getRequestDispatcher("/ResultadoPesquisaFuncionario.jsp");

            dispatcher.forward(request, response);

        

    }

}
