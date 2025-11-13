package org.mons.demo1.models;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
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


    public Movie(long id, String name, String description, int year){
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
    }

    public Movie() {

    }

}
