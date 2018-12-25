package cpmmand_strategy_pattern;

import lombok.Builder;
import lombok.Data;

/**
 * @author Evgeny Borisov
 */
@Data
@Builder
public class Message {
    private String text;
    private int sendingType;
}
