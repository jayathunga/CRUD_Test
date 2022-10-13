package com.CRM.CRM.repository;

import com.CRM.CRM.domain.StudentDomain;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StudentRepository extends JpaRepository<StudentDomain,String> {
    StudentDomain findByEmail(String email);

    StudentDomain findByMobile(String mobile);

    //List<StudentDomain> findByAge(int age);

}
