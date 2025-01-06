package com.crudclient.client.dto;

import java.time.Instant;
import java.util.ArrayList;
import java.util.List;

public class ValidationError  extends CustomError{

    private List<FieldMessage> erros = new ArrayList<>();

    public ValidationError(Instant timestamp, Integer status, String error, String path) {
        super(timestamp, status, error, path);
    }

    public List<FieldMessage> getErrors() {
        return erros;
    }

    public void addError(String fieldName, String message){
        erros.add(new FieldMessage(fieldName, message));
    }
}
