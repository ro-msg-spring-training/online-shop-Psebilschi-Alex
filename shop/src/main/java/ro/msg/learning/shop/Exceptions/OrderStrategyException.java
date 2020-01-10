package ro.msg.learning.shop.Exceptions;

public class OrderStrategyException extends RuntimeException {
    public OrderStrategyException() {
        super("Strategy not working.");
    }
}