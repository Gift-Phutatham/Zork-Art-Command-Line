package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.map.MyMap;

import java.util.*;

public class Game {

    public MyMap currentMap;
    public boolean isInGame;
    public Player player = new Player();
    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    public List<List<String>> saveCommands = new ArrayList<>();
    public Map<String, List<List<String>>> allSaveCommands = new HashMap<>();

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            if (words == null) {
                System.out.println("Command not found");
            } else {
                if (!words.get(0).equals("quit") && !words.get(0).equals("load") && !words.get(0).equals("save")) {
                    saveCommands.add(words);
                }
                operate(words);
            }
        }
    }

    private void operate(List<String> words) {
        Command command = CommandFactory.get(words.get(0));
        if (command != null) {
            command.execute(this, words.subList(1, words.size()));
        }
    }

    public GameOutput getOutput() {
        return output;
    }

    public void play(String mapName) {
        currentMap = MyMapFactory.get(mapName);
        if (currentMap != null) {
            isInGame = true;
            player = new Player();
            currentMap.initialize();
            System.out.println("Playing in " + currentMap.getMyMapName());
        } else {
            System.out.println(mapName + " is not found");
        }
    }

    public void quit() {
        isInGame = false;
    }

    public void load(String savedPointName) {
        List<List<String>> toLoad = allSaveCommands.get(savedPointName);
        if (toLoad != null){
            for (List<String> words : toLoad) {
                System.out.println(words.get(0));
                operate(words);
            }
        } else {
            System.out.println("No " + savedPointName + " found");
        }
    }

    public void save(String savedPointName) {
        allSaveCommands.put(savedPointName, saveCommands);
    }

    public void exit() {
        System.exit(0);
    }
}
