package third_party_senders;

import cpmmand_strategy_pattern.Message;
import cpmmand_strategy_pattern.MessageSender;
import lombok.AllArgsConstructor;

/**
 * @author Evgeny Borisov
 */


@AllArgsConstructor
public class SkypeSender implements MessageSender {
    private String msg;

    @Override
    public void send(Message message) {
        System.out.println("msg = " + msg);
        System.out.println("sent by SKYPE");
    }

    @Override
    public int myType() {
        return 4;
    }
}
