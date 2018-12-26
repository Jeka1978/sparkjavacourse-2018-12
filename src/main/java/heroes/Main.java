package heroes;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext("heroes");
        Elf elf = context.getBean(Elf.class);
        for (int i = 0; i < 10; i++) {
            elf.fight(elf);
        }
    }
}
