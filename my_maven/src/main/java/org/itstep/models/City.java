package org.itstep.models;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Entity
@Data
public class City {
    @Id
    private Long id;

    private String name;

}
