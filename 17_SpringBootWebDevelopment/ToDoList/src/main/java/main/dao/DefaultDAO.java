package main.dao;

import main.model.Game;
import main.model.GameRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;

import java.util.ArrayList;

@Component
public class DefaultDAO implements DaoDef {
    @Autowired
    GameRepository gameRepository;

    @Override
    public String index(Model model) {
        Iterable<Game> gameIterable = gameRepository.findAll();
        ArrayList<Game> games = new ArrayList<>();
        for (Game game : gameIterable) {
            games.add(game);
        }
        model.addAttribute("gamesCount", games.size());
        return "index";
    }

}
