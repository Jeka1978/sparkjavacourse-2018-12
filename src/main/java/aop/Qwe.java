package aop;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * @author Evgeny Borisov
 */
@Component
public class Qwe {
    @Scheduled(fixedDelay = 500)
    public void sayHungry() {
        System.out.println("אוכל!!");
    }
}
