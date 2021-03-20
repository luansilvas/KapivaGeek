/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ImageDAO;
import br.senac.sp.model.Image;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.ImageUploadUtils;

/**
 *
 * @author luans
 */
public class ReplaceProductImage extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        int productId = Integer.parseInt(request.getParameter("productId"));
        int imageId = Integer.parseInt(request.getParameter("imageId"));

        List<Image> imageList = new ArrayList();
        imageList = ImageDAO.getImageById(imageId);

        String hasMainImage = "";

        for (Image i : imageList) {

            if (i.getMainImage().equals("true")) {
                hasMainImage = "true";
                break;
            }

        }
        request.setAttribute("hasMainImage", hasMainImage);
        request.setAttribute("productId", productId);
        request.setAttribute("imageId", imageId);
        request.setAttribute("imageList", imageList);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/substituirImagem.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String caminho = null;
        InputStream conteudoArquivo = null;
        Path destino = null;

        int imageId = Integer.parseInt(request.getParameter("imageId"));
        int productId = Integer.parseInt(request.getParameter("productId"));
        Part arquivo = request.getPart("image");

        if (!Paths.get(arquivo.getSubmittedFileName()).getFileName().toString().equals("")) {
            String nomeArquivo = Paths.get(arquivo.getSubmittedFileName()).getFileName().toString();

            nomeArquivo = ImageUploadUtils.valorAleatorio() + nomeArquivo;

            String diretorioDestino = "/PI-FOTOS";
            conteudoArquivo = arquivo.getInputStream();
            destino = Paths.get(diretorioDestino + "/" + nomeArquivo);

            caminho = "/PI-FOTOS/" + nomeArquivo;
            ImageDAO.alterImage(imageId, caminho);

            Files.copy(conteudoArquivo, destino);

            List<Image> imageList = new ArrayList();
            imageList = ImageDAO.getImages(productId);
            
            
                        String hasMainImage = "";

            for (Image i : imageList) {

                if (i.getMainImage().equals("true")) {
                    hasMainImage = "true";
                    break;
                }

            }
            request.setAttribute("hasMainImage", hasMainImage);
            request.setAttribute("productId", productId);
            request.setAttribute("imageList", imageList);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/alterarImagem.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
