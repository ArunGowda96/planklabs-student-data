package com.planklabs.test.students.services;

import com.planklabs.test.students.model.Student;

public interface StudentService {
	public Student findByID(Long id);
	public Student saveStudent(Student s);
}
