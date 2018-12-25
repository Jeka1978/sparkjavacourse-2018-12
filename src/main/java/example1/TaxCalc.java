package example1;

import lombok.AllArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@Service
public class TaxCalc {
    private MaamResolver maamResolver;

    public double withMaam(double price) {
        return maamResolver.getMaam()*price+price;
    }
}
