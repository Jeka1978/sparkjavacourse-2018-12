package cpmmand_strategy_pattern;

import org.springframework.stereotype.Service;

/**
 *
 * @author Evgeny Borisov
 */
@Service
public class ViberMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("sent "+message.getText()+" by viber");
    }

    @Override
    public int myType() {
        return 3;
    }
}
