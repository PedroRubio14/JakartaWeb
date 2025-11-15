package org.mons.demo1.dto;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;
import org.mons.demo1.models.Comment;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class MovieDto {

    private long id;
    private String name;
    private String description;
    private int year;
    private List<CommentDto> comments;


    public MovieDto(long id, String name, String description, int year, List<CommentDto> comments) {
        this.id = id;
        this.name = name;
        this.description= description;
        this.year=year;
        this.comments= comments;
    }

    public MovieDto() {}
}
