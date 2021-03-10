package br.senac.sp.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luans
 */
@Getter
@Setter
public class Product {

    private int productId;
    private String productName;
    private String productFullName;
    private double price;
    private int quantity;
    private int stars;
    private String status;


    public Product(int productId, String productName, String productFullName, double price, int quantity, int stars, String status) {
        try {
            this.productId = productId;
            this.productName = productName;
            this.productFullName = productFullName;
            this.price = price;
            this.quantity = quantity;
            this.stars = stars;
            this.status = status;
        } catch (Exception e) {
            System.out.println("There was an error building the product object");
            System.out.println("Full error message: {" + e.getLocalizedMessage() + "}");
        }
    }

    public Product() {
    }
    
    public boolean getValueStatus(String status){
        if(status.equals("Ativo"))
            return true;
        else
            return false;      
}

    @Override
    public String toString() {
        return "Product{" + "productId=" + productId + ", productName=" + productName + ", productFullName=" + productFullName + ", price=" + price + ", quantity=" + quantity + ", stars=" + stars + ", status=" + status + '}';
    }

    
    
    

}
