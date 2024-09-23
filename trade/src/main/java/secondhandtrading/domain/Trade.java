package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import secondhandtrading.TradeApplication;
import secondhandtrading.domain.NegotiationCanceled;
import secondhandtrading.domain.TradeCanceled;
import secondhandtrading.domain.TradeEnded;
import secondhandtrading.domain.TradeFixed;
import secondhandtrading.domain.TradeRated;

@Entity
@Table(name = "Trade_table")
@Data
//<<< DDD / Aggregate Root
public class Trade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private Long userId;

    private Long chatId;

    private String status;

    private Date updateDt;

    @PostPersist
    public void onPostPersist() {
        TradeFixed tradeFixed = new TradeFixed(this);
        tradeFixed.publishAfterCommit();

        TradeCanceled tradeCanceled = new TradeCanceled(this);
        tradeCanceled.publishAfterCommit();

        TradeEnded tradeEnded = new TradeEnded(this);
        tradeEnded.publishAfterCommit();

        TradeRated tradeRated = new TradeRated(this);
        tradeRated.publishAfterCommit();

        NegotiationCanceled negotiationCanceled = new NegotiationCanceled(this);
        negotiationCanceled.publishAfterCommit();
    }

    public static TradeRepository repository() {
        TradeRepository tradeRepository = TradeApplication.applicationContext.getBean(
            TradeRepository.class
        );
        return tradeRepository;
    }

    public void fixTrade() {
        //implement business logic here:

        TradeFixed tradeFixed = new TradeFixed(this);
        tradeFixed.publishAfterCommit();
    }

    public void cancelTrade() {
        //implement business logic here:

        TradeCanceled tradeCanceled = new TradeCanceled(this);
        tradeCanceled.publishAfterCommit();
    }

    public void endTrade() {
        //implement business logic here:

        TradeEnded tradeEnded = new TradeEnded(this);
        tradeEnded.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void rateTrade(TradeEnded tradeEnded) {
        //implement business logic here:

        /** Example 1:  new item 
        Trade trade = new Trade();
        repository().save(trade);

        TradeRated tradeRated = new TradeRated(trade);
        tradeRated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(tradeEnded.get???()).ifPresent(trade->{
            
            trade // do something
            repository().save(trade);

            TradeRated tradeRated = new TradeRated(trade);
            tradeRated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
