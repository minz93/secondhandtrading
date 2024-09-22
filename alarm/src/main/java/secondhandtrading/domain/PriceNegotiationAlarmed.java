package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PriceNegotiationAlarmed extends AbstractEvent {

    private Long alarmId;
    private Long userId;
    private Long sellerUserId;
    private Long postId;
    private Integer negoPrice;

    public PriceNegotiationAlarmed(Alarm aggregate) {
        super(aggregate);
    }

    public PriceNegotiationAlarmed() {
        super();
    }
}
//>>> DDD / Domain Event
