package toyproject.management.entity;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ChildTest {

    @PersistenceContext private EntityManager em;

    @Test
    @Rollback(value = false)
    void name() {
        Parent parent = new Parent();
        parent.setUsername("parentE");
        em.persist(parent);         // 여기서 부모 객체 생성하고 DB에 저장했으니 1차캐시에 엔티티 저장되어 있을꺼임

        Child child = new Child();
        child.createChild("childE", parent);
        em.persist(child);

    }
}