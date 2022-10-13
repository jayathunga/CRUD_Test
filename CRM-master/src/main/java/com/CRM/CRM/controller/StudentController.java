package com.CRM.CRM.controller;

import com.CRM.CRM.common.RequestMapper;
import com.CRM.CRM.domain.StudentDomain;
import com.CRM.CRM.dto.CreateStudentRequest;
import com.CRM.CRM.dto.StudentResponse;
import com.CRM.CRM.dto.StudentsResponse;
import com.CRM.CRM.dto.UpdateStudentRequest;
import com.CRM.CRM.service.StudentService;
import com.CRM.CRM.transformers.StudentTransformer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class StudentController {

    @Autowired
    private StudentService studentService;

    //create a student
    @RequestMapping(value = RequestMapper.CREATE_STUDENT,method = RequestMethod.POST,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.CREATED)
    public @ResponseBody StudentResponse create(@RequestBody CreateStudentRequest createStudentRequest){
        StudentDomain studentDomain = StudentTransformer.createStudentRequestToDomain(createStudentRequest);
        StudentDomain createdStudentDomain =studentService.createStudent(studentDomain);
        return StudentTransformer.studentDomainToResponse(createdStudentDomain);
    }

    //read a student by ID
    @RequestMapping(value = RequestMapper.RETRIEVE_STUDENT,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody StudentResponse getStudent(@PathVariable String id){
        StudentDomain studentDomain =studentService.getStudentByID(id);
        StudentResponse response=StudentTransformer.studentDomainToResponse(studentDomain);
        return response;

    }

    //read all student
    @RequestMapping(value =RequestMapper.RETRIEVE_ALL_STUDENTS,method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody StudentsResponse getAllStudents(){
        List<StudentDomain> studentDomain=studentService.getAllStudents();
        List<StudentResponse> response=StudentTransformer.studentDomainListToResponseList(studentDomain);
        StudentsResponse responseList=new StudentsResponse();
        responseList.setStudentDomainList(response);
        return responseList;

    }

    //update student by ID
    @RequestMapping(value = RequestMapper.UPDATE_STUDENT,method = RequestMethod.PUT,produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.OK)
    public @ResponseBody StudentResponse updateStudent(@PathVariable String id, @RequestBody UpdateStudentRequest updateStudentRequest){
        StudentDomain studentDomain=StudentTransformer.updateStudentRequestToDomain(updateStudentRequest);
        StudentDomain updatedStudentDomain=studentService.updateStudent(id,studentDomain);
        return StudentTransformer.studentDomainToResponse(updatedStudentDomain);

    }

    //delete student by id
    @RequestMapping(value = RequestMapper.DELETE_STUDENT,method = RequestMethod.DELETE)
    @ResponseStatus(HttpStatus.OK)
    public void deleteStudent(@PathVariable String id){
        studentService.deleteStudent(id);



    }

}
