package com.CRM.CRM.service.validation;

import com.CRM.CRM.domain.StudentDomain;
import org.springframework.util.Assert;

import java.text.SimpleDateFormat;
import java.util.Date;

public class StudentValidator {
    private static final String DateTimeFormat="yyyy-MM-dd 'T' HH:mm:ss 'Z'";
    private static final String MobileNumberPattern="[0-9]{10}";
    //private static final String EmailAddressPattern="^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\\\.[A-Z]{2,6}$";


    public static void validateCreateStudentRequest(StudentDomain createRequest){
        Assert.hasText(createRequest.getFirstName(), Message.INVALID_FIRST_NAME);
        Assert.hasText(createRequest.getLastName(), Message.INVALID_LAST_NAME);
        Assert.isTrue(isAgeValid(createRequest.getAge()), Message.INVALID_AGE);
        Assert.isTrue(isDateValid(createRequest.getBirthDay()), Message.INVALID_DATE);
        Assert.isTrue(isValidDateTimeFormat(createRequest.getBirthDay()), Message.INVALID_DATE_TIME_FORMAT);
        Assert.isTrue(isValidMobile(createRequest.getMobile()), Message.INVALID_MOBILE_NUMBER);
        //Assert.isTrue(isValidEmailAddress(createRequest.getEmail()),ResponseMessage.INVALID_EMAIL_ADDRESS);

    }

    private static boolean isAgeValid(int age){
        boolean isValidAge=true;
        if(age<0){
            isValidAge=false;
        }
        if(!(age>=18 || age<=24)){
            isValidAge=false;
        }
        return isValidAge;
    }

    private static boolean isDateValid(Date date){
        return date.before(new Date());
    }

    private static boolean isValidDateTimeFormat(Date date) {
        boolean isDateTimeValidation = true;
        if (date == null) {
            isDateTimeValidation = false;
        }
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat(DateTimeFormat);
        try {
            simpleDateFormat.format(date);
        } catch (Exception ex) {
             isDateTimeValidation = false;
        }
        return isDateTimeValidation;

    }

    private static boolean isValidMobile(String mobileNumber){

        return mobileNumber.matches(MobileNumberPattern);
    }

//    private static boolean isValidEmailAddress(String email){
//        return email.matches(EmailAddressPattern);
//    }

    public static void validateUpdateRequest(String id,StudentDomain updateRequest){
        Assert.hasText(updateRequest.getFirstName(), Message.INVALID_FIRST_NAME);
        Assert.hasText(updateRequest.getLastName(), Message.INVALID_LAST_NAME);
        Assert.isTrue(isAgeValid(updateRequest.getAge()), Message.INVALID_AGE);
        Assert.isTrue(isDateValid(updateRequest.getBirthDay()), Message.INVALID_DATE);
        Assert.isTrue(isValidDateTimeFormat(updateRequest.getBirthDay()), Message.INVALID_DATE_TIME_FORMAT);
        Assert.isTrue(isValidMobile(updateRequest.getMobile()), Message.INVALID_MOBILE_NUMBER);

    }
}
