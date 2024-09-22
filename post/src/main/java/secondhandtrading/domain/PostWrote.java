package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PostWrote extends AbstractEvent {

    private Long postId;
    private String userId;
    private String status;
    private Date createDt;
    private Integer price;
    private Integer likeCnt;
    private String address;
    private Photo photos;

    public PostWrote(Post aggregate) {
        super(aggregate);
    }

    public PostWrote() {
        super();
    }
}
//>>> DDD / Domain Event
