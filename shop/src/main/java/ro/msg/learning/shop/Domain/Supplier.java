package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table( name = "supplier")
public class Supplier extends BaseClass {
    @Column( name = "name")
    private String name;

    @OneToMany(mappedBy = "supplier")
    private List<Product> supplierList = new ArrayList<Product>();
}
