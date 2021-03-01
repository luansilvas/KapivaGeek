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
    private String description;
    private int quantity;
    private int stars;


    public Product(int productId, String productName, String productFullName, double price, String description, int quantity, int stars) {
        try {
            this.productId = productId;
            this.productName = productName;
            this.productFullName = productFullName;
            this.price = price;
            this.description = description;
            this.quantity = quantity;
            this.stars = stars;
        } catch (Exception e) {
            System.out.println("There was an error building the product object");
            System.out.println("Full error message: {" + e.getLocalizedMessage() + "}");
        }
    }

}
