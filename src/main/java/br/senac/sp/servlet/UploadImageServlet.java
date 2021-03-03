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
import java.util.ArrayList;
import java.util.List;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

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
        System.out.println("passou pelo get");
        List<Image> imageList = new ArrayList();
        imageList = ImageDAO.getImages(productId);
        request.setAttribute("imageList", imageList);
        request.setAttribute("productId",productId);
        RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cadastrarImagem.jsp");
        requestDispatcher.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String caminho = null;
        InputStream conteudoArquivo = null;
        Path destino = null;
        //int codProduto = Integer.parseInt(request.getParameter("codProduto"));
        Part arquivo = request.getPart("image");

        if (!Paths.get(arquivo.getSubmittedFileName()).getFileName().toString().equals("")) {
            String nomeArquivo = Paths.get(arquivo.getSubmittedFileName()).getFileName().toString();
            String diretorioDestino = "C:/PI-FOTOS";
            conteudoArquivo = arquivo.getInputStream();
            destino = Paths.get(diretorioDestino + "/" + nomeArquivo);
            caminho = "C:/PI-FOTOS/" + nomeArquivo;
            ImageDAO.addImage(1, caminho);

            Files.copy(conteudoArquivo, destino);

            int productId = Integer.parseInt(request.getParameter("productId"));

            List<Image> imageList = new ArrayList();
            imageList = ImageDAO.getImages(productId);
            request.setAttribute("productId",productId);
            request.setAttribute("imageList", imageList);
            RequestDispatcher requestDispatcher = getServletContext().getRequestDispatcher("/cadastrarImagem.jsp");
            requestDispatcher.forward(request, response);
        }

    }

}
