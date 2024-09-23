package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PostDeleted extends AbstractEvent {

    private Long postId;
    private String userId;

    public PostDeleted(Post aggregate) {
        super(aggregate);
    }

    public PostDeleted() {
        super();
    }
}
//>>> DDD / Domain Event
