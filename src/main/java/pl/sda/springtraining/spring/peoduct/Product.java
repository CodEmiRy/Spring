package pl.sda.springtraining.spring.peoduct;

import lombok.Getter;
import lombok.Setter;
import pl.sda.springtraining.spring.BaseEntity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.math.BigDecimal;
@Entity
@Getter
@Setter
public class Product extends BaseEntity implements ProductInfoHolder {


    private String productName;
    private Integer stockAmount;
    private BigDecimal price;

}
