package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "product")
public class Product extends BaseClass {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "price")
    private Double price;

    @Column(name = "weight")
    private Double weight;

    @Column(name = "imageUrl")
    private String imageUrl;

    @ManyToOne
    private ProductCategory category;

    @ManyToOne
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<Stock> stockList = new ArrayList<Stock>();

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}
