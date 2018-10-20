package pl.sda.springtraining.spring.peoduct;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
public class Product {
    @Id
    @GeneratedValue
    private Integer id;
    private String productName;
    private Integer stockAmount;
    private BigDecimal price;
}
