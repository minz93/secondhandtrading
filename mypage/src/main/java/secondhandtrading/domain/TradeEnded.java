package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import secondhandtrading.infra.AbstractEvent;

@Data
public class TradeEnded extends AbstractEvent {

    private Long postId;
    private Long userId;
    private Long chatId;
    private String status;
    private Date updateDt;
}
