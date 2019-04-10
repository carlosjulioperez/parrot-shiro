package ec.cjpq.parrot;

import org.junit.Test;

import ec.cjpq.parrot.util.Util;
import static org.junit.Assert.assertTrue;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
  */
    @Test
    public void shouldAnswerWithTrue(){
        assertTrue( true );

        Util.getInstance().showMessage();
    }

}
