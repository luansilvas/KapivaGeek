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
    private int productId;
    private String path;
    private String status;
    private String timestamp;

    public Image(int imageId, int productId, String path, String Status, String timestamp) {
        this.imageId = imageId;
        this.productId = productId;
        this.path = path;
        this.status = Status;
        this.timestamp = timestamp;
    }
  

}
