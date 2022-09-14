package net.edu.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import net.edu.domain.Student;
import net.edu.domain.StudentCourse;
import net.edu.domain.Subject;
import net.edu.dto.StudentDto;
import net.edu.dto.SubjectDto;
import net.edu.repository.StudentCourseRepository;
import net.edu.repository.StudentRepository;
import net.edu.repository.SubjectRepository;

@Service
public class StudentService {

	@Autowired
	private StudentRepository studentRepository;

	@Autowired
	private SubjectRepository subjectRepository;

	@Autowired
	private StudentCourseRepository studentCourseRepo;

	public Boolean saveStudentWithMarks(StudentDto studentDto) {

		List<SubjectDto> subjects = studentDto.getSubjects();

		Student student = new Student();
		student.setName(studentDto.getName());
		student.setAddress(studentDto.getAddress());
		student.setAge(studentDto.getAge());

		Student savedStudent = studentRepository.save(student);

		Student byId = studentRepository.findById(savedStudent.getId()).get();

		for (SubjectDto item : subjects) {
			StudentCourse studentCourse = new StudentCourse();
			String name = item.getName();
			Subject subectByName = subjectRepository.findSubectByName(name);
			studentCourse.setSubectId(subectByName);
			Integer marks = item.getMarks();
			studentCourse.setMarks(marks);

			studentCourse.setStudentId(byId);
			studentCourseRepo.save(studentCourse);
		}
		return true;
	}

	public List<StudentDto> findAll() {

		List<Student> findAll = studentRepository.findAll();

		return findAll.stream().map(r -> {
			StudentDto dto = new StudentDto();
			dto.setAddress(r.getAddress());
			dto.setName(r.getName());
			dto.setAge(r.getAge());
			return dto;
		}).collect(Collectors.toList());
	}
}
