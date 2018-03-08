package com.udea.testing.program1.statisticsServiceConsumer.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsServiceConsumer.model.Node;
import com.udea.testing.program1.statisticsServiceConsumer.model.NumberSet;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class MeanResultSubscriber implements MessageListener {

    @Override
    public void onMessage(Message message) {

        ObjectMapper objectMapper = new ObjectMapper();
        NumberSet numberSet = null;
        try {
            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);

            System.out.println("udea.testing.result " + objectMapper.writeValueAsString(numberSet));
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(message.getBody());
    }
}
