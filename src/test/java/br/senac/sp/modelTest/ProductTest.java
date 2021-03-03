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
        Product p = new Product(1, "product", "wow", 2.5, 500, 5,"ativo");
        assertEquals(1, p.getProductId());
        assertEquals("product", p.getProductName());
        assertEquals("wow", p.getProductFullName());
        assertEquals(500, p.getQuantity());
        assertEquals(5, p.getStars());
        
    }
}
