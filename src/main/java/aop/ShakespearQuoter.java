package aop;

import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class ShakespearQuoter implements Quoter {
    @Override
    @Scheduled(fixedDelay = 1000)
    @Profiling
    public void sayQuote() {
        System.out.println("2 B || ! 2 B");
    }
}
