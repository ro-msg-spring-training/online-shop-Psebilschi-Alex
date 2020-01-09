package ro.msg.learning.shop.Exceptions;

public class ProductCategoryNotFoundException extends RuntimeException {
    public ProductCategoryNotFoundException(Integer id) {
        super("Could not find product category " + id);
    }
}
