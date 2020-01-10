package ro.msg.learning.shop.Exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

public class OrderNotAvailableAdvice {
    @ResponseBody
    @ExceptionHandler(OrderNotAvailableException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    String OrderNotAvailableAdvice(OrderNotAvailableException ex) {
        return ex.getMessage();
    }
}
