package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class ChatAlarmed extends AbstractEvent {

    private Long alarmId;
    private Long userId;
    private Long sellerUserId;
    private Long postId;

    public ChatAlarmed(Alarm aggregate) {
        super(aggregate);
    }

    public ChatAlarmed() {
        super();
    }
}
//>>> DDD / Domain Event
