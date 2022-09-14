package net.edu.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import net.edu.dto.StudentDto;
import net.edu.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	/**
	 * @param student
	 * @adding student in JSON format
	 * @returning status of response
	 */
	@PostMapping(path = "/addStudent", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)

	public ResponseEntity<Map<String, String>> addStudent(@RequestBody StudentDto student) {

		Boolean saveStudentWithMarks = studentService.saveStudentWithMarks(student);
		Map<String, String> responseMap = new HashMap<>();
		responseMap.put("saved", String.valueOf(saveStudentWithMarks));
		responseMap.put("message", "Student saved successfully");

		return ResponseEntity.ok().body(responseMap);
	}

	/**
	 * @return status of response
	 */
	@GetMapping("/listStudents")
	public ResponseEntity<List<StudentDto>> listStudent() {

		List<StudentDto> allStudents = studentService.findAll();
		return ResponseEntity.ok().body(allStudents);
	}

	/**
	 * @param id
	 * @return status of response
	 */
	/*
	 * @GetMapping("/student/{id}") public ResponseEntity<StudentDto>
	 * getStudentById(@PathVariable Long id) { StudentDto findById =
	 * studentService.findStdentById(id); return ResponseEntity.ok().body(findById);
	 * }
	 */

}
