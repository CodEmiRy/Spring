package pl.sda.springtraining.spring;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import javax.persistence.Id;

@MappedSuperclass
@Getter
@Setter
public class BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
}
