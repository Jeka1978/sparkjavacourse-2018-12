package example1;

import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@Service
public class MoneyService {
    private MaamResolver maamResolver;
    public void printMaam(int price) {
        System.out.println(maamResolver.getMaam()*price);
    }
}
