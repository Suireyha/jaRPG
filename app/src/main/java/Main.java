import java.util.ArrayList;  //Import Scanner object for reading user input
import java.util.Arrays; //Import ArrayList
import java.util.Collections;
import java.util.Scanner; //For addAll();

public class Main{
    // Constants for maximum players
    private static final int MAX_PLAYERS = 3;
    
    static Item fists = new Item(Item.Type.MELEE, "Fists", "I WILL BREAK YOU WITH MY BARE HANDS!", 0, 0, 0, 0);

    //Swords
    static Item steelSword = new Item(Item.Type.MELEE, "Steel Sword", "A hardy sword, made of fine steel! (+2 Strength)", 2, 0, 1, 0);
    static Item woodSword = new Item(Item.Type.MELEE, "Wooden Sword", "A shabby sword, crudely build from wood (+1 Strength)", 1, 0, 0, 0);

    //Daggers
    static Item shankDagger = new Item(Item.Type.MELEE, "Shank", "A small, crude, makeshift blade. (+1 Strength)", 1, 0, 0, 0);
    static Item kitchenKnifeDagger = new Item(Item.Type.MELEE, "Kitchen Knife", "DIE DIE DIE DIE DIE !! DIE DIE ! (+4 Strength, -1 All Stats", 3, -1, -1, -1);

    //Staffs
    static Item woodStaff = new Item(Item.Type.MAGIC, "Wooden Staff", "It's pretty much just a branch with magical powers... (+1 Widsom)", 0, 1, 0, 0);
    static Item crystalStaff = new Item(Item.Type.MAGIC, "Crystal Staff", "A beautiful staff built from some kind of magical crystal. It glows with power! (+5 Wisdom)", 0, 5, 0, 0);

    //Armour
    static Item ragsArmor = new Item(Item.Type.ARMOUR, "Rags", "A half broken dirt set of rags...", 0, 0, 0, 0);
    static Item leatherArmor = new Item(Item.Type.ARMOUR, "Leather Armor", "A simple set of armour, made of leather. (+1 Constutution)", 0, 0, 1, 0);

    //Potions
    static Item healthPotion = new Item(Item.Type.POTION, "Potion of Health", "A potion of red fluid. (Recovers 5 HP)", 5, false);
    static Item ragePotion = new Item(Item.Type.POTION, "Potion of Rage", "It glows a pulsing orange..? (Next Attack does +5 DMG)", 0, true);
    


    //ENEMY/PLAYER PRESETS
    static Preset pre1 = new Preset("Enemy Barbarian", "ORC", "BARBARIAN", false);
    static Preset pre2 = new Preset("Enemy Mage", "ELF", "MAGE", false);
    static Preset pre3 = new Preset("Enemy Figther", "HUMAN", "FIGHTER", false);

    //PLAYER PRESETS FOR TESTING
    static Preset pre4 = new Preset("EJACULUS", "ELF", "MAGE", true);
    static Preset pre5 = new Preset("GROGU", "ORC", "BARBARIAN", true);
    static Preset pre6 = new Preset("CABLE", "HUMAN", "ASSASSIN", true);

    public static void main(String[] args){
        //The players party- it's an array of with their characters
        ArrayList<Character> party = new ArrayList<>();
        Character player1;
        Character player2;
        Character player3;
        //The enemy party- it's an array of enemy characters
        ArrayList<Character> enemies = new ArrayList<>();
        Character enemy1 = null;
        Character enemy2 = null;
        Character enemy3 = null;
        //All characters stored here so that user can select anyone in combat;
        ArrayList<Character> allEntities = new ArrayList<>();
        ArrayList<Character> orderedCharacters = new ArrayList<>();
        //Counts the number of characters that can be selected at the moment
        int characters = 0;
        int numPlayers = 0;
        int numEnemies = 0;
        int selected = 0;
        int selectedForAttack = 0;
        int turn = 0;

        //Player is in a fight
        boolean fighting = false;

        
        /*
        Preset pre = new Preset("Phil Tok", "HUMAN", "BARBARIAN");
        Character phil = new Character(pre);
        xo.displayCharacterData();
        */
        
        //Launch sequence
        System.out.println(" ");
        System.out.println("Welcome to jaRPG! Primarily developed by Marvin Kelly, developed by Caleb Chew, RJ and Kong. To get started, here are a couple useful commands:");
        System.out.println(" ");
        help();
        //If you're using presets for player characters, uncomment the next 6 liens:
        player1 = new Character(pre4);
        player2 = new Character(pre5);
        //player3= new Character(pre6);
        party.addAll(Arrays.asList(player1, player2));
        allEntities.addAll(party);
        characters += 2;


        //Game Loop
        boolean playing = true;
        while(playing){

            //Enemy turn logic here
            if(fighting && !orderedCharacters.get(turn).player){
                if((orderedCharacters.get(turn).health < orderedCharacters.get(turn).maxHealth/2) && orderedCharacters.get(turn).charInventory.has(healthPotion)){
                    orderedCharacters.get(turn).charInventory.usePotion(healthPotion);
                }
                
                orderedCharacters.get(turn).attack(party.get(rand(0, party.size() - 1)));
                turn++;
                turn %= characters;
                displayTurn(orderedCharacters.get(turn));
                if(orderedCharacters.get(turn).player){
                    for(int i = 0; i < party.size(); i++){
                        if(orderedCharacters.get(turn) == party.get(i)){
                            selected = i;
                        }
                    }
                }
            }

            // Automatically select the player character on their turn
            if(fighting && orderedCharacters.get(turn).player){
                for(int i = 0; i < party.size(); i++){
                    if(orderedCharacters.get(turn) == party.get(i)){
                        selected = i;
                        System.out.println(party.get(selected).name + "'s next action will be:");
                    }
                }
            }

            //Win/Loss handling
            if(fighting && enemies.size() < 1){
                System.out.println("CONGRATULATIONS!!! You defeated the enemy party!");
                fighting = false;
                //call some reset function that resets everything
            }
            if(fighting && party.size() < 1){
                System.out.println("You lost...");
                fighting = false;
                //call some reset function that resets everything
            }

            //updateCharacterLists(allEntities,party,enemies,orderedCharacters,turn,characters);

            String uInput;
            if(fighting && orderedCharacters.get(turn).player == false){
                uInput = " ";
            }
            else{
                uInput = cin();
                uInput = uInput.toUpperCase(); //This means that commands can be run without them having to be input as all uppercase by the user
            }   
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
                        selection = validIntegerInput(1, characters);

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
                    if(checkForCharacters(allEntities)){
                        allEntities.get(selected).charInventory.display();
                    }
                break;
                case "SHOW STATS":
                    if(checkForCharacters(allEntities)){
                        allEntities.get(selected).displayCharacterData();
                    }
                break;
                case "EQUIP":
                    if(!getSelectedCharacterType(allEntities.get(selected))){
                        System.out.println("Enemy is currently selected!");
                    }
                    else if(checkForCharacters(party)){ //This action should only be performable for playable characters, check if it's a player
                        System.out.println("What do you want to equip?");

                        party.get(selected).charInventory.equip();
                    }
                break;
                case "START":
                if(checkForCharacters(party) && !fighting){
                    fighting = true;
                    characters += 3;
                    loadTestScenario(enemies, allEntities, enemy1, enemy2, enemy3);
                    for(int i = 0; i < allEntities.size(); i++){
                        allEntities.get(i).rollInitiative();
                        orderedCharacters.add(allEntities.get(i));
                    }
                    
                    setOrder(orderedCharacters);
                }
                break;
                case "ATTACK":
                if(!fighting){
                    System.out.println("Not currently in engagement");
                    break;
                }
                if(!getSelectedCharacterType(allEntities.get(selected))){
                    System.out.println("Enemy is currently selected!");
                }
                else if(allEntities.get(selected) != orderedCharacters.get(turn)){
                    System.out.println("It's not this character's turn!");
                }
                else if(checkForCharacters(party) && fighting){
                    //Check who's turn it is after initiative is added
                    boolean invalidS = true;
                    while(invalidS){
                        //Display avaliable enemies
                        System.out.println("Select an Enemy:");
                        for(int i = 0; i < enemies.size(); i++){
                            System.out.println("( " + enemies.get(i).name + " = " + (i + 1) + ")");
                        }
                        selectedForAttack = validIntegerInput(1, enemies.size()) - 1;

                        //Checks if selction if valid, loops if not
                        if(selectedForAttack >= 0 && selectedForAttack  < enemies.size()){
                            System.out.println(allEntities.get(selected).name + " is selected");
                            invalidS = false;
                        }
                    }
                    //Do the attack
                    party.get(selected).attack(enemies.get(selectedForAttack));
                    turn++;
                    turn %= characters;
                    displayTurn(orderedCharacters.get(turn));
                }
                break;
                case "USE":
                if(!getSelectedCharacterType(allEntities.get(selected))){
                    System.out.println("Enemy is currently selected!");
                }
                else if(checkForCharacters(party)){
                    party.get(selected).charInventory.usePotion();
                }
                break;
                case "QUIT":
                    playing = false;
                break;
                default:
                //Do nothing
                break;
                    
            }

            //Make sure all the data is up to date
            for(int i = 0; i < allEntities.size(); i++){
                if(!allEntities.get(i).alive){
                    allEntities.remove(i);
                    characters--;
                    // Adjust turn if necessary
                    if(turn >= i) {
                        turn--; // Decrement turn if it points to a removed character
                    }
                    i--; // Decrement i to account for the removed element
                }
            }

            for(int i = 0; i < party.size(); i++){
                if(!party.get(i).alive){
                    party.remove(i);
                    // Adjust turn if necessary
                    if(turn >= i) {
                        turn--; // Decrement turn if it points to a removed character
                    }
                    i--; // Decrement i to account for the removed element
                }
            }

            for(int i = 0; i < enemies.size(); i++){
                if(!enemies.get(i).alive){
                    enemies.remove(i);
                }
            }

            for(int i = 0; i < orderedCharacters.size(); i++){
                if(!orderedCharacters.get(i).alive){
                    if(turn >= i){
                        turn--; // Decrement turn if it points to a removed character
                    }
                    orderedCharacters.remove(i);
                    i--; // Decrement i to account for the removed element
                }
            }

            // Ensure turn is not negative
            if(turn < 0 && !orderedCharacters.isEmpty()) {
                turn = 0; // Reset turn to 0 if it goes negative
            }

        }

        

    }

    static public void help() {
        System.out.println("""

            HELP -> shows this list again
            CREATE -> starts the character creator (you should use this now)
            SELECT -> allows you to select a character
            SHOW INV -> displays the inventory of the selected character
            SHOW STATS -> displays the character sheet of the selected character
            EQUIP -> equips an item from your inventory
            START -> starts combat
            ATTACK -> the character in turn can attack an enemy
            USE -> allows you to use an item from your inventory
            QUIT -> ends program

            """);
    }

    public static boolean checkForCharacters(ArrayList<Character> party){
        //If there are no Characters, return false
        if (party.isEmpty()) {
            System.out.println("There are no characters!");
            return false;
        }
        return true;
    }

    

    public static int rand(int min, int max){
        int range = max - min + 1;
        return (int) (Math.random() * range) + min;
    }


    public static void loadTestScenario(ArrayList<Character> enemyList, ArrayList<Character> allList, Character enemy1, Character enemy2, Character enemy3){
        enemy1 = new Character(pre1);
        enemy2 = new Character(pre2);
        enemy3 = new Character(pre3);
        enemyList.addAll(Arrays.asList(enemy1, enemy2, enemy3));
        allList.addAll(enemyList);
    }

    public static boolean getSelectedCharacterType(Character selected){
        return selected.player;
    }

    public static void setOrder(ArrayList<Character> orderedCharacters){
        for(int x = 0; x < orderedCharacters.size(); x++){
            int highestInitiative = x;
            for(int y = x + 1; y < orderedCharacters.size(); y++){
                if(orderedCharacters.get(y).roundInitiative > orderedCharacters.get(highestInitiative).roundInitiative && orderedCharacters.get(y).roundInitiative > orderedCharacters.get(x).roundInitiative){
                    highestInitiative = y;
                }
            }
            Collections.swap(orderedCharacters, x, highestInitiative);
        }

        for(int i = 0; i < orderedCharacters.size() - 1; i++){
            orderedCharacters.get(i).next = orderedCharacters.get(i + 1);
        }

        System.out.println("------ TURN ORDER -----");
        System.out.println("");
        displayOrder(orderedCharacters.get(0));
        System.out.println("");
        displayTurn(orderedCharacters.get(0));
        
    }

    public static void displayOrder(Character first){ //THIS FUNCTION IS RECURSIVE!!!
        if(first != null){
            System.out.println("\t" + first.name + " -> ROLLED: " + first.roundInitiative);
            displayOrder(first.next);
        }
    }
    
    public static String cin(){
        Scanner term = new Scanner(System.in);  // Create a Scanner object
        String input = term.nextLine();
        return input;  // Read +return user input
        //term.close(); //Avoid a memory leak lmao

    }

    public static int validIntegerInput(int min, int max){ // jus to check if input is valid, game would end due to exception in thread error.
        int input = -1;
        boolean valid = false;
        while (!valid){
            try {
                String userInput = cin();
                input = Integer.parseInt(userInput);
                if (input >= min && input <= max) {
                    valid = true;
                } else {
                    System.out.println("Input Error!");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input!");
            }
        }
        return input;
        //term.close();
    }
    public static void displayTurn(Character current){
        System.out.println("It's " + current.name + "'s turn!");
    }

    public static void death(Character deadChar){ //Call this function when someone is killed
        System.out.println(deadChar.name + " was SLAIN by " + deadChar.lastAttacker.name + " using their " + deadChar.lastAttacker.charInventory.equippedWeapon.name);
    }

}
