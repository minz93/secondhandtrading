package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class LikeCntUpdated extends AbstractEvent {

    private Long postId;
    private Integer likeCnt;

    public LikeCntUpdated(Post aggregate) {
        super(aggregate);
    }

    public LikeCntUpdated() {
        super();
    }
}
//>>> DDD / Domain Event
