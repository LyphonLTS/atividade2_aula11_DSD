package handler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.reactive.result.method.annotation.ResponseEntityExceptionHandler;

import com.atividade2.aula11.atividade2_aula11.exceptions.ExceptionResponse;
import com.atividade2.aula11.atividade2_aula11.exceptions.UnsupportedMathOperationException;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

  @ExceptionHandler(Exception.class)
  public final ResponseEntity<ExceptionResponse> handlerAllExceptions(Exception e, WebRequest req) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.INTERNAL_SERVER_ERROR);
  }

  @ExceptionHandler(UnsupportedMathOperationException.class)
  public final ResponseEntity<ExceptionResponse> handlerBadRequestExceptions(Exception e, WebRequest req) {
    ExceptionResponse exceptionResponse = new ExceptionResponse(new Date(), e.getMessage(), req.getDescription(false));

    return new ResponseEntity<>(exceptionResponse, HttpStatus.BAD_REQUEST);
  }
}
