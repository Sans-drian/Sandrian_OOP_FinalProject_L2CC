package package1;

//class that stores the methods of displaying the parts of the story
public class Story {

    public static void printIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("The Story");
        GameLogic.printSeparator(30);
        System.out.println("You awaken in a cave. Besides you is a bonfire with a sword stuck into it. You remember that you need to embark on a journey to defeat the Elden Beast. The strongest Beast known the man.");
        System.out.println("You do not know what you are. All you know is that you've been assigned to this journey. For whatever reason, you cannot remember anything else about yourself, but you do not question it.");
        System.out.println("As you walk towards the light leading outside of the tunnel, a hooded figure stands at the edge of the cave entrance. You approach them. Wind gushes upon and the hooded figure reaches out to you.");
        System.out.println("");
        System.out.println("Good morning, I am The Giver. I've come here to bestow a trait upon you. You will choose those that will help you in your struggles. Unfortunately, these traits do not last.");
        System.out.println("After each Act, you will be granted the will to choose another Trait. Croaks the hooded figure.");
        System.out.println("You walk slowly towards them and give your hand.");
        GameLogic.anythingToContinue();

    }

    public static void printFirstActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 1");
        GameLogic.printSeparator(30);
        System.out.println("After inquiring your new trait, you start to move forward.");
        System.out.println("You enter the land known as The Valley of the Castle Gate. Past here is The Castle, which is the path you'll be taking to the Elden Beast.");
        System.out.println("However, There bares a barrier in between those two places and it can only be broken once you reach 5 XP. Defeat enemies and gain XP. That is the only way.");
        System.out.println("Getting ready to fight, you check your inventory to confirm the 3 potions of healing you've stored. Once done, you begin your journey.");
        GameLogic.anythingToContinue();

    }

    public static void printFirstActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 1 - End");
        GameLogic.printSeparator(30);
        System.out.println("You've survived. And you've gained 5 XP. The barrier fades away and you are now able to proceed forward towards The Castle.");
        System.out.println("The hooded figure appears,");
        System.out.println("I've come to bestow a trait yet again. You can be granted the ability to choose more than one traits. Choose now.");
        System.out.println("You give your hand out once again.");
        GameLogic.anythingToContinue();

    }

    public static void printSecondActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 2");
        GameLogic.printSeparator(30);
        System.out.println("Now continues your journey in The Castle. The next level you need to reach is The Dungeon which is blocked by a barrier as well. To get past, you will need to 10XP.");
        System.out.println("The castle is vast but has small corridors. Lurking inside those corridors are blood thirsty enemies waiting to attack you. You proceed into the other parts of The Castle, hoping to find more enemies to slay.");
        System.out.println("Somehow The Castle feels more cramped than it actually looks, despite it being large on the outside, but alas this does not stop you. You continue your journey.");
        GameLogic.anythingToContinue();

    }

    public static void printSecondActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 2 - End");
        GameLogic.printSeparator(30);
        System.out.println("You've managed to survive again. You've reached the required 10 XP to remove the barrier to The Dungeon. Right before you enter, the mysterious hooded figure shows up again.");
        System.out.println("Again, they offer you 2 more traits that you can use for yourself. You give out your hand once more.");
        GameLogic.anythingToContinue();

    }

    public static void printThirdActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 3");
        GameLogic.printSeparator(30);
        System.out.println("You've made your way down the dark stairway and have arrived in The Dungeon.");
        System.out.println("You see rats everywhere and prison cells that still contain the remnants of the prisoners. The only thing keeping this place visible is a bunch of torches hung on the wall, it's almost very dark in here.");
        System.out.println("Reluctant to finish your journey, you proceed forward. Once again, the barrier stops you from entering The Dungeon's Throne Room of the Beast, where the Elden Beast resides. For this, you will need 20 XP to continue.");
        GameLogic.anythingToContinue();

    }

    public static void printThirdActOutro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 3 - End");
        GameLogic.printSeparator(30);
        System.out.println("You've made it. You've survived the creatures in the dungeon and have successfully gained 20 XP. As the barrier opens, you are greeted with a dark narrow corridor, leading to The Throne Room of the Beast.");
        System.out.println("Before entering the final area, you are once again and for the last time, greeted with the hooded figure. It has come one last time to bestow a trait upon you.");
        System.out.println("");
        System.out.println("So you've made it to your destination I see. You're almost at the end. Again, you know what I'm here for.");
        System.out.println("");
        System.out.println("You reach your hand out once again.");
        GameLogic.anythingToContinue();

    }

    public static void printFourthActIntro(){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("Act 4");
        GameLogic.printSeparator(30);
        System.out.println("It is now time to reach the final area. The Throne Room of the Beast. It is a wide and vast area, almost unbelievable that you're still in a dungeon. It's almost as if you've reached the outside world.");
        System.out.println("Despite a large area, there's almost no one else here and it is very quiet. You approach very slowly, getting ready for what's to come.");
        System.out.println("Suddenly, a huge black hole like blob appears out of the ground. Coming out of that black hole blob is the Elden Beast. It's huge. It almost filled up the entire room and you almost got crushed if you hadn't moved away before");
        System.out.println("It has finally come out, this is the moment you've been waiting for. After this, your journey will come to an end.");
        GameLogic.anythingToContinue();

    }

    public static void printEnd(Player player){
        GameLogic.clearConsole();
        GameLogic.printSeparator(30);
        System.out.println("The End");
        GameLogic.printSeparator(30);
        System.out.println("You've defeated the Elden Beast. Suddenly, the surrounding starts to flash and a blinding light appears. You find yourself in a grassy field under bright blue skies. It's peaceful");
        System.out.println("The hooded figure appears again.");
        System.out.println("");
        System.out.println("You did it. You've defeated him. Now the curse upon the land has been lifted. No more will we be suffering in that retched place. Thank you, " + player.name + ".");
        System.out.println("");
        System.out.println("You feel relieved. You now understand why you've been set upon your journey. You take a sit down on the grassy field and start to admire the beautiful sky. You feel tired and it's time to rest, knowing that you've finished your journey.");
        System.out.println("");
        System.out.println("Thank you for playing this game. Credit to CodeStudent.");
        //GameLogic.anythingToContinue();

    }
}
