package net.edu.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import net.edu.domain.StudentCourse;
import net.edu.domain.Subject;



public interface StudentCourseRepository extends JpaRepository<StudentCourse, Long> {
	
	

}
