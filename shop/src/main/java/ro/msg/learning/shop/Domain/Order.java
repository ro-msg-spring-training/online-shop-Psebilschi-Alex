package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "order")
public class Order extends BaseClass {
    @ManyToOne
    @Column(name = "shippedFrom")
    private Location shippedFrom;

    @ManyToOne
    private Customer customer;

    @Column(name = "createAt")
    private Timestamp createAt;

    @Column(name = "country")
    private String country;

    @Column(name = "city")
    private String city;

    @Column(name = "streetAddress")
    private String streetAddress;

    @OneToMany(mappedBy = "order")
    private List<OrderDetail> orderDetailList = new ArrayList<OrderDetail>();
}
