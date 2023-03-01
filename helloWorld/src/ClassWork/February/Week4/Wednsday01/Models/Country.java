package ClassWork.February.Week4.Wednsday01.Models;

import jakarta.persistence.*;

import java.util.Set;

@Entity
// @Table(name="countries")
public class Country {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id")
    private int id;

    private String name;

    @OneToMany(mappedBy = "country")
    private Set<City> cities;

    @OneToOne
    // @JoinColumn(name = "catipal_city_id")
    private City capital;


}
