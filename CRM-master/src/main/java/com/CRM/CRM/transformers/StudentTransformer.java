package com.CRM.CRM.transformers;

import com.CRM.CRM.domain.StudentDomain;
import com.CRM.CRM.dto.CreateStudentRequest;
import com.CRM.CRM.dto.StudentResponse;
import com.CRM.CRM.dto.UpdateStudentRequest;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

public final class StudentTransformer {

    private StudentTransformer(){

    }

    public static StudentDomain createStudentRequestToDomain(CreateStudentRequest createRequest){
        StudentDomain target=new StudentDomain();
        BeanUtils.copyProperties(createRequest,target);
        return target;
    }

    public static StudentResponse studentDomainToResponse(StudentDomain studentDomain){
        StudentResponse target=new StudentResponse();
        BeanUtils.copyProperties(studentDomain,target);
        return target;
    }

    public static List<StudentResponse> studentDomainListToResponseList(List<StudentDomain>studentDomainList){
        List<StudentResponse> targetList=new ArrayList<StudentResponse>();
        for (StudentDomain studentDomain:studentDomainList){
            StudentResponse studentResponse=studentDomainToResponse(studentDomain);
            targetList.add(studentResponse);
        }
        return targetList;

    }

    public static StudentDomain updateStudentRequestToDomain(UpdateStudentRequest updateStudentRequest){
        StudentDomain target=new StudentDomain();
        target.setFirstName(updateStudentRequest.getFirstName());
        target.setLastName(updateStudentRequest.getLastName());
        target.setAge(updateStudentRequest.getAge());
        target.setMobile(updateStudentRequest.getMobile());
        target.setEmail(updateStudentRequest.getEmail());
        return target;

    }
}
