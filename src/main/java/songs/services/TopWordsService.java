package songs.services;

import org.apache.spark.api.java.JavaRDD;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface TopWordsService {
    List<String> topX(JavaRDD<String> lines, int x);
}
