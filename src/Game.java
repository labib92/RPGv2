import java.util.Random;
import java.util.Scanner;

/**
 * Created by labib's pc on 12/13/2016.
 */
public class Game {
    class Player {
        int health = 100;
        int attackDamage = 50;
        int numbHealthPotions = 3;
        int healthPotionHealAmount = 30;
        int healthPotionDropChance = 50;
    }
    Player player = new Player();




    Random rand = new Random();
    Scanner in = new Scanner(System.in);

    boolean running = true;

    public void gameSystem() {
        GAME:
        while (running) {
            System.out.println("-----------------------------------------------");
            Enemy enemy = new Enemy();
            System.out.println("\t# " + enemy.name + " has appeared! #\n");
            while (enemy.enemyHealth > 0) {
                status(enemy);

                String input = in.nextLine();
                if (input.equals("1")) {
                    attack( enemy);
                    if (player.health < 1) {
                        System.out.println("\t> You have taken too much damage, you are weak to go on!");
                        break;
                    }

                } else if (input.equals("2")) {
                    if (player.numbHealthPotions > 0) {
                        heal();


                    } else {
                        System.out.println("\t> You have no health potion left! Defeat enimes for a chance to get one!");
                    }

                } else if (input.equals("3")) {
                    System.out.println("\tYou run away from the " + enemy + "!");
                    continue GAME;

                } else {
                    System.out.println("\t Invalid command!");

                }

            }
            if (player.health < 1) {
                System.out.println("you are Dead.");
                break;
            }
            System.out.println("-----------------------------------------------");
            System.out.println(" # " + enemy.name + " was defeated! # ");
            System.out.println(" # You have " + player.health + " HP left. #");
            if (rand.nextInt(100) < player.healthPotionDropChance) {
                potionPercentageDropFromEnemy(enemy);


            }
            gameOption();

            String input = in.nextLine();
            while (!input.equals("1") && input.equals("2")) {
                System.out.println("Invalid command!");
                input = in.nextLine();
            }
            if (input.equals("1")) {
                System.out.println("You continue in your adventure");
            } else if (input.equals("2")) {
                System.out.println("You exit the dungeon, succeful from your adventure!");
                break;

            }

        }
    }

    private void attack( Enemy enemy) {
        int damageDealt = rand.nextInt(player.attackDamage);
        int damageTaken = rand.nextInt(enemy.enemyAttackDamage);
        enemy.enemyHealth -= damageDealt;
        player.health -= damageTaken;
        System.out.println("\t> You strike the " + enemy.name + " for " + damageDealt + " damage.");
        System.out.println("\t> You recived " + damageTaken + " in retaliation");
    }

    private void gameOption() {
        System.out.println("-----------------------------------------------");
        System.out.println("What would you like to do?");
        System.out.println("1. Continue Fighting");
        System.out.println("2. Exit dungeon");
    }

    private void potionPercentageDropFromEnemy(Enemy enemy) {
        player.numbHealthPotions++;
        System.out.println(" # The " + enemy.name + " dropped a health potion! # ");
        System.out.println(" # You now have " + player.numbHealthPotions + " health potion(s). # ");
    }

    private void heal() {
        player.health += player.healthPotionHealAmount;
        player.numbHealthPotions--;
        System.out.println("\t> You drink a health potion, healing yourself for " + player.healthPotionHealAmount + "."
                + "\n\t> You now have " + player.health + " HP."
                + "\n\t> You have " + player.numbHealthPotions + " health potion left.\n");
    }

    private void status(Enemy enemy) {
        System.out.println("\tYour HP: " + player.health);
        System.out.println("\t" + enemy.name + "'s HP: " + enemy.enemyHealth);
        System.out.println("\n\tWhat would you like to do");
        System.out.println("\t1. Attack");
        System.out.println("\t2. Drink health potion");
        System.out.println("\t3. Run");
    }
}

