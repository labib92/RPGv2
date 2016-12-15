package com.labib.game;

import com.labib.game.commands.Command;
import com.labib.game.commands.ErrorCommand;

import java.util.Scanner;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class GameInputReader {
    private Scanner scanner;

    public GameInputReader() {
        this.scanner = new Scanner(System.in);
    }

    public Command readCommand(CommandSet set) {
        if(scanner.hasNextInt()){
            int command = scanner.nextInt();
            String line = scanner.nextLine();
            if(!line.trim().isEmpty()){
                return new ErrorCommand();
            }
            return set.parse(command);
        }else{
            scanner.next();
            return new ErrorCommand();
        }
    }
}
