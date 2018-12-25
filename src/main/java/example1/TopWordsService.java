package example1;

import org.apache.spark.api.java.JavaRDD;

/**
 * @author Evgeny Borisov
 */

public interface TopWordsService {
    String mostPopular(JavaRDD<String> lines);
}
