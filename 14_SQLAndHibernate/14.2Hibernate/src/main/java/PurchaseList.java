import javax.persistence.*;
import java.util.Date;

@Entity
public class PurchaseList {
    @Id
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "keyStudentName", column = @Column(name = "student_name")),
            @AttributeOverride(name = "keyCourseName", column = @Column(name = "course_name"))
    })
    private KeyPurchaseList keyPurchaseList;


    public KeyPurchaseList getKeyPurchaseList() {
        return keyPurchaseList;
    }

    public void setKeyPurchaseList(KeyPurchaseList keyPurchaseList) {
        this.keyPurchaseList = keyPurchaseList;
    }

    private int price;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }


}
