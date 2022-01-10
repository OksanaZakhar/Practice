import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "Linked_purchaseList")
public class LinkedPurchaseList {

    @EmbeddedId
    private Key id;

    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "keyStudentName", column = @Column(name = "student_name")),
            @AttributeOverride(name = "keyCourseName", column = @Column(name = "course_name"))
    })
    private KeyPurchaseList keyPurchaseList;

    @Column(name = "subscription_date")
    private Date subscriptionDate;

    public LinkedPurchaseList(Key id, KeyPurchaseList keyPurchaseList, Date subscriptionDate) {
        this.id = id;
        this.keyPurchaseList = keyPurchaseList;
        this.subscriptionDate = subscriptionDate;
    }

    public LinkedPurchaseList() {
    }

    public Key getId() {
        return id;
    }

    public void setId(Key id) {
        this.id = id;
    }

    public KeyPurchaseList getKeyPurchaseList() {
        return keyPurchaseList;
    }

    public void setKeyPurchaseList(KeyPurchaseList keyPurchaseList) {
        this.keyPurchaseList = keyPurchaseList;
    }

    public Date getSubscriptionDate() {
        return subscriptionDate;
    }

    public void setSubscriptionDate(Date subscriptionDate) {
        this.subscriptionDate = subscriptionDate;
    }
}
