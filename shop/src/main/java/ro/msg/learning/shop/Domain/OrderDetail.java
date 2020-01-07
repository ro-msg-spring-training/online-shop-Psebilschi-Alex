package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "orderDetail")
public class OrderDetail extends BaseClass {
    @ManyToOne
    private Order order;

    @ManyToOne
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}
