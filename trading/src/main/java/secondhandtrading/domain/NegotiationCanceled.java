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

    private Long id;

    public NegotiationCanceled(Trading aggregate) {
        super(aggregate);
    }

    public NegotiationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
