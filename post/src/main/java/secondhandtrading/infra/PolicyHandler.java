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
    PostRepository postRepository;

    @StreamListener(KafkaProcessor.INPUT)
    public void whatever(@Payload String eventString) {}

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TradeEnded'"
    )
    public void wheneverTradeEnded_UpdateStatus(
        @Payload TradeEnded tradeEnded
    ) {
        TradeEnded event = tradeEnded;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + tradeEnded + "\n\n"
        );

        // Sample Logic //
        Post.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TradeFixed'"
    )
    public void wheneverTradeFixed_UpdateStatus(
        @Payload TradeFixed tradeFixed
    ) {
        TradeFixed event = tradeFixed;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + tradeFixed + "\n\n"
        );

        // Sample Logic //
        Post.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='TradeCanceled'"
    )
    public void wheneverTradeCanceled_UpdateStatus(
        @Payload TradeCanceled tradeCanceled
    ) {
        TradeCanceled event = tradeCanceled;
        System.out.println(
            "\n\n##### listener UpdateStatus : " + tradeCanceled + "\n\n"
        );

        // Sample Logic //
        Post.updateStatus(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WishlistAdded'"
    )
    public void wheneverWishlistAdded_UpdateLikecnt(
        @Payload WishlistAdded wishlistAdded
    ) {
        WishlistAdded event = wishlistAdded;
        System.out.println(
            "\n\n##### listener UpdateLikecnt : " + wishlistAdded + "\n\n"
        );

        // Sample Logic //
        Post.updateLikecnt(event);
    }

    @StreamListener(
        value = KafkaProcessor.INPUT,
        condition = "headers['type']=='WishlistDeleted'"
    )
    public void wheneverWishlistDeleted_UpdateLikecnt(
        @Payload WishlistDeleted wishlistDeleted
    ) {
        WishlistDeleted event = wishlistDeleted;
        System.out.println(
            "\n\n##### listener UpdateLikecnt : " + wishlistDeleted + "\n\n"
        );

        // Sample Logic //
        Post.updateLikecnt(event);
    }
}
//>>> Clean Arch / Inbound Adaptor
