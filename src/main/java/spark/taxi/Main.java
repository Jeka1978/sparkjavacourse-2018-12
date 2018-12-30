package spark.taxi;

import org.apache.spark.Accumulable;
import org.apache.spark.Accumulator;
import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaPairRDD;
import org.apache.spark.api.java.JavaRDD;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.storage.StorageLevel;
import scala.Tuple2;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setAppName("taxi").setMaster("local[*]");
        JavaSparkContext sc = new JavaSparkContext(conf);
        JavaRDD<String> rawData = sc.textFile("data/taxi_order.txt");
        long count = rawData.count();
        System.out.println("count = " + count);
        JavaRDD<Trip> tripsRdd = rawData.map(String::toLowerCase).map(Trip::fromLine);
        tripsRdd.persist(StorageLevel.MEMORY_AND_DISK());
        Accumulator<Integer> accumulator = sc.accumulator(0, "5 km");
        JavaRDD<Trip> bostonRdd = tripsRdd.filter(trip -> {
            accumulator.add(1);

            return trip.getCity().equals("boston");
        });
        JavaRDD<Trip> bostonLongTrips = bostonRdd
                .filter(trip -> trip.getKm() > 10);
        System.out.println("bostonLongTrips = " + bostonLongTrips.count());
        Double sum = bostonRdd.mapToDouble(Trip::getKm).sum();
        System.out.println("total km to boston = " + sum);

        JavaPairRDD<String, Integer> tripsTotalRdd = tripsRdd.mapToPair(trip -> new Tuple2<>(trip.getId(), trip.getKm()))
                .reduceByKey(Integer::sum);
              /*  .mapToPair(Tuple2::swap)
                .sortByKey(false)
                .mapToPair(Tuple2::swap);
*/
        JavaPairRDD<String, String> driversRdd = sc.textFile("data/drivers.txt")
                .mapToPair(TaxiFunctions::fromLineToPair);
        driversRdd.join(tripsTotalRdd)
                .mapToPair(t->t._2().swap())
                .sortByKey(false)
                .take(3).forEach(System.out::println);

        Integer value = accumulator.value();
        System.out.println("value = " + value);


    }

}
