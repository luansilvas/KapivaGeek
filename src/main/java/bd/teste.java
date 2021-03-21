/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import br.senac.sp.dao.ImageDAO;
import br.senac.sp.dao.ProductDAO;
import br.senac.sp.model.Image;
import br.senac.sp.model.Product;
import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author Gabriel
 */
public class teste {
    public static void main(String[] args) throws IOException {
         ProductDAO dao = new ProductDAO();
       
        
        List<Product> produtos = new LinkedList();
        List<Image> images = new LinkedList();
        
      produtos = dao.findProduct();
      images = ImageDAO.getImages();
      
        System.out.println(produtos.toString());
      
     
       
    }
    
}
