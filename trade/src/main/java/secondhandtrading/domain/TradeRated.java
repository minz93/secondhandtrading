package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TradeRated extends AbstractEvent {

    private Long postId;
    private Long userId;
    private String rating;

    public TradeRated(Trade aggregate) {
        super(aggregate);
    }

    public TradeRated() {
        super();
    }
}
//>>> DDD / Domain Event
