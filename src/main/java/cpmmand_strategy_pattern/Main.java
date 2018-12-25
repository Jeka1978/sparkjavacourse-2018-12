package cpmmand_strategy_pattern;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static java.lang.Math.*;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {


        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Conf.class);
        Distributor distributor = context.getBean(Distributor.class);
        distributor.distribute(Message.builder().text("Hello").sendingType(4).build());
        distributor.distribute(Message.builder().text("Hello").sendingType(1).build());
        distributor.distribute(Message.builder().text("Hello").sendingType(2).build());
        distributor.distribute(Message.builder().text("Hello").sendingType(3).build());
        context.close();
    }
}
