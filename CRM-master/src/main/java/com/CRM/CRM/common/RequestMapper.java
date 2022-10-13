package com.CRM.CRM.common;

public interface RequestMapper {
    public static final String CREATE_STUDENT="/student";

    public static final String RETRIEVE_STUDENT="/getStudent/{id}";

    public static final String RETRIEVE_ALL_STUDENTS="/getAllStudents";

    public static final String UPDATE_STUDENT="/updateStudent/{id}";

    public static final String DELETE_STUDENT="/deleteStudent/{id}";
}
