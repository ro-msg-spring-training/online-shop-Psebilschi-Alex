package ro.msg.learning.shop.Domain;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@ToString(exclude = "productList")
@Table(name = "productCategory")
@Builder
@NoArgsConstructor @AllArgsConstructor
public class ProductCategory extends BaseClass {
    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @OneToMany(mappedBy = "category")
    private List<Product> productList = new ArrayList<Product>();

}
