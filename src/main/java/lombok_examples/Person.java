package lombok_examples;

import lombok.*;

import java.util.Map;
import java.util.Objects;

/**
 * @author Evgeny Borisov
 */




@ToString
@Builder
public class Person {
    @Singular("oneFish")
    private Map<String,Integer> fish;
    private String name;
    @NonNull
    private Integer age;
    private int height;



}
