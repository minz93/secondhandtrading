package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

//<<< DDD / Domain Event
@Data
@ToString
public class PostEdited extends AbstractEvent {

    private Long postId;
    private String userId;
    private String status;
    private Date createDt;
    private Integer price;
    private Integer likeCnt;
    private String address;
    private String photos;
    private Date updateDt;

    public PostEdited(Post aggregate) {
        super(aggregate);
    }

    public PostEdited() {
        super();
    }
}
//>>> DDD / Domain Event
