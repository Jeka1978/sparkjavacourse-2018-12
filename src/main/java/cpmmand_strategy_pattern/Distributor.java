package cpmmand_strategy_pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import javax.annotation.PreDestroy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */
@Service
public class Distributor {
    private Map<Integer, MessageSender> map = new HashMap<>();

    public Distributor(List<MessageSender> senders) {

        for (MessageSender sender : senders) {
            if (map.containsKey(sender.myType())) {
                throw new IllegalStateException(sender.myType() + " already exists");
            }
            map.put(sender.myType(), sender);
        }
    }

    public void distribute(Message message) {
        int type = message.getSendingType();
        MessageSender messageSender = map.get(type);
        if (messageSender == null) {
            throw new IllegalStateException(type + " not supported yet");
        }
        messageSender.send(message);

    }

    @PreDestroy
    public void killAll(){
        System.out.println("you are teminated...");
    }












}
