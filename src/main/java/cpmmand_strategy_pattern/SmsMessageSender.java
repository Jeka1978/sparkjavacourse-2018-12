package cpmmand_strategy_pattern;

import org.springframework.stereotype.Service;

/**
 * @author Evgeny Borisov
 */
@Service
public class SmsMessageSender implements MessageSender {
    @Override
    public void send(Message message) {
        System.out.println("sent by sms");
    }

    @Override
    public int myType() {
        return 2;
    }
}
