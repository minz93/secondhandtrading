package secondhandtrading.infra;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.naming.NameParser;
import javax.naming.NameParser;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;
import secondhandtrading.config.kafka.KafkaProcessor;
import secondhandtrading.domain.*;

//<<< Clean Arch / Inbound Adaptor
@Service
@Transactional
public class PolicyHandler {

    @Autowired
    AlarmRepository alarmRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='MessagesSent'"
    )
    public void wheneverMessagesSent_AlarmChat(
        @Payload MessagesSent messagesSent
    ) {
        MessagesSent event = messagesSent;
        System.out.println(
            "\n\n##### listener AlarmChat : " + messagesSent + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmChat(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PostEdited'"
    )
    public void wheneverPostEdited_AlarmPriceChanged(
        @Payload PostEdited postEdited
    ) {
        PostEdited event = postEdited;
        System.out.println(
            "\n\n##### listener AlarmPriceChanged : " + postEdited + "\n\n"
        );

        // Sample Logic //
        Alarm.alarmPriceChanged(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='PriceNegotiated'"
    )
    public void wheneverPriceNegotiated_AlarmPriceNegotiation(
        @Payload PriceNegotiated priceNegotiated
    ) {
        PriceNegotiated event = priceNegotiated;
        System.out.println(
            "\n\n##### listener AlarmPriceNegotiation : " +
            priceNegotiated +
            "\n\n"
        );

        // Sample Logic //
        Alarm.alarmPriceNegotiation(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
