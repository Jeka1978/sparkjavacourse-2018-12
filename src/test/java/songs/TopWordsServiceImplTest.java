package songs;

import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringRunner;
import songs.conf.MainConf;
import songs.services.TopWordsService;

import java.util.List;

import static java.util.Arrays.asList;

/**
 * @author Evgeny Borisov
 */
@RunWith(SpringRunner.class)
@ContextConfiguration(classes = MainConf.class)
@ActiveProfiles("DEV")
public class TopWordsServiceImplTest {
    @Autowired
    private JavaSparkContext sc;

    @Autowired
    private TopWordsService topWordsService;

    @Test
    public void testTopX() {
        List<String> list = asList("java java java", "scala java", "Java");
        JavaRDD<String> rdd = sc.parallelize(list);
        List<String> answer = topWordsService.topX(rdd, 1);
        Assert.assertEquals(1,answer.size());
        Assert.assertEquals("java",answer.get(0));


    }
}