package com.planklabs.test.students.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.planklabs.test.students.dao.StudentDao;
import com.planklabs.test.students.model.Student;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	StudentDao dao;

	@Override
	public Student findByID(Long id) {
		Optional<Student> optional = dao.findById(id);
		return optional.isPresent() ? optional.get() : null;
	}

	@Override
	public Student saveStudent(Student s) {
		return null != s ? dao.save(s) : null;
	}
}
