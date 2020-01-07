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
    @Column(name = "firstName", length = 30)
    private String firstName;

    @Column(name = "lastName", length = 30)
    private String lastName;

    @Column(name = "username", length = 30)
    private String username;

    @Column(name = "password", length = 30)
    private String password;

    @Column(name = "emailAddress", length = 50)
    private String emailAddress;

    @OneToMany(mappedBy = "customer")
    private List<Order> orderList = new ArrayList<Order>();
}
