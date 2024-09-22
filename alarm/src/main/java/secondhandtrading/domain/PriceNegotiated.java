package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

@Data
@ToString
public class PriceNegotiated extends AbstractEvent {

    private Long posttId;
    private String userId;
    private Integer price;
    private String sellerUserId;
    private Integer negoPrice;
}
