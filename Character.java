import java.util.ArrayList;
import java.util.Arrays;

public class Character{
    //Character's Name, Race and Class (by which I mean in-game class not class object :3)
    String name; //This one is not called charName because it's not an class. player1.name gives the name of the player, player1.charRace.name gives the name of the race. 
    Race charRace;
    Class charClass;
    Inventory charInventory;

    enum RaceType{
        HUMAN,
        ELF,
        ORC
    }
    enum ClassType{
        BARBARIAN,
        FIGHTER,
        MAGE,
        ASSASSIN
    }




    //Character Attributes
    public int strength = 0; //Used for non-magical combat rolls
    public int wisdom = 0; //Used for magical combat rolls
    public int constitution = 0; //Used to determine HP
    public int initiative = 0; //Used to determine turns


    //Character stats
    public double health = constitution * 1.5;



    public Character(Preset preset){
        //This character is being made with a predefined set of characteristics. Good for testing, and random generations
        name = preset.name;
        charRace = new Race(preset.race);
        charClass = new Class(preset.pClass);
    }

    public Character(){
        boolean invalid = true;
        while(invalid){
            System.out.print("Name your Character:\t");
            String temp = Main.cin();

            boolean onlyWhiteSpace = true; //Tracks if the user input is only whitespace
            

            for(int i = 0; i <  temp.length(); i++){
                //Makes sure there's at least one character
                if(temp.charAt(i) != ' '){
                    onlyWhiteSpace = false;
                };
            }

 
            if(temp.length() < 2 || onlyWhiteSpace || temp.length() > 20){
                //Error message for user
                System.out.println("Character name must be between 2 and 20 symbol and can't be whitespace only");
                invalid = true;
            }

            else{
                //Valid -> leave loop
                name = temp;
                invalid = false;
            }

        }
        
        charRace = new Race();
        charClass = new Class();
        charInventory = new Inventory();
        System.out.println("");
        System.out.println(name + " the " + charClass.type + " joins the party!");
        System.out.println("");
    }




    //THE RACE CLASS
    public class Race{
        
        RaceType type;
    
        public Race(String preset){
            //This function was called with a race in mind
            setRace(preset, true); //Yes, I'm aware that this statement will resolve to a true/false value. It doesn't matter. 
            raceAttribute();
        }
    
        public Race(){
            //If this function was called to make a character for the palyer
            //We can implement this one later, for now lets just work with presets.
            boolean invalid = true;
            while(invalid){
                System.out.println("Please select a race (HUMAN, ELF, ORC)");
                String uInput = Main.cin();
                invalid = !setRace(uInput, false);
            }
            //After a valid race has been chosen, asign the character attributes for that respective race
            raceAttribute();
        }
    
        private boolean setRace(String input, boolean systemCall){
            boolean valid = false;
            switch(input){
                case "HUMAN":
                    type = RaceType.HUMAN;
                    valid = !valid; //Valid is true, since HUMAN is a valid Race
                    break;
                case "ELF":
                    type = RaceType.ELF;
                    valid = !valid; //Valid is true, since ELF is a valid Race
                    break;
                case "ORC":
                    type = RaceType.ORC;
                    valid = !valid; //Valid is true, since ORC is a valid Race
                    break;
                default:
                //We got an error while generating a character without user input
                if (systemCall){
                    System.out.println("ERROR: PASSED INVALID ARGUMENT TO setRace()!!"); //One of us has made a mistake if we ever see this
                }
                else{
                    System.out.println("Select valid race (spelling/capitalisation must match examples!)"); //User passed an invalid string argument for their race
                }
                break;
            }
            return valid;
        }
    
        private void raceAttribute(){
            switch(type){
                case HUMAN:
                //Human race should not change anything, so just leave all values as zero by breaking
                break;
                case ELF:
                //Elves should get improved wisdom and initiative at the cost of strength and constitution
                modifyAttributes(-3, 3, -2, 2);
                //Strength -3
                //Wisdom +3
                //Constitution -2;
                // Initiative +2;
                break;
                case ORC:
                //Orcs should have increased strength and constitution at the cost of wisdom and initiative
                modifyAttributes(3, -2, 2, -3);
                //Strength +3
                //Wisdom -2
                //Constitution 2;
                // Initiative -3;
                break;
            }

        }
    
    }





    //CLASS CLASS :3
    public class Class{ 

        ClassType type;
        //Starting attributes for all classes should sum to 40
        // NOTE: THIS CLASS IS UNFINISHED!!!!! IT IS UNSTABLE

        public Class(String preset){
            //Use this function when building a character from a preset
            setClass(preset, true);
            classAttribute();
        }

        public Class(){

            boolean invalid = true;
            while(invalid){
                System.out.println("Please select a class (BARBARIAN, FIGHTER, MAGE, ASSASSIN)");
                String uInput = Main.cin();
                invalid = !setClass(uInput, false);
            }
            //After a valid class has been chosen, asign the character attributes for that class
            classAttribute();

        }

        private boolean setClass(String input, boolean systemCall){
            boolean valid = false;
            switch(input){
                case "BARBARIAN":
                    type = ClassType.BARBARIAN;
                    valid = !valid;
                    break;
                case "FIGHTER":
                    type = ClassType.FIGHTER;
                    valid = !valid;
                    break;
                case "MAGE":
                    type = ClassType.MAGE;
                    valid = !valid;
                    break;
                case "ASSASSIN":
                    type = ClassType.ASSASSIN;
                    valid = !valid;
                    break;
                default:
                
                if (systemCall){
                    System.out.println("ERROR: PASSED INVALID ARGUMENT TO setClass()!!"); //One of us has made a mistake if we ever see this
                }
                else{
                    System.out.println("Select valid class (spelling/capitalisation must match examples!)"); //User passed an invalid string argument for their race
                }
                break;
            }

            return valid;

        }

        private void classAttribute(){
            //NOTE: ALL DEFAULT CLASS ATTRIBUTES SHOULD AMOUNT TO 40!!
            switch(type){
                case BARBARIAN:
                    //Barbarians should be heavy hitting tanks, but are slow and dumb
                    modifyAttributes(15, 5, 15, 5);
                    //Strength = 15;
                    //Wisdom = 5;
                    //Constitution = 15;
                    // Initiative = 5;
                    break;
                case FIGHTER:
                    //Fighters should be good melee focused all-rounders
                    modifyAttributes(12, 7, 10, 10);
                    //Strength = 12;
                    //Wisdom = 7;
                    //Constitution = 10;
                    // Initiative = 10;
                    
                    break;
                case MAGE:
                    //Mages/Wizards should be ranged class cannons
                    modifyAttributes(6, 15, 6, 13);
                    //Strength = 6;
                    //Wisdom = 15;
                    //Constitution = 6;
                    // Initiative = 13;
                    break;
                case ASSASSIN:
                    //Assassin's should have some spell capacity, decent melee output and great speed
                    modifyAttributes(11, 8, 5, 16);
                    //Strength = 11;
                    //Wisdom = 8;
                    //Constitution = 5;
                    // Initiative = 16;
                    break;
                

            }
        }
        
    }

    public class Inventory{
        ArrayList<Item> items = new ArrayList<Item>();
        Item equippedWeapon;
        Item equippedArmour;

        public Inventory(){
            //This function should give starting equipment based on their class
            items = new ArrayList<Item>(); //Build list

            switch(charClass.type){
                case BARBARIAN:
                //Barbarians start with a wooden sword, rags and a rage potion
                items.addAll(Arrays.asList(Main.woodSword, Main.ragsArmor, Main.ragePotion));
                break;
                case FIGHTER:
                //Fighters start with a wooden sword, rags and a rage potion
                items.addAll(Arrays.asList(Main.woodSword, Main.leatherArmor, Main.healthPotion));
                break;
                case MAGE:
                //Mages start with a wooden staff, rags and a health potion
                items.addAll(Arrays.asList(Main.woodStaff, Main.ragsArmor, Main.healthPotion));
                break;
                case ASSASSIN:
                //Assassins start with a shank, leather armour and a health potion
                items.addAll(Arrays.asList(Main.shankDagger, Main.leatherArmor, Main.healthPotion));
                break;
            }

            sort();

        }

        public void equip(){
            int highestIndex = 0;
            int uInput = 0;
            sort();
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == Item.Type.MELEE || items.get(i).type == Item.Type.RANGED || items.get(i).type == Item.Type.EQUIPABLE){
                    System.out.println("( " + items.get(i).name + " = " + (i + 1) + " )");
                    highestIndex = i + 1;
                }
            }
            
            boolean invalid = true;
            while(invalid){
                uInput = Integer.valueOf(Main.cin());
                if(uInput < 1 || uInput > highestIndex){
                    System.out.println("Invalid item number!");
                }
                else{
                    uInput--; //This just makes sure that it follows the same 1, 2, ... format of the prompt
                    invalid = false;
                }
            }

            switch(items.get(uInput).type){
                case MELEE:
                    //No break here so that ranged and melee weapons just equip to weapon slot
                case RANGED:
                    equippedWeapon = items.get(uInput);
                    System.out.println(name + " equipped their " + equippedWeapon.name);
                break;
                case EQUIPABLE:
                    equippedArmour = items.get(uInput);
                    System.out.println(name + " put on their " + equippedArmour.name);
                break;
                default:
                    System.out.println("ERROR: EQUIP BUG - CHECK equip() METHOD IN INVENTORY");
                break;

            }
            
            

        }

        public void sort(){
            ArrayList<Item> temp = new ArrayList<Item>();

            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == Item.Type.MELEE){
                    temp.add(items.get(i));
                }
            }
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == Item.Type.RANGED){
                    temp.add(items.get(i));
                }
            }
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == Item.Type.EQUIPABLE){
                    temp.add(items.get(i));
                }
            }
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == Item.Type.POTION){
                    temp.add(items.get(i));
                }
            }

            items = temp;
        }

        public void display(){
            sort();
            System.out.println("-------------INVENTORY SHEET-------------");
            System.out.println("|                                       |");
            System.out.println("|           " + name + "'s Items             |");
            System.out.println("|                                       |");
            System.out.println("|----------------WEAPONS----------------|");
            displaySection(Item.Type.MELEE);
            displaySection(Item.Type.RANGED);
            System.out.println("|                                       |");
            System.out.println("|----------------ARMOUR-----------------|");
            System.out.println("|                                       |");
            displaySection(Item.Type.EQUIPABLE);
            System.out.println("|                                       |");
            System.out.println("|----------------POTIONS----------------|");
            System.out.println("|                                       |");
            displaySection(Item.Type.POTION);
            System.out.println("|                                       |");
            System.out.println("-----------------------------------------");
        }

        public void displaySection(Item.Type section){
            for(int i = 0; i < items.size(); i++){
                if(items.get(i).type == section){
                    System.out.println("|                                       |");
                    System.out.println("|             " + items.get(i).name + "             |");
                    System.out.println("| " + items.get(i).description + " |");
                }
            }
        }

        public void addItem(Item item){
            //Add an item to player inventory
            items.add(item);
        }

        public void removeItem(Item item){
            //This function will delete the LAST insance of a certain item in an inventory
            //If the player has 3 health potions for example, this will remove the last 1 added
            int index = 0;
            for(int i = 0; i < items.size(); i++){
                if(items.get(i) == item){
                    index = i;
                }
            }
            items.remove(index);
        }


    }


    //Function for modifying attributes
    public void modifyAttributes(int str, int wis, int con, int ini){
        strength += str;
        wisdom += wis;
        constitution += con;
        initiative += ini;
    }


    //Display character data
     public void displayCharacterData() {
    
        String nameLine = "Name: " + name;
        String classLine = "Class: " + charClass.type;
        String raceLine = "Race: " + charRace.type;
        String strengthLine = "Strength: " + strength;
        String wisdomLine = "Wisdom: " + wisdom;
        String constitutionLine = "Constitution: " + constitution;
        String initiativeLine = "Initiative: " + initiative;
    
      
        int maxContentLength = Math.max(Math.max(nameLine.length(), classLine.length()), 
                                        Math.max(raceLine.length(), Math.max(strengthLine.length(), 
                                        Math.max(wisdomLine.length(), 
                                        Math.max(constitutionLine.length(), initiativeLine.length())))));
        
        
        int boxWidth = maxContentLength + 4;
        String border = "-".repeat(boxWidth);
        System.out.println(border);
        System.out.println("|" + " ".repeat(boxWidth - 2) + "|");
        System.out.println("| " + padRight(nameLine, boxWidth - 3) + "|");
        System.out.println("| " + padRight(classLine, boxWidth - 3) + "|");
        System.out.println("| " + padRight(raceLine, boxWidth - 3) + "|");
        System.out.println("|" + " ".repeat(boxWidth - 2) + "|");
        System.out.println("| " + padRight("ATTRIBUTES", boxWidth - 3) + "|");
        System.out.println("|" + " ".repeat(boxWidth - 2) + "|");
        System.out.println("| " + padRight(strengthLine, boxWidth - 3) + "|");
        System.out.println("| " + padRight(wisdomLine, boxWidth - 3) + "|");
        System.out.println("| " + padRight(constitutionLine, boxWidth - 3) + "|");
        System.out.println("| " + padRight(initiativeLine, boxWidth - 3) + "|");
        System.out.println("|" + " ".repeat(boxWidth - 2) + "|");
        System.out.println(border);

        System.out.println("");
        System.out.println("");
    }
    
    // Helper method to pad the string to the right with spaces
    private String padRight(String str, int length) {
        if (str.length() < length) {
            return str + " ".repeat(length - str.length());
        } else {
            return str;
        }
    }

}
