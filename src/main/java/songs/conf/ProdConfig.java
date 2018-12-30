package songs.conf;

import org.apache.spark.SparkConf;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@Prod
public class ProdConfig {
    @Bean
    public SparkConf conf() {
        return new SparkConf();
    }
}
