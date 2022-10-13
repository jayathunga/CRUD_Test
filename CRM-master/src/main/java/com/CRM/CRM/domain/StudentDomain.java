package com.CRM.CRM.domain;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="student")
public class StudentDomain {

    @Id
    @Column(name="id")
    @GeneratedValue(generator="system-uuid")
    @GenericGenerator(name="system-uuid", strategy = "uuid")
    private String id;

    @Column(name = "firstname")
    private String firstName;

    @Column(name = "lastname")
    private String lastName;

    @Column(name = "age")
    private int age;

    @Column(name = "birthdate")
    private Date birthDay;

    @Column(name = "mobileNo")
    private String mobile;

    @Column(name = "email")
    private String email;



    public StudentDomain() {

    }



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getBirthDay() {
        return birthDay;
    }

    public void setBirthDay(Date birthDay) {
        this.birthDay = birthDay;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }



    public void merge(StudentDomain request){
        if(request.firstName!=this.firstName && request.firstName!=null && !request.firstName.isEmpty()){
            this.firstName= request.firstName;
        }
        if(request.lastName!=this.lastName && request.lastName!=null && !request.lastName.isEmpty()){
            this.lastName= request.lastName;
        }
        if(request.age!=this.age && !(request.age<=0)){
            this.age= request.age;
        }
        if(request.mobile!=this.mobile && request.mobile!=null && !request.mobile.isEmpty()){
            this.mobile= request.mobile;
        }
        if(request.email!=this.email && request.email!=null && !request.email.isEmpty()){
            this.email= request.email;
        }

    }
}
