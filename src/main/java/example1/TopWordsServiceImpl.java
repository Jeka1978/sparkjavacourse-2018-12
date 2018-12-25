package example1;

import org.apache.spark.api.java.JavaRDD;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class TopWordsServiceImpl implements TopWordsService {
    @Override
    public String mostPopular(JavaRDD<String> lines) {
        return lines.map(String::toLowerCase).take(1).get(0);
    }
}
