package com.CRM.CRM.dto;

import com.CRM.CRM.domain.StudentDomain;

import java.util.List;

public class StudentsResponse {
    private List<StudentResponse>studentDomainList;

    public List<StudentResponse> getStudentDomainList() {

        return studentDomainList;
    }

    public void setStudentDomainList(List<StudentResponse> studentDomainList) {
        this.studentDomainList = studentDomainList;
    }
}
