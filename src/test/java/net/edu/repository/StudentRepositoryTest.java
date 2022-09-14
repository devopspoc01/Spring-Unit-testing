package net.edu.repository;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.annotation.Rollback;

import net.edu.domain.Student;
import net.edu.domain.Subject;


/**
 * @author DELL
 *
 */
@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)
@Rollback(false)
public class StudentRepositoryTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private StudentRepository repo;

    @Autowired
    private SubjectRepository subjectRepository;

    /**
     * used for checking functionality of the student adding into db or not
     */
    @Test
    public void testCreateStudent() {
        Student stu = new Student();
        stu.setName("laxmi");
        stu.setAge(25);
        stu.setAddress("S Nager");

        Student savedStu = repo.save(stu);

        Student existUser = entityManager.find(Student.class, savedStu.getId());

        assertThat(stu.getName()).isEqualTo(existUser.getName());
        assertThat(stu.getAge()).isEqualTo(existUser.getAge());

    }
    
    /**
     * used for checking functionality of the student adding into db or not
     */
    
    @Test
    public void testAddSubjectStudent() {
        Subject  sub = new Subject();
        sub.setSubjectName("phy");
        sub.setMarks(25);
       

        Student existUser = entityManager.find(Student.class,1l);
        sub.setStudentId(existUser);
        Subject savedSub = subjectRepository.save(sub);
        

       

        assertThat(sub.getSubjectName()).isEqualTo(savedSub.getSubjectName());
        assertThat(sub.getMarks()).isEqualTo(savedSub.getMarks());

    }

}
