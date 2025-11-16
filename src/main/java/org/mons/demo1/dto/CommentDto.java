package org.mons.demo1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;
import org.mons.demo1.models.Movie;

import java.sql.Timestamp;


@Setter
@Getter
public class CommentDto {
    private Long id;
    private Long movie;
    private String comment_text;
    private Timestamp created_at;

    public CommentDto(Long id, Long movie, String comment_text, Timestamp created_at) {
        this.id = id;
        this.movie = movie;
        this.comment_text = comment_text;
        this.created_at = created_at;
    }

    @Override
    public String toString() {
        return comment_text;
    }


}


