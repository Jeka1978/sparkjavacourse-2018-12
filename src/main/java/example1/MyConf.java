package example1;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan(basePackages = "example1")
public class MyConf {
    @Bean
    public JavaSparkContext sc(){
        SparkConf sparkConf = new SparkConf().setMaster("local").setAppName("stam");
        return new JavaSparkContext(sparkConf);
    }
}
