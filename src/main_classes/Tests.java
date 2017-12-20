package main_classes;

import models.Game;
import services.*;

import java.util.Date;

public class Tests {
    public static void main(String[] args) {
        DatabaseConnectionService db = new DatabaseConnectionService("Workspace.db");
        Date date = new Date();
        Game game = new Game(1, 11, date, "13:00");
//        System.out.println(game.getUserID());
        GameService.save(game, db);


    }
}
