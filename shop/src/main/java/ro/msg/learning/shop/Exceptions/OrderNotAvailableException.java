package ro.msg.learning.shop.Exceptions;

public class OrderNotAvailableException extends RuntimeException {
    public OrderNotAvailableException() {
        super("Could not create your order");
    }
}