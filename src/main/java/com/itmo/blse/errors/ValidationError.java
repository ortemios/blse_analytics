package com.itmo.blse.errors;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class ValidationError extends Exception{
    List<String> errors;

    @Override
    public String toString(){
        return errors.toString();
    }
}
