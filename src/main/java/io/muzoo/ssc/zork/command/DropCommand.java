package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class DropCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "drop";
    }

    @Override
    public boolean isInGameCommand() {
        return true;
    }

    @Override
    public void execute(Game game, List<String> args) {
        if (game.isInGame) {
            game.player.drop(args.get(0));
        }
    }
}
