package com.labib.game;

import com.labib.game.commands.*;

import java.util.Random;

/**
 * Created by labib's pc on 12/13/2016.
 */
public class Game {


    Random rand = new Random();
    Player player = new Player(rand);
    GameInputReader inputReader = new GameInputReader();

    boolean running = true;

    public void gameSystem() {

        System.out.println("Welcome to the Dungeon ");
        while (running) {
            System.out.println("-----------------------------------------------");
            Enemy enemy = new Enemy(rand);
            System.out.println("\t# " + enemy.getName() + " has appeared! #\n");
            FightCommand.Status status = fight(player, enemy);
            if (status == FightCommand.Status.DIED) {
                System.out.println("\t# YOU DIED T_T#");
                System.out.println("-----------------------------------------------");
                System.exit(0);
            }
            if (rand.nextInt(100) < player.getHealthPotionDropChance()) {
                potionPercentageDropFromEnemy(enemy);
            }

            boolean proceed = mainGameCycle(player);
            if (!proceed) {
                System.out.println("\t#  GAME OVER  #");
                System.exit(0);
            }

        }
        System.out.println("\t#  GAME OVER  #");
    }

    private boolean mainGameCycle(Player player) {
        mainGameMenu();

        Command command = inputReader.readCommand(CommandSet.MAIN_MENU_SET);
        while (command instanceof ErrorCommand) {
            ((ErrorCommand) command).printError();
            command = inputReader.readCommand(CommandSet.MAIN_MENU_SET);
        }
        return ((MainGameCommand) command).execute(player);
    }

    /**
     * @param player
     * @param enemy
     * @return
     */
    private FightCommand.Status fight(Player player, Enemy enemy) {
        while (enemy.getEnemyHealth() > 0) {
            status(enemy);
            gameProcessMenu();
            Command command = inputReader.readCommand(CommandSet.GAME_MENU_SET);
            if (command instanceof ErrorCommand) {
                ((ErrorCommand) command).printError();
            } else {
                FightCommand.Status status = ((FightCommand) command).execute(player, enemy);
                if (status == FightCommand.Status.RUAWAY || status == FightCommand.Status.DIED) {
                    return status;
                }
            }
        }

        if (player.getHealth() <= 0) {
            return FightCommand.Status.DIED;
        } else {
            System.out.println(" # " + enemy.getName() + " was defeated! # ");
            System.out.println(" # You have " + player.getHealth() + " HP left. #");
            return FightCommand.Status.PROCEED;
        }
    }


    private void mainGameMenu() {
        System.out.println("-----------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Continue Fighting");
        System.out.println("2. Exit dungeon");
    }

    private void potionPercentageDropFromEnemy(Enemy enemy) {
        player.setNumbHealthPotions();
        System.out.println(" # The " + enemy.getName() + " dropped a health potion! # ");
        System.out.println(" # You now have " + player.getNumbHealthPotions() + " health potion(s). # ");
    }


    private void status(Enemy enemy) {
        System.out.println("\tYour HP: " + player.getHealth());
        System.out.println("\t" + enemy.getName() + "'s HP: " + enemy.getEnemyHealth());
    }

    private void gameProcessMenu() {
        System.out.println("\n\tWhat would you like to do");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. Run");
    }
}

