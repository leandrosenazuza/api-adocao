package api_adocao.Config.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.dao.DataIntegrityViolationException;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ResponseError> handleDataIntegrityViolation(DataIntegrityViolationException ex) {
        ResponseError errorResponse = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de integridade de dados!",
                ex.getCause().getLocalizedMessage()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseError> handleGenericException(Exception ex) {
        ResponseError errorResponse = new ResponseError(
                HttpStatus.INTERNAL_SERVER_ERROR.value(),
                "Erro inesperado",
                ex.getMessage()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(errorResponse);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseError> handleMethodArgumentNotValid(MethodArgumentNotValidException ex) {
        ResponseError errorResponse = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Erro de validação",
                ex.getBindingResult().getAllErrors().toString()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpMessageNotReadableException.class)
    public ResponseEntity<ResponseError> handleHttpMessageNotReadable(HttpMessageNotReadableException ex) {
        ResponseError errorResponse = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Corpo da requisição não legível",
                ex.getMessage()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }

    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public ResponseEntity<ResponseError> handleHttpRequestMethodNotSupported(HttpRequestMethodNotSupportedException ex) {
        ResponseError errorResponse = new ResponseError(
                HttpStatus.BAD_REQUEST.value(),
                "Método HTTP não suportado",
                ex.getMethod()
        );
        return ResponseEntity.badRequest().body(errorResponse);
    }
}
