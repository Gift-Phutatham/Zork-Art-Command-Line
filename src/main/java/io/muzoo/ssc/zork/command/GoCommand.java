package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public class GoCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "go";
    }

    @Override
    public boolean isInGameCommand() {
        return true;
    }

    @Override
    public void execute(Game game, List<String> args) {
        if (game.isInGame) {
            if (game.currentMap.go(args.get(0)) != null) {
                game.player.go();
            }
        }
    }
}
