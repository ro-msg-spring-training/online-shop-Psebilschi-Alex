package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "location")
public class Location extends BaseClass {
    @Column(name = "name", length = 30)
    private String name;

    @Column(name = "country", length = 30)
    private String country;

    @Column(name = "city", length = 30)
    private String city;

    @Column(name = "street_address", length = 30)
    private String street_address;

    @OneToMany(mappedBy = "location")
    private List<Stock> stockList = new ArrayList<Stock>();

    @OneToMany(mappedBy = "shipped_from")
    private List<Order> orderList = new ArrayList<Order>();

    @OneToMany(mappedBy = "location")
    private List<Revenue> revenueList = new ArrayList<Revenue>();
}
