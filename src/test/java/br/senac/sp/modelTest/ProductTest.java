package br.senac.sp.modelTest;

import br.senac.sp.model.Product;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author luans
 */
public class ProductTest {

    @Test
    public void ShouldBuildProduct() {
        Product p = new Product(1, "product", "wow", 2.5, "very cool", 500, 5);
        assertEquals(1, p.getProductId());
        assertEquals("product", p.getProductName());
        assertEquals("wow", p.getProductFullName());
        assertEquals("very cool", p.getDescription());
        assertEquals(500, p.getQuantity());
        assertEquals(5, p.getStars());
        
    }
}
