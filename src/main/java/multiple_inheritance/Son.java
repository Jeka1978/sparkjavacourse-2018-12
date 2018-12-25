package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */

public class Son implements Father, Mother {

    @Override
    public void talkToChildren() {
        Father.super.talkToChildren();
        Mother.super.talkToChildren();
        System.out.println("sadjkash");
    }
}
