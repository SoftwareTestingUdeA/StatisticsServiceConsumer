package com.udea.testing.program1.statisticsServiceConsumer.subscribers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.udea.testing.program1.statisticsServiceConsumer.model.Node;
import com.udea.testing.program1.statisticsServiceConsumer.model.NumberSet;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageListener;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class StdDeviationResultSubscriber implements MessageListener {

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
//        ObjectMapper objectMapper = new ObjectMapper();
//        Publisher publisher = new Publisher();
//        NumberSet numberSet = null;
//        try {
//            numberSet = objectMapper.readValue(message.getBody(), NumberSet.class);
//            Double mean = 0.0;
//            Node node = numberSet.getSet().getFirst();
//            while(node != null) {
//                mean += node.getNumber();
//                node.getLink();
//            }
//            //for (Double d : numberSet.getSet())
//                //mean = mean + d;
//            mean = mean / numberSet.getSet().getSize();
//            numberSet.setMean(mean);
//
//            Double stdDeviation = 0.0;
//            node = numberSet.getSet().getFirst();
//            while(node != null) {
//                mean += node.getNumber();
//                stdDeviation += Math.pow(node.getNumber() - mean, 2);
//                node.getLink();
//            }
//
//            stdDeviation = Math.sqrt(stdDeviation / numberSet.getSet().getSize() - 1);
//
//            numberSet.setStdDeviation(stdDeviation);
//
//            publisher.publishMessageAsync("udea.testing.result", "stddeviation", objectMapper.writeValueAsString(numberSet));
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        // System.out.println(new String("lastd  " + message.getMessageProperties()));
    }
}
