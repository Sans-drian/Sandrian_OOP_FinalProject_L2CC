package package1;

public abstract class Character {

    // The attributes of a character
    public String name;
    public int maxHp, hp, xp;

    //constructor for character
    public Character(String name, int maxHp, int xp){
        this.name = name;
        this.maxHp = maxHp;
        this.xp = xp;
        this.hp = maxHp;
    }

    //main methods/functions of the character
    public abstract int attack();
    public abstract int defend();

}
