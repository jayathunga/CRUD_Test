package com.CRM.CRM.service.validation;

public interface Message {

    public static final String INVALID_FIRST_NAME="first name must not be null or empty";
    public static final String INVALID_LAST_NAME = "last name must not be null or empty";
    public static final String INVALID_AGE = "student age is invalid";
    public static final String INVALID_DATE="student birthday is invalid";
    public static final String INVALID_DATE_TIME_FORMAT="Invalid date time format";
    public static final String INVALID_MOBILE_NUMBER="Invalid mobile number";
    public static final String INVALID_EMAIL_ADDRESS="Invalid email address";
    public static final String ALREADY_EXISTED_EMAIL_ADDRESS="Email address is already existed in database";
    public static final String ALREADY_EXISTED_MOBILE_NUMBER="Mobile number is already existed";
}
