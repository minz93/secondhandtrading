package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PriceChangedAlarmed extends AbstractEvent {

    private Long alarmId;
    private Long userId;
    private Long postId;

    public PriceChangedAlarmed(Alarm aggregate) {
        super(aggregate);
    }

    public PriceChangedAlarmed() {
        super();
    }
}
//>>> DDD / Domain Event
