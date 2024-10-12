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
    


    //ENEMY/PLAYER PRESETS
    static Preset pre1 = new Preset("Enemy Barbarian", "ORC", "BARBARIAN", false);
    static Preset pre2 = new Preset("Enemy Mage", "ELF", "MAGE", false);
    static Preset pre3 = new Preset("Enemy Figther", "HUMAN", "FIGHTER", false);

    //PLAER PRESETS FOR TESTING
    static Preset pre4 = new Preset("EJACULUS", "ELF", "MAGE", true);
    static Preset pre5 = new Preset("GROGU", "ORC", "BARBARIAN", true);
    static Preset pre6 = new Preset("CABLE", "HUMAN", "ASSASSIN", true);

    public static void main(String[] args){
        //The players party- it's an array of with their characters
        ArrayList<Character> party = new ArrayList();
        Character player1;
        Character player2;
        Character player3;
        //The enemy party- it's an array of enemy characters
        ArrayList<Character> enemies = new ArrayList();
        Character enemy1 = null;
        Character enemy2 = null;
        Character enemy3 = null;
        //All characters stored here so that user can select anyone in combat;
        ArrayList<Character> allEntities = new ArrayList();
        //Counts the number of characters that can be selected at the moment
        int characters = 0;
        int numPlayers = 0;
        int numEnemies = 0;
        int selected = 0;

        //Player is in a fight
        boolean fighting = false;

        
        /*
        Preset pre = new Preset("Phil Tok", "HUMAN", "BARBARIAN");
        Character phil = new Character(pre);
        xo.displayCharacterData();
        */
        
        //Launch sequence
        System.out.println(" ");
        System.out.println("Welcome to jaRPG! Primarily developed by Marvin Kelly,\n" + 
        "developed by Caleb Chew, RJ and Kong.\n" +
        "\n" + 
        "To get started, here are a couple usefulcommands:\n");
        System.out.println(" ");
        help();
        //If you're using presets for player characters, uncomment the next 6 liens:
        player1= new Character(pre4);
        player2= new Character(pre5);
        player3= new Character(pre6);
        party.addAll(Arrays.asList(player1, player2, player3));
        allEntities.addAll(party);
        characters += 3;


        //Game Loop
        boolean playing = true;
        while(playing){
            String uInput;
            uInput = cin();
            uInput = uInput.toUpperCase(); //This means that commands can be run without them having to be input as all uppercase by the user
            switch(uInput){
                case "HELP":
                    help();
                break;
                case "CREATE":
                    switch(characters){
                        case 0:
                        player1 = new Character();
                        party.add(player1);
                        allEntities.add(player1);
                        characters++;
                        break;
                        case 1:
                        player2 = new Character();
                        party.add(player2);
                        allEntities.add(player2);
                        characters++;
                        break;
                        case 2:
                        player3 = new Character();
                        party.add(player3);
                        allEntities.add(player3);
                        characters++;
                        break;
                        default:
                        System.out.println("You already have 3 players!!");
                        break;
                    }
                break;
                case "SELECT":
                    if(allEntities.size() < 1){
                        System.out.println("There are no characters! (use CREATE)");
                        break;
                    }
                    int selection;
                    boolean invalid = true;
                    while(invalid){

                        System.out.println("Who do you want to select?");

                        //Displays all of the avaliable characters to select
                        for(int i = 0; i < characters; i++){
                            System.out.println("( " + allEntities.get(i).name + " = " + (i + 1) + ")");
                        }
                        selection = Integer.valueOf(cin());

                        //Checks if selction if valid, loops if not
                        if(selection > 0 && selection <= characters){
                            selected = selection - 1;
                            System.out.println(allEntities.get(selected).name + " is selected");
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
                        allEntities.get(selected).charInventory.display();
                    }
                break;
                case "SHOW STATS":
                    if(checkForCharacters(party)){
                        allEntities.get(selected).displayCharacterData();
                    }
                break;
                case "EQUIP":
                    if(!getSelectedCharacterType(allEntities.get(selected))){
                        System.out.println("Enemy is currently selected!");
                    }
                    else if(checkForCharacters(party)){ //This action should only be performable for playable characters, check if it's a player
                        System.out.println("What do you want to equip?");

                        allEntities.get(selected).charInventory.equip();
                    }
                break;
                case "START":
                if(checkForCharacters(party)){
                    fighting = true;
                    characters += 3;
                    loadTestScenario(enemies, allEntities, enemy1, enemy2, enemy3);
                    
                    /*
                    for(int i = 0; i < party.size(); i++){
                        allEntities.add(party.get(i));
                    }
                    for(int i = 0; i < enemies.size(); i++){
                        allEntities.add(enemies.get(i));
                    }
                     */
                }
                break;
                case "QUIT":
                    playing = false;
                break;
                    
            }

        }

    }

    static public void help(){
        System.out.println("\n" +
        "HELP -> shows this list again\n" +
        "CREATE -> starts the character creator (you should use this now)\n" +
        "SELECT -> allows you to select a character\n" +
        "SHOW INV -> displays the inventory of the selected character\n" +
        "SHOW STATS -> displays the character sheet of the selected character\n" +
        "EQUIP -> equips an item from your inventory\n" +
        "START -> starts combat!\n" +
        "QUIT -> ends program\n" +
        "\n");
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

    public static void loadTestScenario(ArrayList<Character> enemyList, ArrayList<Character> allList, Character enemy1, Character enemy2, Character enemy3){
        enemy1 = new Character(pre1);
        enemy2 = new Character(pre2);
        enemy3 = new Character(pre3);
        enemyList.addAll(Arrays.asList(enemy1, enemy2, enemy3));
        allList.addAll(enemyList);
    }

    public static boolean getSelectedCharacterType(Character selected){
        if(selected.player){
            return true;
        }
        return false;
    }
}