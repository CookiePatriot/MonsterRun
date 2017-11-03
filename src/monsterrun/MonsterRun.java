/*
@author Alex Chadwick
*/
package monsterrun;

import java.util.Random;
import java.util.Scanner;


public class MonsterRun {
    public static void main(String[] args) {
       
        //system objects
        Scanner in = new Scanner(System.in);
        Random rand = new Random();
        
        // Game variables
        String[] enemies = { "Skeleton",
            "goblin", "Assassin", "Wolves" , "Bats" };
        int maxEnemyHealth = 3;
        int enemyAttackDamage = 10;
        
        //boss variable
        /*String[] boss = { "balrog",
          "Dragon", "Master Assassin", "DireWolf", "Vampire" };
        int maxBossHealth = 300;
        int minBossHealth = 100;
        int maxBossAttackDMG = 50;
        int minBossAttackDMG = 10;
       */         
                
        //player variables
        int health = 100;
        int attackDamage = 24;
        int numHealthPots = 3; // number of potion you start with
        int healthPotionHealAmount = 30;
        int healthPotiondropChance = 70; //drop chance/percentage
        int xp = 20; 
        int xpTotal = 0;
        
        //game variables
        /* for every 10 enemies killed summon a boss
        */
        
        
        boolean running = true;
        
        System.out.println(" MonsterRun Dungeon");
        System.out.println("#############################################################################");
        System.out.println("#                                                                           #");
        System.out.println("#                                Welcome To                                 #");
        System.out.println("#                                                                           #");
        System.out.println("#  #     #                                          ######                  #");
        System.out.println("#  ##   ##  ####  #    #  ####  ##### ###### #####  #     # #    # #    #   #");
        System.out.println("#  # # # # #    # ##   # #        #   #      #    # #     # #    # ##   #   #");
        System.out.println("#  #  #  # #    # # #  #  ####    #   #####  #    # ######  #    # # #  #   #");
        System.out.println("#  #     # #    # #  # #      #   #   #      #####  #   #   #    # #  # #   #");
        System.out.println("#  #     # #    # #   ## #    #   #   #      #   #  #    #  #    # #   ##   #");
        System.out.println("#  #     #  ####  #    #  ####    #   ###### #    # #     #  ####  #    #   #");
        System.out.println("#                                                                           #");
        System.out.println("#############################################################################");
        
        
        GAME:
        while(running) {
            System.out.println("------------------------------------------------------------------------");
            
            int enemyHealth = rand.nextInt(maxEnemyHealth);
            String enemy = enemies[rand.nextInt(enemies.length)];
            System.out.println("\t# " + enemy + " has appeared! #\n");
            //  #skeleton has appeared
           
                while(enemyHealth > 0 ){
                    System.out.println("\t Your HP is:" + health);
                    System.out.println("\t" + enemy + "'s HP is:" +enemyHealth);
                    System.out.println("\n\t What would you like to do?");
                    System.out.println("\t1. Attack!");
                    System.out.println("\t2. Drink health portion");
                    System.out.println("\t3. Run Away!");
                        if(health < 1){
                            System.out.println("");
                            break;
                        }
                    String input = in.nextLine();
                    switch (input) {
                        case "1":
                            int damageDealt = rand.nextInt(attackDamage);
                            int damageTaken = rand.nextInt(enemyAttackDamage);
                            enemyHealth -= damageDealt;
                            health -= damageTaken;
                            System.out.println("\t> You strike the " + enemy + " for " + damageDealt + " damage.");
                            System.out.println("\t> You recieve " + damageTaken + " in retalliation!");
                            if(health < 1) {
                                System.out.println("\t> You have taken too much damage, you are to weak too continue!");
                            }   break;

                        case "2":
                            if(numHealthPots > -0) {
                                health += healthPotionHealAmount;
                                numHealthPots--;
                                System.out.println("\t> You drink a health potion, healing yourself for " +healthPotionHealAmount + "."
                                        + "\n\t> You now have " + health + " HP "
                                                + "\n\t> You have " +numHealthPots + " health potions left. \n");
                            }
                            else {
                                System.out.println("\t> You don't have any health potions left, defeat an enemy for a chance to get one");
                            }   break;
                        case "3":
                            System.out.println("\tYou run away from" + enemy );
                            continue GAME;
                        default:
                            System.out.println("\tInvalid Command");
                            break;
                    }
                }   
            
            if(health < 1){
                System.out.println("You Crawl out of the dungeon, bearly escaping with your life.");
                break;
            } 
            
            System.out.println("---------------------------------------------------------");
            int xpGained = rand.nextInt(xp);
            xpTotal += xpGained;
            System.out.println("#" + enemy + " was defeated! #");
            System.out.println("# you gained " + xpGained + "xp for defeating the " + enemy);
            System.out.println(" # You have " + health + " Hp left. #");
            System.out.println("# Your Xp is " + xpTotal);
            if(rand.nextInt(100) < healthPotiondropChance) {
                numHealthPots++;
                System.out.println("# The " + enemy + " dropped a health potion #");
                System.out.println(" # You now have " + numHealthPots + " health potion(s). #");
            }
            System.out.println("---------------------------------------------");
            System.out.println("What would you like to do now?");
            System.out.println("1. Continue fighting");
            System.out.println("2. Exit Dungeon");
           
            String input = in.nextLine();
             
            while(!input.equals("1") && !input.equals("2")) {
                System.out.println("Invalid Command!");
                input = in.nextLine(); 
            }
            
            if(input.equals("1")){
                System.out.println("You continues on your advanture!");
            }
            else if (input.equals("2")) {
                System.out.println("You exit the dungeon, successful from your adventure");
                break;
            }
            
        }
        
        System.out.println("########################");
        System.out.println("# THANKS FOR PLAYING ! #");
        System.out.println("########################");
        
    }
    
}
