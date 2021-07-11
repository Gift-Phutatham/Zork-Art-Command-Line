package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class HelpCommand implements Command {

    @Override
    public int numArgs() {
        return 0;
    }

    @Override
    public String getCommand() {
        return "help";
    }

    @Override
    public void execute(Game game, List<String> args) {
        game.getOutput().println("map - Print map");
        game.getOutput().println("play {map-name} - Play new game");
        game.getOutput().println("take - Pick up the item in the current room");
        game.getOutput().println("info - Print out your stats and room information");
        game.getOutput().println("attack with - Attack a monster in the current room");
        game.getOutput().println("drop - Drop item of choice that you currently carries");
        game.getOutput().println("go {direction} - Move you to the room as specified by the direction, e.g. north, east, west, south");
        game.getOutput().println("save {saved-point-name} - Save game state");
        game.getOutput().println("load {saved-point name} - Load game state from saved point");
        game.getOutput().println("quit - End the current game. You can choose the map or load from saved point again.");
        game.getOutput().println("exit - Exit whole game");
    }
}
