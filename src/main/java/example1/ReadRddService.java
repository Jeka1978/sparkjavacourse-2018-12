package example1;

import org.apache.spark.api.java.JavaRDD;

/**
 * @author Evgeny Borisov
 */

public interface ReadRddService {
    JavaRDD<String> readDataByLines(String path);
}
