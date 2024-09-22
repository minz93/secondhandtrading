package secondhandtrading.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import javax.persistence.*;
import lombok.Data;
import secondhandtrading.ProductApplication;
import secondhandtrading.domain.MessagesSent;
import secondhandtrading.domain.PriceNegotiated;
import secondhandtrading.domain.WishlistAdded;
import secondhandtrading.domain.WishlistDeleted;

@Entity
@Table(name = "Product_table")
@Data
//<<< DDD / Aggregate Root
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long posttId;

    private String userId;

    private String status;

    private Integer price;

    private Integer likeCnt;

    private Date createDt;

    private Date updateDt;

    @ElementCollection
    private List<Photos> photos;

    private String address;

    @PostPersist
    public void onPostPersist() {
        MessagesSent messagesSent = new MessagesSent(this);
        messagesSent.publishAfterCommit();

        WishlistAdded wishlistAdded = new WishlistAdded(this);
        wishlistAdded.publishAfterCommit();

        PriceNegotiated priceNegotiated = new PriceNegotiated(this);
        priceNegotiated.publishAfterCommit();

        WishlistDeleted wishlistDeleted = new WishlistDeleted(this);
        wishlistDeleted.publishAfterCommit();
    }

    public static ProductRepository repository() {
        ProductRepository productRepository = ProductApplication.applicationContext.getBean(
            ProductRepository.class
        );
        return productRepository;
    }

    public void sendMessages() {
        //implement business logic here:

        MessagesSent messagesSent = new MessagesSent(this);
        messagesSent.publishAfterCommit();
    }

    public void addWishlist() {
        //implement business logic here:

        WishlistAdded wishlistAdded = new WishlistAdded(this);
        wishlistAdded.publishAfterCommit();
    }

    public void nagotiatePrice() {
        //implement business logic here:

        PriceNegotiated priceNegotiated = new PriceNegotiated(this);
        priceNegotiated.publishAfterCommit();
    }

    public void deleteWishlist() {
        //implement business logic here:

        WishlistDeleted wishlistDeleted = new WishlistDeleted(this);
        wishlistDeleted.publishAfterCommit();
    }
}
//>>> DDD / Aggregate Root
