package main;

import main.model.Game;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Storage {

    private static int currentId = 1;
    private static HashMap<Integer, Game> games = new HashMap<>();

    public static List<Game> getAllGames() {
        ArrayList<Game> gamesList = new ArrayList<>();
        gamesList.addAll(games.values());
        return gamesList;
    }

    public static int addGame(Game game) {
        int id = currentId++;
        game.setId(id);
        games.put(id, game);
        return id;
    }

    public static Game getGame(int gameId) {
        if (games.containsKey(gameId)) {
            return games.get(gameId);
        }
        return null;
    }

    public static void deleteGame(int gameId) {
        if (games.containsKey(gameId)) {
            games.remove(gameId);
        }

    }


}
