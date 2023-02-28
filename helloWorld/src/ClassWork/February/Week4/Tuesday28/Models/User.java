package ClassWork.February.Week4.Tuesday28.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.Set;

@Data
@Entity
@Table(name="users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(length = 64)
    private String email;

    @OneToMany(mappedBy = "author")
    private Set<Post> posts;
}
