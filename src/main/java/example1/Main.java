package example1;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.println(arg);
        }
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyConf.class);
        MainService mainService = context.getBean(MainService.class);
        mainService.start(args[0]);

    }
}
