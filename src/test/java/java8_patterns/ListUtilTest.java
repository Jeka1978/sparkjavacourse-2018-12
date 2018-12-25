package java8_patterns;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

import static java.util.Arrays.asList;
import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class ListUtilTest {

    @Test
    public void countDuplicates() {

        List<String> strings = asList("java", "JAVA", "JaVa", "scala", "python");


        int duplicates = ListUtil.countDuplicates("java", strings, String::equalsIgnoreCase);
        Assert.assertEquals(3,duplicates);

    }
}