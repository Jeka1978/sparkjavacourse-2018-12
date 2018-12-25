package cpmmand_strategy_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import third_party_senders.SkypeSender;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan
@ImportResource("classpath:context.xml")
public class Conf {

    @Bean(name = "str")
    public String str(){
        return "WTF";
    }

/*
    @Bean
    public SkypeSender skypeSender(String str){
        return new SkypeSender(str);
    }
*/
}
