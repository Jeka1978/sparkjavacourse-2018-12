package example1;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class ReadRddServiceImpl implements ReadRddService {

    @Autowired
    private JavaSparkContext sc;

    @Override
    public JavaRDD<String> readDataByLines(String path) {
        JavaRDD<String> rdd = sc.textFile(path);
        return rdd;
    }
}
