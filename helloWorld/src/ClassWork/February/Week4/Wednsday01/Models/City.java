package ClassWork.February.Week4.Wednsday01.Models;

import jakarta.persistence.*;

@Entity
// @Table(name="cities")
public class City {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // @Column(name="id")
    private int id;

    private String name;

    @ManyToOne
    // @JoinColumn(name = "country_id")
    private Country country;

}
