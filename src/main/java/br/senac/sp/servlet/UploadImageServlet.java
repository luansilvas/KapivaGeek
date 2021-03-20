/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ImageDAO;
import br.senac.sp.model.Image;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import utils.ImageUploadUtils;

/**
 *
 * @author luans
 */
@MultipartConfig(maxFileSize = 20848820) // 5MB == 20848820 bytes == 5 * 1024 * 1024
public class UploadImageServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        int productId = Integer.parseInt(request.getParameter("codProduto"));

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

        }
        request.setAttribute("hasMainImage", hasMainImage);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cadastrarImagem.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String caminho = null;
        InputStream conteudoArquivo = null;
        Path destino = null;
        String mainImage = "";
        int productId = Integer.parseInt(request.getParameter("productId"));
        if (request.getParameter("mainimage") != null) {
            mainImage = request.getParameter("mainimage");
        }

        System.out.println(">>>>" + mainImage);
        Part arquivo = request.getPart("image");

        if (!Paths.get(arquivo.getSubmittedFileName()).getFileName().toString().equals("")) {
            String nomeArquivo = Paths.get(arquivo.getSubmittedFileName()).getFileName().toString();

            nomeArquivo = ImageUploadUtils.valorAleatorio() + nomeArquivo;

            String diretorioDestino = "/PI-FOTOS";
            conteudoArquivo = arquivo.getInputStream();
            destino = Paths.get(diretorioDestino + "/" + nomeArquivo);

            caminho = "/PI-FOTOS/" + nomeArquivo;
            if (request.getParameter("mainimage") == null) {
                ImageDAO.addImage(productId, caminho, "");
            } else {
                ImageDAO.addImage(productId, caminho, mainImage);
            }
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
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/adicionarImagem.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
