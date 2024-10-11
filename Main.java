import java.util.Scanner;  //Import Scanner object for reading user input
import java.util.ArrayList; //Import ArrayList
import java.util.Collection;
import java.util.Arrays; //For addAll();



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
        //Maximum of 3 players that the player can use
        ArrayList<Character> party = new ArrayList();
        Character player1;
        Character player2;
        Character player3;
        //Counts the number of characters that can be selected at the moment
        int characters = 0;
        int selected = 0;

        
        /*
        Preset pre = new Preset("Phil Tok", "HUMAN", "BARBARIAN");
        Character phil = new Character(pre);
        xo.displayCharacterData();
        */
        
        //Launch sequence
        System.out.println(" ");
        System.out.println("Welcome to jaRPG! Currently only developed by Marvin Kelly,\n" + 
        "but in theory Caleb Chew, RJ and Kong will work on this soon.\n" + 
        "To get started, here are a couple usefulcommands:\n");
        help();
        

        //Game Loop
        boolean playing = true;
        while(playing){
            String uInput;
            uInput = cin();

            switch(uInput){
                case "HELP":
                    help();
                break;
                case "CREATE":
                    switch(characters){
                        case 0:
                        player1 = new Character();
                        party.add(player1);
                        characters++;
                        break;
                        case 1:
                        player2 = new Character();
                        party.add(player2);
                        characters++;
                        break;
                        case 2:
                        player3 = new Character();
                        party.add(player3);
                        characters++;
                        break;
                        default:
                        System.out.println("You already have 3 players!!");
                        break;
                    }
                break;
                case "SELECT":
                    int selection;
                    boolean invalid = true;
                    while(invalid){

                        System.out.println("Who do you want to select?");

                        //Displays all of the avaliable characters to select
                        for(int i = 0; i < characters; i++){
                            System.out.println("( " + party.get(i).name + " = " + (i + 1) + ")");
                        }
                        selection = Integer.valueOf(cin());

                        //Checks if selction if valid, loops if not
                        if(selection > 0 && selection <= characters){
                            selected = selection - 1;
                            System.out.println(party.get(selected).name + " is selected");
                            invalid = false;
                        }

                        else{
                            //Gives an error message if the reason is because there are no characters
                            if(checkForCharacters(party));
                            else{
                                System.out.println("Invalid selection!");
                            }
                            
                        }
                    }
                

                break;
                case "SHOW INV":
                    if(checkForCharacters(party)){
                        party.get(selected).charInventory.display();
                    }
                break;
                case "SHOW STATS":
                    if(checkForCharacters(party)){
                        party.get(selected).displayCharacterData();
                    }
                break;
                case "QUIT":
                    playing = false;
                break;
                    
            }

        }

    }

    static public void help(){
        System.out.println("HELP -> shows this list again\n" +
        "CREATE -> starts the character creator (you should use this now)\n" +
        "SELECT -> allows you to select a character\n" +
        "SHOW INV -> displays the inventory of the selected character\n" +
        "SHOW STATS -> displays the character sheet of the selected character\n" +
        "QUIT -> ends program\n");
    }

    public static boolean checkForCharacters(ArrayList<Character> party){
        //If there are no Characters, return false
        if(party.size() < 1){
            System.out.println("There are no characters!");
            return false;
        }
        return true;
    }

    public static String cin(){
        Scanner term = new Scanner(System.in);  // Create a Scanner object
        String uInput = term.nextLine();  // Read user input
        //term.close(); //Avoid a memory leak lmao
        return uInput;
    }

}