import javax.persistence.Embeddable;
import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class KeyPurchaseList implements Serializable {

    public KeyPurchaseList(String keyStudentName, String keyCourseName) {
        this.keyStudentName = keyStudentName;
        this.keyCourseName = keyCourseName;
    }

    public KeyPurchaseList() {
    }

    private String keyStudentName;

    private String keyCourseName;

    public String getKeyStudentName() {
        return keyStudentName;
    }

    public void setKeyStudentName(String keyStudentName) {
        this.keyStudentName = keyStudentName;
    }

    public String getKeyCourseName() {
        return keyCourseName;
    }

    public void setKeyCourseName(String keyCourseName) {
        this.keyCourseName = keyCourseName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        KeyPurchaseList that = (KeyPurchaseList) o;
        return Objects.equals(keyStudentName, that.keyStudentName) && Objects.equals(keyCourseName, that.keyCourseName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(keyStudentName, keyCourseName);
    }
}
