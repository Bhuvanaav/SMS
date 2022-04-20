package com.student.sms.service;

import com.student.sms.exception.ErrorMessage;

public class StudentUpdateException extends Exception {
    private static final long serialVersionUID = 1L;
    public StudentUpdateException(String str) {
        ErrorMessage em = new ErrorMessage(0, null, str, null);

        // super(str);
        // TODO Auto-generated constructor stub

    }

}
