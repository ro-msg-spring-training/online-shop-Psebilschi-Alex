package ro.msg.learning.shop.DTOs;

import lombok.Builder;
import lombok.Value;

@Value
@Builder(toBuilder = true)
public class ProductDTO {
    Integer id, category, supplier;
    String name, description, image_url, categoryName, categoryDescription;
    Double price, weight;
}
