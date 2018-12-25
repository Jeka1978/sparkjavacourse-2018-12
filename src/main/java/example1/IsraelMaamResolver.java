package example1;

import lombok.SneakyThrows;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class IsraelMaamResolver implements MaamResolver {
    private double maam;

    @SneakyThrows
    public IsraelMaamResolver() {
        readMaamFromWebService();
        this.maam = maam;
    }

    private void readMaamFromWebService() throws InterruptedException {
        Thread.sleep(2000);
        maam = 0.16;
    }

    public double getMaam() {
        return maam;
    }
}
