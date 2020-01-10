package ro.msg.learning.shop.Domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "revenue")
public class Revenue extends BaseClass {
    @Column(name = "date")
    private Timestamp date;

    @Column(name = "sum")
    private Double sum;

    @ManyToOne
    @JoinColumn(name = "location")
    private Location location;
}
