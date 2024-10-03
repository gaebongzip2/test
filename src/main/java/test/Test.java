package test;

import javafx.application.Application;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import test.entity.TestDto;
import test.fx.AppFx;
import test.jframe.AppJFrame;
import test.util.HibernateUtil;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import java.util.List;

public class Test {


    public static void main(String[] args) {
        System.out.println("start");

        //Application.launch(AppFx.class, args);
        //new AppJFrame().gui();

        //SessionFactory sessionFactory = HibernateUtil.getSessionFactory();
        //Session session = sessionFactory.getCurrentSession();
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test");
        // hello 설정파일 설정정보, Persistence.xml 에서 <persistence-unit name="hello"> 이부분

        EntityManager em = emf.createEntityManager();
        // db 작업은 EntityManager 로함

        EntityTransaction tx = em.getTransaction();
        // 모든 변경은 트랜잭션 안에서만 해야한다.

        tx.begin();

        try {

            var test = new TestDto("aaa", "bbb", "ccc");
            em.persist(test);
            test = new TestDto("aaa", "bbb", "ccc");
            em.persist(test);
            test = new TestDto("aaa", "bbb", "ccc");
            em.persist(test);
            test = new TestDto("aaa", "bbb", "ccc");
            em.persist(test);

            tx.commit();
            //List<TestDto> list = (List<TestDto>)em.createQuery("from TestDto", TestDto.class).getResultList();
            CriteriaBuilder cb = em.getCriteriaBuilder();
            CriteriaQuery<TestDto> cq = cb.createQuery(TestDto.class);
            cq.select(cq.from(TestDto.class));
            List<TestDto> list = (List<TestDto>) em.createQuery(cq).getResultList();
            System.out.println("list : " + list.toString());
        } catch(Exception e) {
            tx.rollback();
        } finally {
            em.close();  // EntityManager 닫기
            emf.close();  // EntityManagerFactory 닫기
        }

        System.out.println("end");
    }
}
