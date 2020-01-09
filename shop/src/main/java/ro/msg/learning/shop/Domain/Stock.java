package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "stock")
public class Stock extends BaseClass {
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;

    @ManyToOne
    @JoinColumn(name = "product")
    private Product product;
}
