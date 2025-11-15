package org.mons.demo1.dto;

import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import org.mons.demo1.models.Movie;

import java.sql.Timestamp;


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


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getMovie() {
        return movie;
    }

    public void setMovie(Long movie) {
        this.movie = movie;
    }

    public String getComment_text() {
        return comment_text;
    }

    public void setComment_text(String comment_text) {
        this.comment_text = comment_text;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }
}


