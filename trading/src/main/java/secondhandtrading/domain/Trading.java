package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import secondhandtrading.TradingApplication;
import secondhandtrading.domain.TradeCanceled;
import secondhandtrading.domain.TradeEnded;
import secondhandtrading.domain.TradeFixed;
import secondhandtrading.domain.TradeRated;

@Entity
@Table(name = "Trading_table")
@Data
//<<< DDD / Aggregate Root
public class Trading {

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
    }

    public static TradingRepository repository() {
        TradingRepository tradingRepository = TradingApplication.applicationContext.getBean(
            TradingRepository.class
        );
        return tradingRepository;
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
        Trading trading = new Trading();
        repository().save(trading);

        TradeRated tradeRated = new TradeRated(trading);
        tradeRated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(tradeEnded.get???()).ifPresent(trading->{
            
            trading // do something
            repository().save(trading);

            TradeRated tradeRated = new TradeRated(trading);
            tradeRated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
