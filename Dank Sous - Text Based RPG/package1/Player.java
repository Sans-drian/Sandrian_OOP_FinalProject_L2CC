package package1;

public class Player extends Character{

    //ints to store number of upgrades/skills in each path
    public int numAtkUpgrades, numDefUpgrades;

    //additional player stats
    int pots ,restsLeft;

    //array that stores skill names
    public String[] atkUpgrades = {"Increased Strength", "Increased Dexterity", "Might", "Godlike Strength"};
    public String[] defUpgrades = {"Increased Defence", "Attack Resistance", "Holy Knight Armor", "A God's Blessing"};

    //player specific constructor
    public Player(String name) {
        //calling constructor of superclass
        super(name, 20, 0);
        //Setting # of upgeades to 0
        this.numAtkUpgrades = 0;
        this.numDefUpgrades = 0;
        //set the additional stats
        this.restsLeft = 1;
        this.pots = 3;
        //let the player choose trait when creating character
        chooseTrait();

    }

    //override the superclass methods for specific methods in player.java
    @Override
    public int attack() {
        return (int) (Math.random() * (xp / 4 + numAtkUpgrades * 3 + 3) + xp / 10 + numAtkUpgrades * 2 + numDefUpgrades + 1);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (xp / 2 + numDefUpgrades * 3 + 3) + xp / 10 + numDefUpgrades * 2 + numAtkUpgrades + 1);
    }

    //make player choose traits
    public void chooseTrait(){
        GameLogic.clearConsole();
        GameLogic.printHeading("Choose a trait: ");
        System.out.println("(1) " + atkUpgrades[numAtkUpgrades]);
        System.out.println("(2) " + defUpgrades[numDefUpgrades]);

        //get player's choice
        int input = GameLogic.readInt("-> ", 2);
        GameLogic.clearConsole();
        //deal with both cases
        if (input == 1){
            GameLogic.printHeading("You chose " + atkUpgrades[numAtkUpgrades] + "!");
            numAtkUpgrades++;
        } else{
            GameLogic.printHeading("You chose " + defUpgrades[numDefUpgrades] + "!");
            numDefUpgrades++;
        }

        GameLogic.anythingToContinue();
    }

}
