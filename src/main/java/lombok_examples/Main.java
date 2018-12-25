package lombok_examples;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Evgeny Borisov
 */
public class Main {


    public static void main(String[] args) {

        Person person = Person.builder().age(12).oneFish("Stella",3).name("Alisa").build();
        System.out.println("person = " + person);
    }
}
