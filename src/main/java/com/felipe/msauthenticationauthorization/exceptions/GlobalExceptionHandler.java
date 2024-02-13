package com.felipe.msauthenticationauthorization.exceptions;

import com.felipe.msauthenticationauthorization.utils.APIGlobalResponseDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<APIGlobalResponseDTO> handleArgumentNotValidException(MethodArgumentNotValidException ex) {
        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach((error) -> {
            String fieldName = ((FieldError) error).getField();
            String message = error.getDefaultMessage();
            errors.put(fieldName, message);
        });

        var response = new APIGlobalResponseDTO(errors);
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(response);
    }

    @ExceptionHandler({
            FieldAlreadyInUseException.class,
            ResourceNotFoundException.class,
            GroupNotBelongApplicationException.class,
            UserNotBelongApplicationException.class,
            JwtTokenInvalidException.class
    })
    protected ResponseEntity<APIGlobalResponseDTO> handleExceptionsOfTypeBadRequest(RuntimeException ex) {
        return ResponseEntity
                .status(HttpStatus.BAD_REQUEST)
                .body(new APIGlobalResponseDTO(ex.getMessage()));
    }

    @ExceptionHandler(JwtTokenCreationException.class)
    protected ResponseEntity<APIGlobalResponseDTO> handleJwtTokenCreationException(JwtTokenCreationException ex) {
        return ResponseEntity
                .status(HttpStatus.INTERNAL_SERVER_ERROR)
                .body(new APIGlobalResponseDTO(ex.getMessage()));
    }
}
