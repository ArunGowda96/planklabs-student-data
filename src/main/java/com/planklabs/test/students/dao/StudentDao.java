package com.planklabs.test.students.dao;

import org.springframework.data.repository.CrudRepository;

import com.planklabs.test.students.model.Student;

public interface StudentDao extends CrudRepository<Student, Long> {
}
