package net.edu.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

/**
 * @created an Entity class Subject
 */
@Entity
@Table(name = "student_course")
public class StudentCourse {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@OneToOne
	@Column(name = "subject_id", nullable = false)
	private Subject subectId;

	@Column(name = "marks", nullable = false, length = 20)
	private Integer marks;

	@ManyToOne
	@JoinColumn(name = "student_id", nullable = false)
	private Student studentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Subject getSubectId() {
		return subectId;
	}

	public void setSubectId(Subject subectId) {
		this.subectId = subectId;
	}

	public Student getStudentId() {
		return studentId;
	}

	public void setStudentId(Student studentId) {
		this.studentId = studentId;
	}

	public Integer getMarks() {
		return marks;
	}

	public void setMarks(Integer marks) {
		this.marks = marks;
	}

}
