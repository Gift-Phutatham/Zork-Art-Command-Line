package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.Game;

import java.util.List;

public interface Command {

    int numArgs();

    String getCommand();

    boolean isInGameCommand();

    void execute(Game game, List<String> args);
}
