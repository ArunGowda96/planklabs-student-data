package com.planklabs.test.students.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.planklabs.test.students.model.Student;
import com.planklabs.test.students.services.StudentService;

/**
 * Rest controller for exposing two end-points with base URL "planklabs"
 * 1. getStudentById/{studentId}
 * 		Used as GET request to return student for the ID
 * 2. insertStudent
 * 		A POST request to accept the student data in JSON format
 * 
 * @author Arun Kumar
 */
@RestController
@RequestMapping("planklabs")
public class StudentDataController {

	/**
	 * String constant to define content type for requests
	 */
	private static final String STR_APPLICATION_JSON = "application/json";

	// auto-wiring student service, which in turn calls CrudRespository extended by StudentDao
	@Autowired
	StudentService studentService;

	@GetMapping(path = "getStudentById/{studentId}", produces = {STR_APPLICATION_JSON})
	public ResponseEntity<Student> getStudentById(@PathVariable("studentId") Long id) {
		Student s = studentService.findByID(id);
		return new ResponseEntity<>(s, s != null ? HttpStatus.OK : HttpStatus.NOT_FOUND);
	}

	@PostMapping(path = "insertStudent", consumes = {STR_APPLICATION_JSON}, produces = {STR_APPLICATION_JSON})
	public ResponseEntity<Student> insertStudent(@RequestBody Student paramStudent) {
		Student result = studentService.saveStudent(paramStudent);
		return new ResponseEntity<>(result, result != null ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
	}
}
