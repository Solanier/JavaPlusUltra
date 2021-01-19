package com.bpcourseproject.PlusUltra.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bpcourseproject.PlusUltra.model.Game;
import com.bpcourseproject.PlusUltra.repository.GameRepository;

@Service
public class GameService {
    
    @Autowired
    private GameRepository repository;
    
    public List<Game> listAll(String keyword) {
        if (keyword != null) {
            return repository.findAll(keyword);
        }
        return repository.findAll();
    }
    
    public void create(Game game) {
        
        repository.save(game);
    }
    
    public Game updateid(Long id) {
        
        return repository.findById(id).get();
    }
    
    public void delete(Long id) {
        
        repository.deleteById(id);
    }
}
