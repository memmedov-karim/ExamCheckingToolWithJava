package com.example.ExamCheckingTool.exception;

import com.example.ExamCheckingTool.dto.ErrorResponseDto;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    public ResponseEntity<ErrorResponseDto> handleNotFoundException(
            NotFoundException ex, WebRequest request) {
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Resource not found: " + ex.getMessage());
        errorDto.setStatus(HttpStatus.NOT_FOUND.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorDto);
    }
    @ExceptionHandler(AlreadyExistException.class)
    public ResponseEntity<ErrorResponseDto> handleAlreadyExistsException(
            AlreadyExistException ex, WebRequest request) {
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Resource already exists: " + ex.getMessage());
        errorDto.setStatus(HttpStatus.CONFLICT.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.CONFLICT).body(errorDto);
    }
    @ExceptionHandler(HibernateValidationException.class)
    public ResponseEntity<ErrorResponseDto> handleHibernateValidationException(HibernateValidationException ex,WebRequest request0){
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Hibernate validation error:"+ex.getMessage());
        errorDto.setStatus(HttpStatus.BAD_REQUEST.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorDto);
    }
    @ExceptionHandler(CookiesNotFoundInRequestException.class)
    public ResponseEntity<ErrorResponseDto> handleCookiesNotFoundInRequestException(Exception ex,WebRequest request){
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Cookies not found in request" + ex.getMessage());
        errorDto.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
    }
    @ExceptionHandler(TokenNotFoundInCookiesException.class)
    public ResponseEntity<ErrorResponseDto> handleTokenNotFoundInCookiesException(Exception ex,WebRequest request){
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Token not found in cookies" + ex.getMessage());
        errorDto.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
    }
    @ExceptionHandler(PasswordIsNotCorrectException.class)
    public ResponseEntity<ErrorResponseDto> handlePasswordIsNotCorrectException(Exception ex,WebRequest request){
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Password is not correct" + ex.getMessage());
        errorDto.setStatus(HttpStatus.UNAUTHORIZED.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(errorDto);
    }
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponseDto> handleOtherException(Exception ex,WebRequest request){
        ErrorResponseDto errorDto = new ErrorResponseDto();
        errorDto.setMessage("Internal server error: " + ex.getMessage());
        errorDto.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
        errorDto.setTimestamp(LocalDateTime.now());
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorDto);
    }

}
