package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.*;
import lombok.Data;
import secondhandtrading.infra.AbstractEvent;

@Data
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
}
