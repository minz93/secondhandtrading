package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class WishlistAdded extends AbstractEvent {

    private Long posttId;
    private String userId;
    private String status;
    private Integer price;
    private Integer likeCnt;

    public WishlistAdded(Product aggregate) {
        super(aggregate);
    }

    public WishlistAdded() {
        super();
    }
}
//>>> DDD / Domain Event
