package io.muzoo.ssc.zork.command;

import io.muzoo.ssc.zork.CommandFactory;
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
        List<String> commands = CommandFactory.getAllCommands();
        for (String command : commands) {
            game.getOutput().println(command);
        }
    }
}
