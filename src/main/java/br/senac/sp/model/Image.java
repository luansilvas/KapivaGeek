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
    private String mainImage;
    private String status;
    private String timestamp;

    public Image(int imageId, int productId, String path, String mainImage, String status, String timestamp) {
        this.imageId = imageId;
        this.productId = productId;
        this.path = path;
        this.mainImage = mainImage;
        this.status = status;
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "Image{" + "imageId=" + imageId + ", productId=" + productId + ", path=" + path + ", mainImage=" + mainImage + ", status=" + status + ", timestamp=" + timestamp + '}';
    }


  

}
