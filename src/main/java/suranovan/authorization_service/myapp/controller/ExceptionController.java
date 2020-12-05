package suranovan.authorization_service.myapp.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.mvc.method.annotation.ExceptionHandlerExceptionResolver;
import suranovan.authorization_service.myapp.exception.InvalidCredentials;
import suranovan.authorization_service.myapp.exception.UnauthorizedUser;

@ControllerAdvice
public class ExceptionController extends ExceptionHandlerExceptionResolver {
    @ExceptionHandler(UnauthorizedUser.class)
    ResponseEntity<String> handleUnauthorizedUser(UnauthorizedUser e) {
        System.out.println(e.getMessage());
        return new ResponseEntity<>(e.getMessage(), HttpStatus.UNAUTHORIZED);
    }

    @ExceptionHandler(InvalidCredentials.class)
    ResponseEntity<String> handleInvalidCredentials(InvalidCredentials e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
    }
}
