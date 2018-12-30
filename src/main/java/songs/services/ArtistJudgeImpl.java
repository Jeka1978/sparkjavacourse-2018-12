package songs.services;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
@Service
public class ArtistJudgeImpl implements ArtistJudge {
    @Autowired
    private TopWordsService topWordsService;
    @Autowired
    private JavaSparkContext sc;

    @Override
    public List<String> topX(String artistName, int x) {
        JavaRDD<String> rdd = sc.textFile("data/songs/" + artistName + "/*");
        return topWordsService.topX(rdd,x);
    }
}
