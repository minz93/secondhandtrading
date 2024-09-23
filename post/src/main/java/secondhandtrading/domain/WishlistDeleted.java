package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

@Data
@ToString
public class WishlistDeleted extends AbstractEvent {

    private Long posttId;
    private String userId;
    private String status;
    private Integer price;
    private Integer likeCnt;
    private Long traderId;
}
