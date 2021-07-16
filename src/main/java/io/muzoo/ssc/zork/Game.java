package io.muzoo.ssc.zork;

import io.muzoo.ssc.zork.command.Command;
import io.muzoo.ssc.zork.map.MyMap;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public MyMap currentMap;
    public boolean isInGame;
    public Player player = new Player();
    private GameOutput output = new GameOutput();
    private CommandParser commandParser = new CommandParser();
    public List<List<String>> saveCommands = new ArrayList<>();

    public void run() {
        while (true) {
            Scanner in = new Scanner(System.in);
            String s = in.nextLine();
            List<String> words = commandParser.parse(s);
            if (words == null) {
                System.out.println("Command not found");
            } else {
                saveCommands.add(words);
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

//    public void load() {
//        for (List<String> words : saveCommands) {
//            operate(words);
//        }
//        saveCommands.clear();
//    }

    public void exit() {
        System.exit(0);
    }
}
