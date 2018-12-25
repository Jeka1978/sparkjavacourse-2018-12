package example1;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class TaxCalcTest {

    @Test
    public void withMaam() {

        MaamResolver mock = Mockito.mock(MaamResolver.class);
        Mockito.when(mock.getMaam()).thenReturn(0.17);

        TaxCalc taxCalc = new TaxCalc(mock);
        double withMaam = taxCalc.withMaam(100);
        Assert.assertEquals(117,withMaam,0.00001);
    }


}