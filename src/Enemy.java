import java.util.Random;

/**
 * Created by labib's pc on 12/13/2016.
 */
public class Enemy {
    static int maxEnemyHealth = 75;
    int enemyAttackDamage = 25;
    int enemyHealth;
    int attackDamage = 50;
    Random rand = new Random();



    String name;
    static String[] possibleNames = {"Assassin", "Skeleton", "Zombie", "Warrior"};

    public Enemy(){
        enemyHealth=rand.nextInt(maxEnemyHealth);
        int index =rand.nextInt(possibleNames.length);
        name =possibleNames[index];
    }
    public int damageDealtToEnemy(){
        int damageDealt = rand.nextInt(attackDamage);
        enemyHealth -= damageDealt;
        return  damageDealt;

    }


}
