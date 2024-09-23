package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import secondhandtrading.infra.AbstractEvent;

@Data
public class PostWrote extends AbstractEvent {

    private Long postId;
    private String userId;
    private Date createDt;
    private Integer price;
    private Integer likeCnt;
    private String address;
    private String photos;
    private String status;
}
