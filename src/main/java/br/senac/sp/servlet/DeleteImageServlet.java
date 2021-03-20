/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ImageDAO;
import br.senac.sp.model.Image;
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
 * @author luans
 */
public class DeleteImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String toBeDeleted[] = request.getParameterValues("deleteSelected");
        int productId = Integer.parseInt(request.getParameter("productId"));

        for (int i = 0; i < toBeDeleted.length; i++) {

            ImageDAO.deleteImage(Integer.parseInt(toBeDeleted[i]));
        }

        List<Image> imageList = new ArrayList();
        imageList = ImageDAO.getImages(productId);
        request.setAttribute("imageList", imageList);
        request.setAttribute("productId", productId);

        String hasMainImage = "";

        for (Image i : imageList) {

            if (i.getMainImage().equals("true")) {
                hasMainImage = "true";
                break;
            }
            System.out.println(">>>UMA IMAGEM HEIN" + i.getImageId());
        }
        request.setAttribute("hasMainImage", hasMainImage);

        String page = "/cadastrarImagem.jsp";

        if (imageList.size() > 0) {
            page = "/adicionarImagem.jsp";
        } else {
            page = "/cadastrarImagem.jsp";
        }
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher(page);
        requestDispatcher.forward(request, response);

    }

}
