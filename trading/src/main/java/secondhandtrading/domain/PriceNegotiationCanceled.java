package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PriceNegotiationCanceled extends AbstractEvent {

    private Long id;

    public PriceNegotiationCanceled(Trading aggregate) {
        super(aggregate);
    }

    public PriceNegotiationCanceled() {
        super();
    }
}
//>>> DDD / Domain Event
