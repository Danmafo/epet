package br.com.epet.config;

import br.com.epet.entity.dto.ErrorDTO;
import br.com.epet.exception.EpetException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.persistence.EntityNotFoundException;
import java.util.Arrays;
import java.util.List;

import static org.springframework.http.HttpStatus.BAD_REQUEST;
import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;

@RestControllerAdvice
@Slf4j
public class ExceptionHandlerConfig {

    @ExceptionHandler(EpetException.class)
    protected ResponseEntity<ErrorDTO> handleCinbesaException(EpetException ex) {
        HttpStatus status = BAD_REQUEST;
        ErrorDTO defaultErrorDTO = this.buildDefaultErrorRet(ex.getMessage(), ex, status.value());

        return new ResponseEntity<>(defaultErrorDTO, new HttpHeaders(), status);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<ErrorDTO> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        BindingResult result = ex.getBindingResult();
        final List<FieldError> fieldErrors = result.getFieldErrors();
        String mensagem = "";
        for (FieldError fieldError : fieldErrors) {
            if (fieldError.getDefaultMessage() != null) {
                mensagem = mensagem.concat(fieldError.getDefaultMessage() + ". ");
            }
        }
        HttpStatus status = BAD_REQUEST;
        ErrorDTO defaultErrorDTO = this.buildDefaultErrorRet(ex.getMessage(), ex, status.value());

        return new ResponseEntity<>(defaultErrorDTO, new HttpHeaders(), status);
    }

    @ExceptionHandler(EntityNotFoundException.class)
    protected ResponseEntity<ErrorDTO> handleEntityNotFoundException(EntityNotFoundException ex) {
        HttpStatus status = BAD_REQUEST;
        ErrorDTO defaultErrorDTO = this.buildDefaultErrorRet(ex.getMessage(), ex, status.value());

        return new ResponseEntity<>(defaultErrorDTO, new HttpHeaders(), status);
    }

    @ExceptionHandler(NullPointerException.class)
    protected ResponseEntity<ErrorDTO> handleNullPointerException(NullPointerException ex) {
        HttpStatus status = BAD_REQUEST;
        ErrorDTO defaultErrorDTO = this.buildDefaultErrorRet(ex.getMessage(), ex, status.value());
        log.error(Arrays.toString(ex.getStackTrace()));
        return new ResponseEntity<>(defaultErrorDTO, new HttpHeaders(), status);
    }

    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Object> handleException(Exception ex) {
        HttpStatus status = INTERNAL_SERVER_ERROR;
        ErrorDTO defaultErrorDTO = this.buildDefaultErrorRet(ex.getMessage(), ex, status.value());

        return new ResponseEntity<>(defaultErrorDTO, new HttpHeaders(), status);
    }

    protected ErrorDTO buildDefaultErrorRet(String mensagem, Exception exception, Integer code) {
        ErrorDTO defaultErrorDTO = new ErrorDTO();
        log.error("Error: {}", mensagem);
        defaultErrorDTO.setMessage(mensagem);
        defaultErrorDTO.setException(exception.getClass().getSimpleName());
        defaultErrorDTO.setCode(code);
        return defaultErrorDTO;
    }
}