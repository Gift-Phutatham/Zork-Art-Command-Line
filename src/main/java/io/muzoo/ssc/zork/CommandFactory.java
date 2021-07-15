package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.*;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class CommandFactory {

    private static final Map<String, Command> COMMAND_MAP = new HashMap<>();
    private static final List<Class<? extends Command>> REGISTERED_COMMANDS = Arrays.asList(
            InfoCommand.class,
            GoCommand.class,
            TakeCommand.class,
            DropCommand.class,
            HelpCommand.class,
            ExitCommand.class
    );

    static {
        {
            for (Class<? extends Command> commandClass : REGISTERED_COMMANDS) {
                try {
                    Command command = commandClass.getDeclaredConstructor().newInstance();
                    COMMAND_MAP.put(command.getCommand(), command);
                } catch (InstantiationException | IllegalAccessException | InvocationTargetException | NoSuchMethodException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public static Command get(String command) {
        return COMMAND_MAP.get(command);
    }

    public static List<String> getAllCommands() {
        return COMMAND_MAP.keySet().stream().collect(Collectors.toList());
    }
}
