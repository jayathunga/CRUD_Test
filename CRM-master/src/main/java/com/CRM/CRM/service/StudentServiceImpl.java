package com.CRM.CRM.service;

import com.CRM.CRM.domain.StudentDomain;
import com.CRM.CRM.repository.StudentRepository;
import com.CRM.CRM.service.validation.Message;
import com.CRM.CRM.service.validation.StudentValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public StudentDomain createStudent(StudentDomain studentDomain) {
        StudentValidator.validateCreateStudentRequest(studentDomain);

        //check whether email address are same
        StudentDomain existingStudent=studentRepository.findByEmail(studentDomain.getEmail());
        Assert.isNull(existingStudent, Message.ALREADY_EXISTED_EMAIL_ADDRESS);

        //check whether mobile numbers are same
        existingStudent=studentRepository.findByMobile(studentDomain.getMobile());
        Assert.isNull(existingStudent,Message.ALREADY_EXISTED_MOBILE_NUMBER);
        return studentRepository.save(studentDomain);
    }

    @Override
    public StudentDomain getStudentByID(String id) {

        return studentRepository.findById(id).orElse(null);
    }

    @Override
    public List<StudentDomain> getAllStudents() {

        return studentRepository.findAll();
    }

    @Override
    public StudentDomain updateStudent(String id, StudentDomain studentDomain) {
        //StudentValidator.validateUpdateRequest(id,studentDomain);
        StudentDomain existingStudent=studentRepository.findById(id).orElse(null);
        if(existingStudent!=null){
            existingStudent.merge(studentDomain);
        }
        return studentRepository.save(existingStudent);
    }

    @Override
    public void deleteStudent(String id) {
        try {
           studentRepository.deleteById(id);
        }catch (Exception e){
            System.out.println(e);
        }
    }
}
