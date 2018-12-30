package songs.conf;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.broadcast.Broadcast;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.*;
import songs.services.ArtistJudge;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Configuration
@ComponentScan(basePackages = "songs")
@PropertySource("classpath:user.properties")
public class MainConf {

    @Bean
    public Broadcast<UserConfig> userConfigBroadcast(UserConfig userConfig, JavaSparkContext sc) {
        return sc.broadcast(userConfig);
    }

    @Bean
    public JavaSparkContext sc(SparkConf conf) {
        return new JavaSparkContext(conf);
    }


    public static void main(String[] args) {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MainConf.class);
        List<String> topX = context.getBean(ArtistJudge.class).topX("beatles", 3);
        System.out.println("topX = " + topX);

    }









}
