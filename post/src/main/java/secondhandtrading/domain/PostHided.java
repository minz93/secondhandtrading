package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PostHided extends AbstractEvent {

    private Long postId;
    private String userId;
    private String status;
    private Date createDt;
    private Integer price;
    private Integer likeCnt;
    private String address;
    private String photos;
    private Date updateDt;

    public PostHided(Post aggregate) {
        super(aggregate);
    }

    public PostHided() {
        super();
    }
}
//>>> DDD / Domain Event
