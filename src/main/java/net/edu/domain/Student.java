package net.edu.domain;

import javax.persistence.*;
import java.util.List;

/**
 * @created Student Entity
 */
@Entity
@Table(name = "student")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(name = "name", nullable = false, length = 20)
	private String name;

	@Column(name = "age", nullable = false, length = 20)
	private Integer age;

	@Column(nullable = false, length = 100)
	private String address;

	// Students can have many subjects , one to many relationship
	@OneToMany(mappedBy = "studentId", fetch = FetchType.EAGER)
	private List<StudentCourse> subjects;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public String getAddress() {
		return address;
	}

	public List<StudentCourse> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<StudentCourse> subjects) {
		this.subjects = subjects;
	}

	public void setAddress(String address) {
		this.address = address;
	}



}
