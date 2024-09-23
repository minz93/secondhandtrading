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

    private String userId;

    private String status;

    private Date createDt;

    private Integer price;

    private Integer likeCnt;

    private String address;

    @ElementCollection
    private List<String> photos;

    private Date updateDt;

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
        //implement business logic here:

        /** Example 1:  new item 
        Post post = new Post();
        repository().save(post);

        StatusUpdated statusUpdated = new StatusUpdated(post);
        statusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(tradeEnded.get???()).ifPresent(post->{
            
            post // do something
            repository().save(post);

            StatusUpdated statusUpdated = new StatusUpdated(post);
            statusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(TradeFixed tradeFixed) {
        //implement business logic here:

        /** Example 1:  new item 
        Post post = new Post();
        repository().save(post);

        StatusUpdated statusUpdated = new StatusUpdated(post);
        statusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(tradeFixed.get???()).ifPresent(post->{
            
            post // do something
            repository().save(post);

            StatusUpdated statusUpdated = new StatusUpdated(post);
            statusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateStatus(TradeCanceled tradeCanceled) {
        //implement business logic here:

        /** Example 1:  new item 
        Post post = new Post();
        repository().save(post);

        StatusUpdated statusUpdated = new StatusUpdated(post);
        statusUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(tradeCanceled.get???()).ifPresent(post->{
            
            post // do something
            repository().save(post);

            StatusUpdated statusUpdated = new StatusUpdated(post);
            statusUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikecnt(WishlistAdded wishlistAdded) {
        //implement business logic here:

        /** Example 1:  new item 
        Post post = new Post();
        repository().save(post);

        LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
        likeCntUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(wishlistAdded.get???()).ifPresent(post->{
            
            post // do something
            repository().save(post);

            LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
            likeCntUpdated.publishAfterCommit();

         });
        */

    }

    //>>> Clean Arch / Port Method
    //<<< Clean Arch / Port Method
    public static void updateLikecnt(WishlistDeleted wishlistDeleted) {
        //implement business logic here:

        /** Example 1:  new item 
        Post post = new Post();
        repository().save(post);

        LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
        likeCntUpdated.publishAfterCommit();
        */

        /** Example 2:  finding and process
        
        repository().findById(wishlistDeleted.get???()).ifPresent(post->{
            
            post // do something
            repository().save(post);

            LikeCntUpdated likeCntUpdated = new LikeCntUpdated(post);
            likeCntUpdated.publishAfterCommit();

         });
        */

    }
    //>>> Clean Arch / Port Method

}
//>>> DDD / Aggregate Root
