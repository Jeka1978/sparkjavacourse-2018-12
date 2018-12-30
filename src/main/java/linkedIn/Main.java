package linkedIn;

import org.apache.spark.SparkConf;
import org.apache.spark.api.java.JavaSparkContext;
import org.apache.spark.sql.DataFrame;
import org.apache.spark.sql.Row;
import org.apache.spark.sql.SQLContext;
import org.apache.spark.sql.types.DataType;
import org.apache.spark.sql.types.DataTypes;
import org.apache.spark.sql.types.StructField;

import java.util.Arrays;

import static org.apache.spark.sql.functions.*;

/**
 * @author Evgeny Borisov
 */
public class Main {
    private static final String SALARY = "salary";
    private static final String AGE = "age";
    private static final String KEYWORDS = "keywords";
    private static final String KEYWORD = "keyword";
    public static final String AMOUNT = "amount";

    public static void main(String[] args) {
        SparkConf conf = new SparkConf().setMaster("local[*]").setAppName("linked in");
        JavaSparkContext sc = new JavaSparkContext(conf);
        SQLContext sqlContext = new SQLContext(sc);
        sqlContext.udf().register(SeniorityBySalary.class.getName(), new SeniorityBySalary(), DataTypes.StringType);
        DataFrame dataFrame = sqlContext.read().json("data/linkedIn/*.json");
        dataFrame.show();
        dataFrame.printSchema();
        Arrays.stream(dataFrame.schema().fields()).forEach(Main::printField);
        DataFrame withSalaryDF = dataFrame.withColumn(SALARY, col(AGE).multiply(10).multiply(size(col(KEYWORDS))));
        withSalaryDF.withColumn("Seniority",callUDF(SeniorityBySalary.class.getName(),col(SALARY)))
                .show();
        DataFrame keyWordDF = withSalaryDF.withColumn(KEYWORD, explode(col(KEYWORDS))).select(KEYWORD);
        Row row = keyWordDF.groupBy(KEYWORD).agg(count(col(KEYWORD)).as(AMOUNT))
                .orderBy(col(AMOUNT).desc()).first();
        String mostPopular = row.getAs(KEYWORD);
        System.out.println("mostPopular = " + mostPopular);
        withSalaryDF.where(col(SALARY).leq(1200)).filter(array_contains(col(KEYWORDS),mostPopular))
                .show();


    }

    private static void printField(StructField structField) {
        System.out.println(structField.dataType());
        System.out.println(structField.name());
    }
}









