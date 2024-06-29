package com.project.Coderock.domain.value_objects;


import com.project.Coderock.domain.Exceptions.InvalidParamError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;

public class CreateDate {
    private LocalDate create_date;

    public CreateDate() {

    }

    public CreateDate(String create_date) throws Exception {
        this.create_date = this.validateDate(create_date);
    }

    private LocalDate validateDate(String create_date) throws Exception {
        if (!create_date.matches("\\d{4}-\\d{2}-\\d{2}")) {
            throw new InvalidParamError("Date Format invalid. Use YYYY-MM-DD");
        }

        LocalDate dateNow = LocalDate.now();
        LocalDate inputDate = LocalDate.parse(create_date);

        if (inputDate.isAfter(dateNow)) {
            throw new InvalidParamError("Can not be a future date");
        }

        return inputDate;
    }


    public LocalDate getCreate_date() {
        return create_date;
    }
}

