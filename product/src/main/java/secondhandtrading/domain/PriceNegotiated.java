package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PriceNegotiated extends AbstractEvent {

    private Long posttId;
    private String userId;
    private Integer price;
    private String sellerUserId;
    private Integer negoPrice;

    public PriceNegotiated(Product aggregate) {
        super(aggregate);
    }

    public PriceNegotiated() {
        super();
    }
}
//>>> DDD / Domain Event
