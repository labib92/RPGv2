package com.labib.game;

import com.labib.game.commands.*;

/**
 * Created by labib's pc on 12/15/2016.
 */
public abstract class CommandSet {
    public abstract Command parse(int inputNumber);

    public CommandSet() {
    }

    public static final CommandSet MAIN_MENU_SET = new CommandSet() {
        @Override
        public Command parse(int inputNumber) {
            switch (inputNumber){
                case 1: return new ContinueCommand();
                case 2: return new ExitCommand();
            }
            return new ErrorCommand();
        }
    };

    public static final CommandSet GAME_MENU_SET = new CommandSet() {
        @Override
        public Command parse(int inputNumber) {
            switch (inputNumber){
                case 1: return new AttackCommand();
                case 2: return new DrinkPotionCommand();
                case 3: return new RunawayCommand();
            }
            return new ErrorCommand();
        }
    };
}
