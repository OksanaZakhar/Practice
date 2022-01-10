import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;
import java.util.HashMap;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure("hibernate.cfg.xml").build();
        Metadata metadata = new MetadataSources(registry)
                .getMetadataBuilder().build();
        SessionFactory sessionFactory = metadata
                .getSessionFactoryBuilder().build();

        Session session = sessionFactory.openSession();

        CriteriaBuilder builder = session.getCriteriaBuilder();
        CriteriaQuery<Subscription> cq = builder.createQuery(Subscription.class);
        Root<Subscription> rootEntry = cq.from(Subscription.class);
        CriteriaQuery<Subscription> all = cq.select(rootEntry);

        TypedQuery<Subscription> allQuery = session.createQuery(all);
        List<Subscription> subscriptions = allQuery.getResultList();

        HashMap<String, Integer> studentMap = new HashMap<>();
        HashMap<String, Integer> courseMap = new HashMap<>();

        for (Subscription s : subscriptions) {
            studentMap.put(s.getStudentId().getName(), s.getStudentId().getId());
            courseMap.put(s.getCourseId().getName(), s.getCourseId().getId());
        }

        CriteriaBuilder builder1 = session.getCriteriaBuilder();
        CriteriaQuery<PurchaseList> cq1 = builder1.createQuery(PurchaseList.class);
        Root<PurchaseList> rootEntry1 = cq1.from(PurchaseList.class);
        CriteriaQuery<PurchaseList> all1 = cq1.select(rootEntry1);

        TypedQuery<PurchaseList> allQuery1 = session.createQuery(all1);
        List<PurchaseList> purchaseLists = allQuery1.getResultList();

        try {
            Transaction transaction = session.beginTransaction();
            for (PurchaseList p : purchaseLists) {
                LinkedPurchaseList linkedPurchaseList = new LinkedPurchaseList();
                linkedPurchaseList.setId(new Key(studentMap.get(p.getKeyPurchaseList().getKeyStudentName()), courseMap.get(p.getKeyPurchaseList().getKeyCourseName())));
                linkedPurchaseList.setKeyPurchaseList(new KeyPurchaseList(p.getKeyPurchaseList().getKeyStudentName(), p.getKeyPurchaseList().getKeyCourseName()));
                linkedPurchaseList.setSubscriptionDate(p.getSubscriptionDate());

                session.save(linkedPurchaseList);
            }
            transaction.commit();
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
            ex.printStackTrace();
        }


//        Часть от предыдущего ДЗ 14.1
//        Transaction transaction = session.getTransaction();
//        Course course = session.get(Course.class, 1);
//        System.out.println(course.getTeacher().getName());
//        System.out.println(course.getStudents().size());
//
//        List<Student> studentList = course.getStudents();
//        studentList.forEach(System.out::println);
//        studentList.forEach(student -> System.out.println(student.getName()));
//        for (Student student : studentList) {
//            System.out.println(student.getName());
//        }
//
//        Subscription subscription = session.get(Subscription.class, new Key(1, 2));
//        System.out.println(subscription.getCourseId().getStudents().size());


//        Часть от предыдущего ДЗ
//        for (int i = 1; i <= 45; i++) {
//            Course course = session.get(Course.class, i);
//            System.out.println("№ " + i + " Курс: " + course.getName() + "  Количество студентов - " + course.getStedentCount());
//        }
//
//        List<Course> courses = session.createQuery("SELECT a FROM Course a", Course.class).getResultList();

//        CriteriaBuilder cb = session.getCriteriaBuilder();
//        CriteriaQuery<Course> cq = cb.createQuery(Course.class);
//        Root<Course> rootEntry = cq.from(Course.class);
//        CriteriaQuery<Course> all = cq.select(rootEntry);
//
//        TypedQuery<Course> allQuery = session.createQuery(all);
//        List<Course> courses = allQuery.getResultList();

        sessionFactory.close();

    }
}
