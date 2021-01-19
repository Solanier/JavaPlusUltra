package com.bpcourseproject.PlusUltra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import com.bpcourseproject.PlusUltra.model.Game;
import org.springframework.data.jpa.repository.Query;

public interface GameRepository extends JpaRepository<Game, Long> {
    
    @Query("SELECT g FROM Game g WHERE g.name LIKE %?1%"
            + " OR g.description LIKE %?1%")
    public List<Game> findAll(String keyword);
    
}
 