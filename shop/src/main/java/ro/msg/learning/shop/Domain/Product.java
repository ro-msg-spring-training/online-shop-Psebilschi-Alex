package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
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

    @Column(name = "image_url")
    private String image_url;

    @ManyToOne
    @JoinColumn(name = "category")
    private ProductCategory category;

    @ManyToOne
    @JoinColumn(name = "supplier")
    private Supplier supplier;

    @OneToMany(mappedBy = "product")
    private List<Stock> stockList = new ArrayList<Stock>();

    @OneToMany(mappedBy = "product")
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}
