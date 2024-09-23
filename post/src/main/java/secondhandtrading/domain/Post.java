package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import secondhandtrading.PostApplication;
import secondhandtrading.domain.LikeCntUpdated;
import secondhandtrading.domain.PostDeleted;
import secondhandtrading.domain.PostEdited;
import secondhandtrading.domain.PostHided;
import secondhandtrading.domain.PostWrote;
import secondhandtrading.domain.StatusUpdated;

@Entity
@Table(name = "Post_table")
@Data
//<<< DDD / Aggregate Root
public class Post {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long postId;

    private Long userId;

    private String status;

    private Date createDt;

    private Integer price;

    private Integer likeCnt;

    private String address;

    @ElementCollection
    private List<String> photos;

    private Date updateDt;

    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public Long getPostId() {
        return postId;
    }
    public void setPostId(Long postId) {
        this.postId = postId;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public int getLikeCnt() {
        return likeCnt;
    }
    public void setLikeCnt(int likeCnt) {
        this.likeCnt = likeCnt;
    }

    @PostPersist
    public void onPostPersist() {
        PostWrote postWrote = new PostWrote(this);
        postWrote.publishAfterCommit();

        PostEdited postEdited = new PostEdited(this);
        postEdited.publishAfterCommit();

        PostDeleted postDeleted = new PostDeleted(this);
        postDeleted.publishAfterCommit();

        PostHided postHided = new PostHided(this);
        postHided.publishAfterCommit();

        LikeCntUpdated likeCntUpdated = new LikeCntUpdated(this);
        likeCntUpdated.publishAfterCommit();
    }

    @PostUpdate
    public void onPostUpdate() {
        StatusUpdated statusUpdated = new StatusUpdated(this);
        statusUpdated.publishAfterCommit();
    }

    public static PostRepository repository() {
        PostRepository postRepository = PostApplication.applicationContext.getBean(
            PostRepository.class
        );
        return postRepository;
    }

    public void writePost() {
        //implement business logic here:

        PostWrote postWrote = new PostWrote(this);
        postWrote.setStatus("Created");
        postWrote.publishAfterCommit();
    }

    public void editPost() {
        //implement business logic here:

        PostEdited postEdited = new PostEdited(this);
        postEdited.publishAfterCommit();
    }

    public void deletePost() {
        //implement business logic here:

        PostDeleted postDeleted = new PostDeleted(this);
        postDeleted.publishAfterCommit();
    }

    public void hidePost() {
        //implement business logic here:

        PostHided postHided = new PostHided(this);
        postHided.publishAfterCommit();
    }

    //<<< Clean Arch / Port Method
    public static void updateStatus(TradeEnded tradeEnded) {
        repository().findById(Long.valueOf(tradeEnded.getPostId())).ifPresent(post->{
            post.setStatus("TradeEnded"); // do something
            repository().save(post);
        });
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(TradeFixed tradeFixed) {
       repository().findById(Long.valueOf(tradeFixed.getPostId())).ifPresent(post->{
            post.setStatus("TradeReserved"); // do something
            repository().save(post);
        });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(TradeCanceled tradeCanceled) {
        repository().findById(Long.valueOf(tradeCanceled.getPostId())).ifPresent(post->{
            post.setStatus("Created"); // do something
            repository().save(post);
        });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(PostHided postHided) {
        repository().findById(Long.valueOf(postHided.getPostId())).ifPresent(post->{
            post.setStatus("PostHided"); // do something
            repository().save(post);
        });

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikecnt(WishlistAdded wishlistAdded) {

        repository().findById(Long.valueOf(wishlistAdded.getPostId())).ifPresent(post->{
            if(post.getUserId() == wishlistAdded.getUserId() & post.getLikeCnt() == 0) {
                post.setLikeCnt(post.getLikeCnt() + 1);
                repository().save(post);
            } else {
                post.setLikeCnt(post.getLikeCnt() - 1);
                repository().save(post);
            }
        
            LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
            likeCntUpdated.publishAfterCommit();
        });
    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikecnt(WishlistDeleted wishlistDeleted) {
        repository().findById(Long.valueOf(WishlistDeleted.getPostId())).ifPresent(post->{
            if(post.getUserId() == WishlistDeleted.getUserId() & post.getLikeCnt() >= 1) {
                post.setLikeCnt(post.getLikeCnt() - 1);
                repository().save(post);
            } else {
                post.setLikeCnt(post.getLikeCnt() + 1);
                repository().save(post);
            }

            LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
            likeCntUpdated.publishAfterCommit();

        });

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
