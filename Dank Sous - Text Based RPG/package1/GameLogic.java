package package1;
import java.util.Scanner;

public class GameLogic {
    static Scanner scanner = new Scanner(System.in);

    static Player player;

    public static boolean isRunning;

    //random encounters
    public static String[] encounters = {"Battle", "Battle", "Battle", "Battle", "Rest"};

    //enemy names
    public static String[] enemies = {"Hellhound", "Hellhound", "Skeleton", "Skeleton", "You (Mimic)"};

    //Story elements
    public static int place = 0, act = 1;
    public static String[] places = {"Valley of the Castle Gate", "The Castle", "The Dungeon", "The Dungeon - Throne Room of the Beast"};







    // the method to get user input from console
    public static int readInt(String prompt, int userChoices) {
        int input;

        do{
            System.out.println(prompt);
            try{
                input = Integer.parseInt(scanner.next());
            } catch (Exception e){
                input = -1;
                System.out.println("Please enter an integer!");
            }
        } while (input < 1 || input > userChoices);

        return input;
    }

    //method to simulate clearing out the console
    public static void clearConsole(){
        for(int i = 0; i < 100; i++)
            System.out.println();
    }

    //method to print a separator with length n
    public static void printSeparator (int n){
        for(int i = 0; i < n; i++)
            System.out.print("-");
        System.out.println();
    }

    //method to print a heading
    public static void printHeading(String title){
        printSeparator(30);
        System.out.println(title);
        printSeparator(30);
    }

    //method to stop the game until user enters anything
    public static void anythingToContinue(){
        System.out.println("\nEnter anything to continue.");
        scanner.next();
    }






    //method to start the game
    public static void startGame(){
        boolean nameSet = false;
        String name;

        //print title screen
        clearConsole();
        printSeparator(40);
        printSeparator(30);
        System.out.println("Dank Souls: Text-Based Java RPG");
        System.out.println("by Sandrian (credit to CodeStudent for inspiration)");
        printSeparator(30);
        printSeparator(40);
        anythingToContinue();

        //getting player name
        do{
            clearConsole();
            printHeading("State your name, Tarnished.");
            name = scanner.next();

            //asking the player if he is sure of his choice
            clearConsole();
            printHeading("Your name is " + name + "\nIs this your choice?");
            System.out.println("(1) Yes.");
            System.out.println("(2) No. I want to change it.");
            int input = readInt("-> ", 2);
            if (input == 1)
                nameSet = true;

        } while(!nameSet);

        //print story Intro
        Story.printIntro();

        //create new player object with given name
        player = new Player(name);

        //print first story act intro
        Story.printFirstActIntro();

        //setting isRunning to true so that the game loop can run.
        isRunning = true;

        //start main game loop
        gameLoop();
    }

    //method that changes the game's values based on player xp
    public static void checkAct(){

        //change acts based on xp
        if(player.xp >= 5 && act == 1){
            //change act and place
            act = 2;
            place = 1;
            //story print
            Story.printFirstActOutro();
            //let the player choose another trait
            player.chooseTrait();
            // display story
            Story.printSecondActIntro();

            //assign new values to enemies
            enemies[0] = "Giant Spider";
            enemies[1] = "Hellhound";
            enemies[2] = "Wendigo";
            enemies[3] = "Son of Beast";
            enemies[4] = "Mercenaries";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Rest";

        } else if (player.xp >= 10 && act == 2){
            //change act and place
            act = 3;
            place = 2;
            //story print
            Story.printSecondActOutro();
            //let the player choose another trait
            player.chooseTrait();
            // display story
            Story.printThirdActIntro();

            //assign new values to enemies
            enemies[0] = "Wendigo";
            enemies[1] = "Wendigo";
            enemies[2] = "Wendigo";
            enemies[3] = "Guardian of the Dungeon";
            enemies[4] = "You (Mimic)";
            //assign new values to encounters
            encounters[0] = "Battle";
            encounters[1] = "Battle";
            encounters[2] = "Battle";
            encounters[3] = "Battle";
            encounters[4] = "Battle";

            //fully heal the player
            //player.hp = player.maxHp;

        } else if (player.xp >= 20 && act == 3){
            //change act and place
            act = 4;
            place = 3;
            //story print
            Story.printThirdActOutro();
            //let the player choose another trait
            player.chooseTrait();
            // display story
            Story.printFourthActIntro();

            //calling the final battle
            finalBattle();
        }
    }

    //method to calculate the random encounter
    public static void randomEncounter(){
        //pick a random number between 0 and the length of the encounters array
        int encounter = (int) (Math.random()* encounters.length);

        //calling the methods relating to the encounter
        if(encounters[encounter].equals("Battle")) {
            randomBattle();
        } else {
            takeRest();
        }

    }


//////////////////

    //method to resume journey
    public static void continueJourney(){

        //check if the act needs to move up
        checkAct();
        //check if the game isnt in the final act
        if (act != 4)
            randomEncounter();

    }

    //method to print out information about player
    public static void characterInfo(){
        clearConsole();
        printHeading("Character Info");
        System.out.println(player.name + "\tHP: " + player.hp + "/" + player.maxHp);
        printSeparator(20);

        //print xp
        System.out.println("XP: " + player.xp);
        printSeparator(20);

        //number of pots
        System.out.println("Number of Potions: " + player.pots);
        printSeparator(20);

        //printing the chosen traits
        if(player.numAtkUpgrades > 0){
            System.out.println("Attack Trait: " + player.atkUpgrades[player.numAtkUpgrades - 1]);
            printSeparator(20);
        }
        if(player.numDefUpgrades > 0){
            System.out.println("Defense Trait: " + player.defUpgrades[player.numDefUpgrades - 1]);
        }

        anythingToContinue();
    }

    //random events: take a rest
    public static void takeRest(){
        clearConsole();
        if (player.restsLeft >= 1 && player.hp < player.maxHp) {
            printHeading("You found the rare opportunity to take a rest. Do you want to do so? (" + player.restsLeft + " rest left).");
            System.out.println("(1) Yes\n(2) No, not right now.");
            int input = readInt("-> ", 2);
            if (input == 1) {
                //player chooses to take rest
                clearConsole();
                if (player.hp < player.maxHp) {
                    int hpRestored = (int) (Math.random() * (player.xp / 4 + 1) + 7);
                    player.hp += hpRestored;
                    if (player.hp > player.maxHp)
                        player.hp = player.maxHp;
                    System.out.println("You have taken a rest and restored " + hpRestored + " health.");
                    System.out.println("You're now at " + player.hp + "/" + player.maxHp + " health.");
                    player.restsLeft--;
                    anythingToContinue();

                }
            } else {
                clearConsole();
                System.out.println("You have chosen not to take a rest. You will then continue with your journey.");
                anythingToContinue();
            }
        } else if (player.restsLeft >= 1) {
            System.out.println("You've found the rare opportunity to take a rest. Unfortunately, you're at full health. You do not need rest.");
            anythingToContinue();

        } else {
            System.out.println("You've found the rare opportunity to take a rest. Unfortunately, you have " + player.restsLeft + " rests left, you cannot take a rest.");
            anythingToContinue();
        }

    }


    //creating the random battle method
    public static void randomBattle(){
        clearConsole();
        printHeading("You encountered an enemy. It's time to fight.");
        anythingToContinue();

        //creating new enemy with random name
        battle(new Enemy(enemies[ (int) (Math.random() * enemies.length)], player.xp));
    }

    //the main battle method that sets the battle system
    public static void battle(Enemy enemy){
        //main battle looping
        while (true){
            clearConsole();
            printHeading(enemy.name + "\nHP: " + enemy.hp + "/" + enemy.maxHp);
            printHeading(player.name + "\nHP: " + player.hp + "/" + player.maxHp);
            System.out.println("Choose your action.");
            printSeparator(20);
            System.out.println("(1) Fight \n(2) Use Potion \n(3) Run Away");
            int input = readInt("-> ", 3);

            //if else for which input the player uses
            if (input == 1){
                //player chooses to fight / calculate the damage and damage taken from the enemy
                int dmg = player.attack() - enemy.defend();
                int dmgTook = enemy.attack() - player.defend();

                //check if the damage isnt negative
                if (dmgTook < 0) {
                    //add damage if player defends good
                    dmg -= dmgTook/2;
                    dmgTook = 0;
                }
                if (dmg < 0)
                    dmg = 0;

                //deal damage to both parties
                player.hp -= dmgTook;
                enemy.hp -= dmg;

                //print the results of this battle round
                clearConsole();
                printHeading("Battle:");
                System.out.println("You dealt " + dmg + " damage to the " + enemy.name + ".");
                printSeparator(15);
                System.out.println("The " + enemy.name + " dealt " + dmgTook + " damage to you.");
                anythingToContinue();

                if (act != 4){
                    //check if player is still alive or is dead
                    if (player.hp <= 0) {
                        playerDied(); //method to end the game once player dies
                        break;
                    } else if (enemy.hp <= 0){
                        //tell the player they won
                        clearConsole();
                        printHeading("You defeated the " + enemy.name + ".");
                        player.xp += enemy.xp;
                        System.out.println("You earned " + enemy.xp + " XP!");
                        anythingToContinue();
                        break;
                    }

                } else { //else statement for when act = 4
                    if (player.hp <= 0) { //instead of telling the player died, this breaks the loop and moves out of battle() in finalBattle() method
                        break;
                    } else if (enemy.hp <= 0){
                        //tell the player they won
                        clearConsole();
                        printHeading("You defeated the " + enemy.name + ".");
                        player.xp += enemy.xp;
                        System.out.println("You earned " + enemy.xp + " XP!");
                        anythingToContinue();
                        break;
                    }
                }

            } else if (input == 2){
                //use potion
                clearConsole();
                if (player.pots > 0 && player.hp < player.maxHp){
                    //the player is able to take the potion and ask if player is sure to want to take the potion
                    printHeading("Do you want to drink a potion? (" + player.pots + " left.)");
                    System.out.println("(1) Yes\n(2) No, maybe later.");
                    input = readInt("-> ", 2);
                    if (input == 1){
                        //player chooses to take the potion
                        player.hp = player.maxHp;
                        clearConsole();
                        printHeading("You drank your potion. Health restored back to " + player.maxHp);
                        player.pots--;
                        anythingToContinue();
                    }

                } else {
                    //player can't take potion
                    printHeading("You don't have any potions or you're at full health.");
                    anythingToContinue();
                }

            } else {
                //player chooses to run away
                clearConsole();
               //check if the act is in the last battle or not
                if (act != 4){
                    //chance of 35% to escape
                    if (Math.random() * 10 + 1 <= 3.5){
                        printHeading("You ran away from the " + enemy.name + ".");
                        anythingToContinue();
                        break;
                    } else{
                        printHeading("You failed to escape successfully.");
                        //calculate the damage the player took
                        int dmgTook = enemy.attack();
                        player.hp -= dmgTook;
                        System.out.println("In your attempt to flee, you took " + dmgTook + " damage.");
                        anythingToContinue();
                        //check if player is still alive
                        if (player.hp <= 0)
                            playerDied();
                            break;

                    }
                } else {
                    printHeading("The path behind is blocked, there is no escape from the Elden Beast.");
                    anythingToContinue();
                }

            }
        }

    }


    //printing the main menu
    public static void printMenu(){
        clearConsole();
        printHeading(places[place]);
        System.out.println("Choose an action: ");
        printSeparator(20);
        System.out.println("(1) Resume Journey");
        System.out.println("(2) View Character Info");
        System.out.println("(3) Exit Game");
    }

    //method to call the final battle of the game
    public static void finalBattle(){

        //creating the Elden Beast and letting the player fight against them.
        battle(new Enemy("Elden Beast", 70));

        if (player.hp <= 0){
            playerDied(); //method to end the game once player dies
        } else
            //printing the proper ending
            Story.printEnd(player);
        isRunning = false;
    }

    //method used for when the player dies
    public static void playerDied(){
        clearConsole();
        printHeading("YOU ARE DEAD");
        printHeading("You earned " + player.xp + " XP on your journey.");
        System.out.println("Thank you for playing this game. Credit to CodeStudent.");
        isRunning = false;
    }


    //main game loop
    public static void gameLoop(){
        while (isRunning){
            printMenu();
            int input = readInt("-> ", 3);
            if (input == 1)
                continueJourney();
            else if (input == 2)
                characterInfo();
            else
                isRunning = false;
        }
    }

}
