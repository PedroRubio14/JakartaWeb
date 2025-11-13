package org.mons.demo1.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class MovieDto {

    private long id;
    private String name;
    private String description;
    private int year;


    public MovieDto(long id, String name, String description, int year){
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
    }

    public MovieDto() {}
}
