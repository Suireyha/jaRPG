import java.util.Scanner;  //Import Scanner object for reading user input
import java.util.ArrayList; //Import ArrayList
import java.util.Collection;



public class Main{
    //IF YOU WANT TO CREATE NEW ITEMS, DO IT HERE!!!

    //Swords
    static Item steelSword = new Item(Item.Type.MELEE, "Steel Sword", "A hardy sword, made of fine steel! (+2 Strength)", 2, 0, 1, 0);
    static Item woodSword = new Item(Item.Type.MELEE, "Wooden Sword", "A shabby sword, crudely build from wood (+1 Strength)", 1, 0, 0, 0);

    //Daggers
    static Item shankDagger = new Item(Item.Type.MELEE, "Shank", "A small, crude, makeshift blade. (+1 Strength)", 1, 0, 0, 0);
    Item kitchenKnifeDagger = new Item(Item.Type.MELEE, "Kitchen Knife", "DIE DIE DIE DIE DIE !! DIE DIE ! (+4 Strength, -1 All Stats", 3, -1, -1, -1);

    //Staffs
    static Item woodStaff = new Item(Item.Type.RANGED, "Wooden Staff", "It's pretty much just a branch with magical powers... (+1 Widsom)", 0, 1, 0, 0);
    Item crystalStaff = new Item(Item.Type.RANGED, "Crystal Staff", "A beautiful staff built from some kind of magical crystal. It glows with power! (+5 Wisdom)", 0, 5, 0, 0);

    //Armour
    static Item ragsArmor = new Item(Item.Type.EQUIPABLE, "Rags", "A half broken dirt set of rags...", 0, 0, 0, 0);
    static Item leatherArmor = new Item(Item.Type.EQUIPABLE, "Leather Armor", "A simple set of armour, made of leather. (+1 Constutution)", 0, 0, 1, 0);

    //Potions
    static Item healthPotion = new Item(Item.Type.POTION, "Potion of Health", "A potion of red fluid. (Recovers 5 HP)", 5, 0);
    static Item ragePotion = new Item(Item.Type.POTION, "Potion of Rage", "It glows a pulsing orange..? (Next Attack does +5 DMG)", 0, 5);
    

    public static void main(String[] args){
        /*
        Preset pre = new Preset("Phil Tok", "HUMAN", "BARBARIAN");
        Preset pre2 = new Preset("Orculus", "ORC", "MAGE");
        
        
        Character xo = new Character(pre);
        xo.displayCharacterData();
        

        Character xx = new Character(pre2);
        xx.displayCharacterData();
        */
        

        Character player1 = new Character();
        player1.displayCharacterData();

        System.out.println(" ");
        System.out.println(" ");
        System.out.println(player1.charInventory.items.get(0).name);
        System.out.println(player1.charInventory.items.get(1).name);
        System.out.println(player1.charInventory.items.get(2).name);
        //Note that since the Character class is unfinished, these are all unstable and own't work if Class != MAGE

    }

    public static String cin(){
        Scanner term = new Scanner(System.in);  // Create a Scanner object
        String uInput = term.nextLine();  // Read user input
        //term.close(); //Avoid a memory leak lmao
        return uInput;
    }

}