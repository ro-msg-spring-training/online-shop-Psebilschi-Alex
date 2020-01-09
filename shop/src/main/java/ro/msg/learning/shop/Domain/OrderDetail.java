package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "order_detail")
public class OrderDetail extends BaseClass {
    @ManyToOne
    @JoinColumn(name = "order")
    private Order order;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}
