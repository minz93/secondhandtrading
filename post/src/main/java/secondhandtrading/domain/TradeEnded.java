package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

@Data
@ToString
public class TradeEnded extends AbstractEvent {

    private Long postId;
    private String userId;
    private Long chatId;
    private String status;
    private Date updateDt;
}
