package ro.msg.learning.shop.DTOs;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Value;
import org.springframework.data.util.Pair;

import java.sql.Timestamp;
import java.util.List;
import java.util.Map;

@Value
@Builder(toBuilder = true)
public class OrderDTO {
    Timestamp timestamp;
    String deliveryCountry, deliveryCity, deliveryStreet;
    Map<Integer, Integer> productsList;
}
