package net.edu.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import net.edu.domain.Student;


public interface StudentRepository extends JpaRepository<Student, Long> {

}
