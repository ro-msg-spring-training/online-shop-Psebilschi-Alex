package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Data
@Table(name = "stock")
public class Stock extends BaseClass {
    @Column(name = "quantity")
    private Integer quantity;

    @ManyToOne
    private Location location;

    @ManyToOne
    private Product product;
}
