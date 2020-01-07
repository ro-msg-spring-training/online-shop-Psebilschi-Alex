package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table( name = "productCategory")
public class ProductCategory extends BaseClass {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<Product>();

}
