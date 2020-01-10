package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "orders")
public class Orders extends BaseClass {
    @ManyToOne
    @JoinColumn(name = "shipped_from")
    private Location shipped_from;

    @ManyToOne
    @JoinColumn(name = "customer_id")
    private Customer customer_id;

    @Column(name = "create_at")
    private Timestamp create_at;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "street_address")
    private String street_address;

    @OneToMany(mappedBy = "orders")
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}
