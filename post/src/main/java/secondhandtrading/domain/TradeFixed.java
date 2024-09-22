package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

@Data
@ToString
public class TradeFixed extends AbstractEvent {

    private Long postId;
    private Long userId;
    private Long chatId;
    private String status;
    private Date updateDt;
}
