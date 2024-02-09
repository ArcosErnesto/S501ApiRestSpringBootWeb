package cat.itacademy.barcelonactiva.Arcos.Ernesto.s05.t01.n02.model.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionController {
    @ExceptionHandler(FlowerNotFoundException.class)
    public ResponseEntity<ExceptionDetails> fruitNotFoundException(FlowerNotFoundException exception) {
        ExceptionDetails details = new ExceptionDetails(exception.getMessage(), HttpStatus.BAD_REQUEST.value());
        return new ResponseEntity<>(details, HttpStatus.BAD_REQUEST);
    }
}

