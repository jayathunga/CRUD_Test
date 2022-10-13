package com.CRM.CRM.service;

import com.CRM.CRM.domain.StudentDomain;

import java.util.List;

public interface StudentService {
    StudentDomain createStudent(StudentDomain studentDomain);

    StudentDomain getStudentByID(String id);

    List<StudentDomain> getAllStudents();

    StudentDomain updateStudent(String id,StudentDomain studentDomain);

    void deleteStudent(String id);
}
