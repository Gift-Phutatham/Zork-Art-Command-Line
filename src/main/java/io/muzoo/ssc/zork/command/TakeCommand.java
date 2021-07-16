package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;
import io.muzoo.ssc.zork.item.Item;

import java.util.List;

public class TakeCommand implements Command {

    @Override
    public int numArgs() {
        return 1;
    }

    @Override
    public String getCommand() {
        return "take";
    }

    @Override
    public boolean isInGameCommand() {
        return true;
    }

    @Override
    public void execute(Game game, List<String> args) {
        if (game.isInGame) {
            Item item = game.currentMap.take(args.get(0));
            game.player.take(item);
        }
    }
}
