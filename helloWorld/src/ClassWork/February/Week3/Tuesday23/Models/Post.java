package ClassWork.February.Week3.Tuesday23.Models;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name="posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    private String title;


    private User author;
}
