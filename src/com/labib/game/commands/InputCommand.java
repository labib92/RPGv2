package com.labib.game.commands;

/**
 * Created by labib's pc on 12/15/2016.
 */
public class InputCommand implements Command {
    private int number;

    public InputCommand(int number) {
        this.number = number;
    }

    public int getNumber() {
        return number;
    }
}
