/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.senac.sp.model;

import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author luans
 */
@Getter
@Setter
public class Image {

    private int imageId;
    private String photoTitle;
    private int productId;

    public Image(int imageId, String photoTitle, int productId) {
        try {
            this.imageId = imageId;
            this.photoTitle = photoTitle;
            this.productId = productId;
        } catch (Exception e) {
            System.out.println("There was an error building the image object");
            System.out.println("Full error message: {" + e.getLocalizedMessage() + "}");
        }
    }

}
