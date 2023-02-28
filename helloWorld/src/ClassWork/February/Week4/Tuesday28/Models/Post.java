package ClassWork.February.Week4.Tuesday28.Models;

import jakarta.persistence.*;
import lombok.Data;

import java.util.HashSet;
import java.util.Set;

@Data
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String title;

    @ManyToOne
    @JoinColumn(name="author_id",nullable = true)
    private User author;

    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "post_tags",
            joinColumns = {@JoinColumn(name = "post_id")},
            inverseJoinColumns = {@JoinColumn(name = "tag_id")}
    )
    private Set<Tag> tags = new HashSet<>();

}
