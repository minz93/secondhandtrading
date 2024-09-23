package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class NegotiationCanceled extends AbstractEvent {

    private Long postId;
    private Long userId;
    private Long chatId;
    private String status;
    private Date updateDt;

    public NegotiationCanceled(Trade aggregate) {
        super(aggregate);
    }

    public NegotiationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
