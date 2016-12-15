package com.labib.game;

import java.util.Random;

/**
 * Created by labib's pc on 12/13/2016.
 */
public class Enemy {
    private  static int maxEnemyHealth = 75;
    private  int enemyAttackDamage = 25;
    private int enemyHealth;
    private int attackDamage = 50;
    private  Random random;
    private String name;
    private static String[] possibleNames = {"Assassin", "Skeleton", "Zombie", "Warrior"};

    public Enemy(Random rand){
        enemyHealth=rand.nextInt(maxEnemyHealth);
        int index =rand.nextInt(possibleNames.length);
        name =possibleNames[index];
        random=rand;
    }
    public int getEnemyAttackDamage(){
       return   enemyAttackDamage;
    }
    public int getEnemyHealth(){
        return enemyHealth;
    }
    public String getName(){
        return name;
    }

    public int damageDealtToEnemy(){
        int damageDealt = random.nextInt(attackDamage);
        enemyHealth -= damageDealt;
        return  damageDealt;

    }


}
