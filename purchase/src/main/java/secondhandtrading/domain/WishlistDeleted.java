package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WishlistDeleted extends AbstractEvent {

    private Long posttId;
    private String userId;
    private String status;
    private Integer price;
    private Integer likeCnt;
    private Long traderId;

    public WishlistDeleted(Purchase aggregate) {
        super(aggregate);
    }

    public WishlistDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
