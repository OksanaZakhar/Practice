package main;

import main.dao.Dao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import main.model.Game;

import java.util.List;

@RestController
public class GameController {

    @Autowired
    Dao dao;

    @GetMapping("/games/")
    public List<Game> list() {
        return dao.list();
    }

    @PostMapping("/games/")
    public int add(Game game) {
        return dao.add(game);
    }

    @DeleteMapping("/games/{id}")
    public void delete(@PathVariable int id) {
        dao.delete(id);
    }

    @GetMapping("/games/{id}")
    public void get(@PathVariable int id) {
        dao.get(id);
    }

}
