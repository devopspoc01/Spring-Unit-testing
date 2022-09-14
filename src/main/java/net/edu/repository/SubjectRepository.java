package net.edu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.edu.domain.Subject;



public interface SubjectRepository extends JpaRepository<Subject, Long> {
	
	@Query("select * from Subject s where s.name=?1")
	public Subject findSubectByName(String subjecName);

}
