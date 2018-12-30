package spark.taxi;

import scala.Tuple2;

/**
 * @author Evgeny Borisov
 */
public class TaxiFunctions {


    public static  Tuple2<String, String> fromLineToPair(String line) {
        String[] arr = line.split(", ");
        return new Tuple2<>(arr[0], arr[1]);

    }
}
