package store.store_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice
public class CustomExceptionHandler {

    @ExceptionHandler(CustomValidationException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ResponseBody
    public ErrorResponse handleCustomValidationException(CustomValidationException ex) {
        return new ErrorResponse(
                ex.getMessage(),
                HttpStatus.BAD_REQUEST.value()
        );
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ResponseBody
    public ErrorResponse handleGlobalException(Exception ex) {
        return new ErrorResponse(
                "An unexpected error occurred.",
                HttpStatus.INTERNAL_SERVER_ERROR.value()
        );
    }
}