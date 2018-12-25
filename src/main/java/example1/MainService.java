package example1;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class MainService {
    @Autowired
    private TopWordsService topWordsService;
    @Autowired
    private ReadRddService readRddService;

    public void start(String path) {
        JavaRDD<String> rdd = readRddService.readDataByLines(path);
        String mostPopular = topWordsService.mostPopular(rdd);
        System.out.println("mostPopular = " + mostPopular);
    }
}
