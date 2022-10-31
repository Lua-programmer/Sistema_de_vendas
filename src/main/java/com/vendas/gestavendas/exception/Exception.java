package com.vendas.gestavendas.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@ControllerAdvice
public class Exception extends ResponseEntityExceptionHandler {
    private static final String CONSTANT_VALIDATION_NOT_BLANK = "NotBlank";
    private static final String CONSTANT_VALIDATION_LENGTH = "Length";

    @Override
    protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex, HttpHeaders headers, HttpStatus status, WebRequest request) {

        List<Errors> errors = errorsList(ex.getBindingResult());

        return handleExceptionInternal(ex, errors, headers, HttpStatus.BAD_REQUEST, request);
    }

    @ExceptionHandler(MethodArgumentTypeMismatchException.class)
    public ResponseEntity<Object> handleMethodArgumentTypeMismatchException(MethodArgumentTypeMismatchException ex, WebRequest request) {
        String msgUser = "Code not found";
        String msgServer = ex.toString();

        List<Errors> errors = Arrays.asList(new Errors(msgUser, msgServer));
        return handleExceptionInternal(ex, errors, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
    }

    private List<Errors> errorsList(BindingResult bindingResult) {
        List<Errors> errorsList = new ArrayList<>();

        bindingResult.getFieldErrors().forEach(fieldErrors -> {
            String msgUser = handleUserErrorMessage(fieldErrors);
            String msgServer = fieldErrors.toString();
            errorsList.add(new Errors(msgUser, msgServer));
        });

        return errorsList;
    }

    private String handleUserErrorMessage(FieldError fieldErrors) {
        if (fieldErrors.getCode().equals(CONSTANT_VALIDATION_NOT_BLANK)) {
            return fieldErrors.getDefaultMessage().concat(" é obrigatório.");
        }
        if (fieldErrors.getCode().equals(CONSTANT_VALIDATION_LENGTH)) {
            return fieldErrors.getDefaultMessage().concat(String.format(" deve ter entre %s e %s caracteres", fieldErrors.getArguments()[2], fieldErrors.getArguments()[1]));
        }
        return fieldErrors.toString();
    }
}
