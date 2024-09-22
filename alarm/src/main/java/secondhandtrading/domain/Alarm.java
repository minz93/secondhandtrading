package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import secondhandtrading.AlarmApplication;
import secondhandtrading.domain.ChatAlarmed;
import secondhandtrading.domain.PriceChangedAlarmed;
import secondhandtrading.domain.PriceNegotiationAlarmed;

@Entity
@Table(name = "Alarm_table")
@Data
//<<< DDD / Aggregate Root
public class Alarm {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long alarmId;

    private Long userId;

    private Long sellerUserId;

    private Long postId;

    @PostPersist
    public void onPostPersist() {
        ChatAlarmed chatAlarmed = new ChatAlarmed(this);
        chatAlarmed.publishAfterCommit();

        PriceChangedAlarmed priceChangedAlarmed = new PriceChangedAlarmed(this);
        priceChangedAlarmed.publishAfterCommit();

        PriceNegotiationAlarmed priceNegotiationAlarmed = new PriceNegotiationAlarmed(
            this
        );
        priceNegotiationAlarmed.publishAfterCommit();
    }

    public static AlarmRepository repository() {
        AlarmRepository alarmRepository = AlarmApplication.applicationContext.getBean(
            AlarmRepository.class
        );
        return alarmRepository;
    }

    //<<< Clean Arch / Port Method
    public static void alarmChat(MessagesSent messagesSent) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        ChatAlarmed chatAlarmed = new ChatAlarmed(alarm);
        chatAlarmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(messagesSent.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);

            ChatAlarmed chatAlarmed = new ChatAlarmed(alarm);
            chatAlarmed.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmPriceChanged(PostEdited postEdited) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        PriceChangedAlarmed priceChangedAlarmed = new PriceChangedAlarmed(alarm);
        priceChangedAlarmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(postEdited.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);

            PriceChangedAlarmed priceChangedAlarmed = new PriceChangedAlarmed(alarm);
            priceChangedAlarmed.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void alarmPriceNegotiation(PriceNegotiated priceNegotiated) {
        //implement business logic here:

        /** Example 1:  new item 
        Alarm alarm = new Alarm();
        repository().save(alarm);

        PriceNegotiationAlarmed priceNegotiationAlarmed = new PriceNegotiationAlarmed(alarm);
        priceNegotiationAlarmed.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(priceNegotiated.get???()).ifPresent(alarm->{
            
            alarm // do something
            repository().save(alarm);

            PriceNegotiationAlarmed priceNegotiationAlarmed = new PriceNegotiationAlarmed(alarm);
            priceNegotiationAlarmed.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
