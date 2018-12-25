package cpmmand_strategy_pattern;

/**
 * @author Evgeny Borisov
 */


public interface MessageSender {
    void send(Message message);
    int myType();
}
