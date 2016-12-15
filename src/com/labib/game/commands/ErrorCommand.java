package com.labib.game.commands;

import com.labib.game.Enemy;
import com.labib.game.Player;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class ErrorCommand implements Command {
    public void printError() {
        System.out.println("\tInvalid command");
    }
}
