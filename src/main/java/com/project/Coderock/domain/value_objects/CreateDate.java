package com.project.Coderock.domain.value_objects;


import com.project.Coderock.domain.Exceptions.InvalidParamError;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateDate {
    private String create_date;

    public CreateDate() {

    }

    private CreateDate(String create_date) {
        this.create_date = create_date;
    }

    public static CreateDate validateDate(String create_date) throws Exception {
        if (!create_date.matches("\\d{2}/\\d{2}/\\d{4}")) {
            throw new InvalidParamError("Date Format invalid. Use DD/MM/AAAA");
        }

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        sdf.setLenient(false);

        Date inputDate;
        try {
            inputDate = sdf.parse(create_date);
        } catch (ParseException e) {
            throw new InvalidParamError("Invalid date");
        }

        if (inputDate.after(new Date())) {
            throw new InvalidParamError("Can not be a future date");
        }

        return new CreateDate(create_date);
    }
    public static CreateDate restore(String create_date){
        return new CreateDate(create_date);
    }

    public String getCreate_date() {
        return create_date;
    }
}

