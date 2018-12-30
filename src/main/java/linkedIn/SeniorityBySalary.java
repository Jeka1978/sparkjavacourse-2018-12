package linkedIn;

import org.apache.spark.sql.api.java.UDF1;

/**
 * @author Evgeny Borisov
 */


@RegisterUdf
public class SeniorityBySalary implements UDF1<Long,String> {

    @Override
    public String call(Long salary) throws Exception {
        return Seniority.bySalary(salary).getHebrewDesc();
    }
}
