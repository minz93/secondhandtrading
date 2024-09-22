package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

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
    private Object photos;
    private Date updateDt;
}
