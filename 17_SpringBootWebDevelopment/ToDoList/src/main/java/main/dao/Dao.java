package main.dao;

import main.model.Game;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Optional;

public interface Dao {

    List list();

    int add(Game game);

    ResponseEntity get(int id);

    ResponseEntity delete(int id);
}
