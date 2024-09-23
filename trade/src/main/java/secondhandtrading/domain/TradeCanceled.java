package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class TradeCanceled extends AbstractEvent {

    private Long postId;
    private Long userId;
    private Long chatId;
    private String status;
    private Date updateDt;

    public TradeCanceled(Trade aggregate) {
        super(aggregate);
    }

    public TradeCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
