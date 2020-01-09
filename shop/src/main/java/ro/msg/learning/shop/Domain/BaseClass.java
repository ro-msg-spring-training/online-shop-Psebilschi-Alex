package ro.msg.learning.shop.Domain;

import lombok.*;

import javax.persistence.*;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BaseClass {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    protected Integer id;

}
