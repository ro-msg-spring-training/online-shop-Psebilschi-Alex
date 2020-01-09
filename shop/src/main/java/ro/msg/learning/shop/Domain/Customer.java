package ro.msg.learning.shop.Domain;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "customer")
public class Customer extends BaseClass {
    @Column(name = "first_name", length = 30)
    private String first_name;

    @Column(name = "last_name", length = 30)
    private String last_name;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "email_address", length = 50)
    private String email_address;

    @OneToMany(mappedBy = "customer_id")
    private List<Order> orderList = new ArrayList<Order>();
}
