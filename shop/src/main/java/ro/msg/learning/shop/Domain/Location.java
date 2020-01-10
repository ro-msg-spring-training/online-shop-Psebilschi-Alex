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
    private List<Orders> ordersList = new ArrayList<Orders>();

    @OneToMany(mappedBy = "location")
    private List<Revenue> revenueList = new ArrayList<Revenue>();
}
