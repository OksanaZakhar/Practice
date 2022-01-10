package main.dao;

import main.model.Game;
import main.model.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;


import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Component
public class GameDAO implements Dao {

    @Autowired
    private GameRepository gameRepository;

    @Override
    public List<Game> list() {
        Iterable<Game> gameIterable = gameRepository.findAll();
        ArrayList<Game> games = new ArrayList<>();
        for (Game game : gameIterable) {
            games.add(game);
        }
        return games;
    }

    @Override
    public int add(Game game) {
        Game newGame = gameRepository.save(game);
        return newGame.getId();
    }

    @Override
    public ResponseEntity get(int id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (!optionalGame.isPresent()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
        return new ResponseEntity(optionalGame.get(), HttpStatus.OK);
    }

    @Override
    public ResponseEntity delete(int id) {
        Optional<Game> optionalGame = gameRepository.findById(id);
        if (optionalGame.isPresent()) {
            gameRepository.deleteById(id);
            return new ResponseEntity(HttpStatus.OK);
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }

    }


}
