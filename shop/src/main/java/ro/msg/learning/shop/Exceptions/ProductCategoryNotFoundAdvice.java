package ro.msg.learning.shop.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class ProductCategoryNotFoundAdvice {
    @ResponseBody
    @ExceptionHandler(ProductCategoryNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String productCategoryNotFoundHandle(ProductCategoryNotFoundException ex) {
        return ex.getMessage();
    }
}
