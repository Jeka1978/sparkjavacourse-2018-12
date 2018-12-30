package linkedIn;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

/**
 * @author Evgeny Borisov
 */
@RequiredArgsConstructor
@Getter
public enum Seniority {
    JUNIOR(0,1000,"צ"),MIDDLE(1001,2000,"מ"), SENIOR(2001,Integer.MAX_VALUE,"א");
    private final int min;
    private final int max;
    private final String hebrewDesc;


    public static Seniority bySalary(long salary) {
       return Arrays.stream(values()).filter(seniority -> seniority.min < salary)
                .filter(seniority -> seniority.max >= salary)
                .findAny().orElse(JUNIOR);
    }
}
