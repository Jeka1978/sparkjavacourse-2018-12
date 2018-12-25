package cpmmand_strategy_pattern;

import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class EmailMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("sent by email "+message.getText());
    }

    @Override
    public int myType() {
        return 1;
    }
}
