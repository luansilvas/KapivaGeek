/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.servlet;

import br.senac.sp.dao.ImageDAO;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.nio.file.Path;
import java.nio.file.Paths;
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
@MultipartConfig(maxFileSize = 16177215)
public class UploadImageServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String caminho = null;
        InputStream conteudoArquivo = null;
        Path destino = null;
        Part arquivo = request.getPart("image");

        if (!Paths.get(arquivo.getSubmittedFileName()).getFileName().toString().equals("")) {
            String nomeArquivo = Paths.get(arquivo.getSubmittedFileName()).getFileName().toString();
            String diretorioDestino = "C:/PI-FOTOS";
            conteudoArquivo = arquivo.getInputStream();
            destino = Paths.get(diretorioDestino + "/" + nomeArquivo);
            caminho = "/PI-FOTOS/" + nomeArquivo;
            System.out.println(destino);
            System.out.println(caminho.getClass());
            System.out.println(caminho);
            ImageDAO.addImage(1,caminho);
        }

    }
    
    
    
}
