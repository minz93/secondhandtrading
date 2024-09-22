package secondhandtrading.domain;

import java.util.*;
import lombok.*;
import secondhandtrading.domain.*;
import secondhandtrading.infra.AbstractEvent;

@Data
@ToString
public class MessagesSent extends AbstractEvent {

    private Long chatId;
    private Long postId;
    private String userId;
    private String sellerUserId;
}
