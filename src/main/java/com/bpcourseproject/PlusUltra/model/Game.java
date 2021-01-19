package com.bpcourseproject.PlusUltra.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "games")
public class Game {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "game_id")
    private Long id;
    
    @Column(name = "game_name")
    private String name;
    
    @Column(name = "game_description")
    private String description;
    
    @Column(name = "game_genre")
    private String genre;
    
    @Column(name = "game_developer")
    private String developer;
    
    @Column(name = "game_engine")
    private String engine;
    
    public Long getId() {
        return id;
    }
    
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }
    
    public String getGenre() {
        return genre;
    }
    
    public void setGenre(String genre) {
        this.genre = genre;
    }
    
    public String getDeveloper() {
        return developer;
    }
    
    public void setDeveloper(String developer) {
        this.developer = developer;
    }
    
    public String getEngine() {
        return engine;
    }
    
    public void setEngine(String engine) {
        this.engine = engine;
    }
}
