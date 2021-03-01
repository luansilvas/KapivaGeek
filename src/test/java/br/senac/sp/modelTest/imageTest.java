
package br.senac.sp.modelTest;
import br.senac.sp.model.Image;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author luans
 */
public class imageTest {

@Test
public void shouldBuildImageObject(){
    Image i = new Image(1,"wow",2);
    assertEquals(1,i.getImageId());
    assertEquals("wow",i.getPhotoTitle());
    assertEquals(2,i.getProductId());
}
    
    
    
    
    
}
