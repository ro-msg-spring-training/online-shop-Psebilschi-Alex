package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "order_detail")
public class OrderDetail extends BaseClass {
    @ManyToOne
    @JoinColumn(name = "orders")
    private Orders orders;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;

    @Column(name = "quantity")
    private Integer quantity;
}
