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
    TradeRepository tradeRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TradeEnded'"
    )
    public void wheneverTradeEnded_RateTrade(@Payload TradeEnded tradeEnded) {
        TradeEnded event = tradeEnded;
        System.out.println(
            "\n\n##### listener RateTrade : " + tradeEnded + "\n\n"
        );

        // Sample Logic //
        Trade.rateTrade(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
