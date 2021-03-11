package br.senac.sp.dao;

import bd.ConexaoDB;
import br.senac.sp.model.Image;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.logging.Level;
/**
 *
 * @author luans
 */
public class ImageDAO {

    public static boolean addImage(int idProduto, String image) {

        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {

            conexao = ConexaoDB.abrirConexao();
                
            instrucaoSQL = conexao.prepareStatement("insert into product_img(prod_id,path_img,status_img,date_register)values(?,?,'a',now());", Statement.RETURN_GENERATED_KEYS);

            instrucaoSQL.setInt(1, idProduto);
            instrucaoSQL.setString(2, image);
                

            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;

                ResultSet generatedKeys = instrucaoSQL.getGeneratedKeys();
                if (!generatedKeys.next()) {
                  
                    throw new SQLException("Falha ao obter o código da imagem.");
                } 
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());

        } finally {
            try {
                if (instrucaoSQL != null) {
                    ConexaoDB.fecharConexao();
                }
            } catch (SQLException ex) {
                System.out.println("Houve erro ao encerrar sua conexão. Tente novamente.");
            }
        }

        return retorno;

    }

    public static boolean deleteImage(int imageId) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update product_img set status_img = 'i' where img_id=? and status_img = 'a';");

            instrucaoSQL.setInt(1, imageId);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;

    }
    public static boolean alterImage(int imageId,String newPath) {
        boolean retorno = false;
        Connection conexao = null;
        PreparedStatement instrucaoSQL = null;

        try {
            conexao = ConexaoDB.abrirConexao();

            instrucaoSQL = conexao.prepareStatement("update product_img set path_img = ? where img_id=? and status_img = 'a';");

            instrucaoSQL.setString(1, newPath);
            instrucaoSQL.setInt(2, imageId);
            int linhasAfetadas = instrucaoSQL.executeUpdate();
            if (linhasAfetadas > 0) {
                retorno = true;
            } else {
                retorno = false;
            }

        } catch (SQLException | ClassNotFoundException ex) {
            System.out.println(ex.getMessage());
            retorno = false;
        } finally {

            try {
                if (instrucaoSQL != null) {
                    instrucaoSQL.close();
                }

                conexao.close();

            } catch (SQLException ex) {
            }
        }
        return retorno;

    }

    public static List<Image> getImages(int productId) throws IOException {
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement instrucaoSQL = null;
        List<Image> imageList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = ConexaoDB.abrirConexao();

            instrucaoSQL = connection.prepareStatement("select * from product_img where status_img='a' and prod_id=?");
            instrucaoSQL.setInt(1, productId);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                int imageId = rs.getInt("img_id");
                String path = rs.getString("path_img");
                int pId = rs.getInt("prod_id");
                String status = rs.getString("status_img");
                String timestamp = rs.getString("date_register");
                    
                
                Image image = new Image(imageId,pId,path,status,timestamp);
                imageList.add(image);
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           // Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageList;
    }
    
        public static List<Image> getImageById(int imgId) throws IOException {
        ResultSet rs = null;
        Connection connection = null;
        PreparedStatement instrucaoSQL = null;
        List<Image> imageList = new ArrayList();
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            connection = ConexaoDB.abrirConexao();

            instrucaoSQL = connection.prepareStatement("select * from product_img where status_img='a' and img_id=?");
            instrucaoSQL.setInt(1, imgId);
            rs = instrucaoSQL.executeQuery();
            while (rs.next()) {
                int imageId = rs.getInt("img_id");
                String path = rs.getString("path_img");
                int pId = rs.getInt("prod_id");
                String status = rs.getString("status_img");
                String timestamp = rs.getString("date_register");
                    
                
                Image image = new Image(imageId,pId,path,status,timestamp);
                imageList.add(image);
            }
        } catch (ClassNotFoundException ex) {
            //Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
           // Logger.getLogger(ServletBD.class.getName()).log(Level.SEVERE, null, ex);
        }
        return imageList;
    }

}
