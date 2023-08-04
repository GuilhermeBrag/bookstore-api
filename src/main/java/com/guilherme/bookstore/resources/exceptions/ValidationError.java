package com.guilherme.bookstore.resources.exceptions;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@Getter
public class ValidationError extends StandardError{

    private List<FieldMessage> errors = new ArrayList<>();

    public ValidationError(Long timesTemp, Integer status, String error) {
        super(timesTemp, status, error);
    }


    public void addErrors(String fieldMessage, String message) {
        this.errors.add(new FieldMessage(fieldMessage,message));
    }
}
