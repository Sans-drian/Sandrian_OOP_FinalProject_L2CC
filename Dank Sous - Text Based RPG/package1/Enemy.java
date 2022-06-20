package package1;

public class Enemy extends Character {

    //variable to store the player's current xp
    int playerXp;

    //enemy specific constructor
    public Enemy(String name, int playerXp) {
        super(name, (int) (Math.random() * playerXp + playerXp / 3 + 5), (int) (Math.random() * (playerXp / 4 + 2) + 1));
        //assign variable
        this.playerXp = playerXp;
    }

    //override the superclass methods for specific methods in enemy.java
    @Override
    public int attack() {
        return (int) (Math.random() * (playerXp / 4 + 1) + xp / 4 + 3);
    }

    @Override
    public int defend() {
        return (int) (Math.random() * (playerXp / 4 + 1) + xp / 4 + 3);
    }
}
