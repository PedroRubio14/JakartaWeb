package org.mons.demo1.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Entity
@Table(name = "movies")
public class Movie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(name = "title")
    private String name;
    @Column(name = "description")
    private String description;
    private int year;
    @OneToMany(mappedBy = "movie", cascade = CascadeType.ALL)
    private List<Comment> comments;


    public Movie(long id, String name, String description, int year){
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
    }

    public Movie() {

    }

}
