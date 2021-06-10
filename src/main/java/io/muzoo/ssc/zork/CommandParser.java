package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CommandParser {

    private List<String> allCommandsSortedByLength = new ArrayList<>();

    {
        allCommandsSortedByLength.addAll(CommandFactory.getAllCommands());
        allCommandsSortedByLength.sort((o1, o2) -> o2.length() - o1.length());
    }

    private String matchInputToCommand(String input) {
        for (String command : allCommandsSortedByLength) {
            if (input.startsWith(command)) {
                return command;
            }
        }
        return null;
    }

    public List<String> parse(String stringInput) { //
        String cleanedInput = stringInput.trim();
        String cmd = matchInputToCommand(cleanedInput);
        Command command = CommandFactory.get(cmd);
        if (command.numArgs() > 0) {
            String argString = cleanedInput.substring(cmd.length()).trim();
            System.out.println(argString);
            return Arrays.asList(cmd, argString);
        } else {
            return Arrays.asList(cmd);
        }
    }
}
