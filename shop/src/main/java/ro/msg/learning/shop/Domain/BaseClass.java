package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter @Setter @NoArgsConstructor @AllArgsConstructor
public class BaseClass {

    @Id
    protected Integer id;

}
