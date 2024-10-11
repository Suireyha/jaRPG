public class Character{
    //Character's Name, Race and Class (by which I mean in-game class not class object :3)
    String name;
    Race charRace;
    Class charClass;
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
    //public int intelligence = 0; //No use as of now
    public int wisdom = 0; //Used for magical combat rolls
    public int constitution = 0; //Used to determine HP
    public int initiative = 0; //Used to determine turns


    public Character(Preset preset){
        //This character is being made with a predefined set of characteristics. Good for testing, and random generations
        name = preset.name;
        charRace = new Race(preset.race);
        charClass = new Class(preset.pClass);
    }

    public Character(){
        //name = setName
        charRace = new Race();
        charClass = new Class();
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
                invalid = setRace(uInput, false);
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
                invalid = setClass(uInput, false);
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

    //Function for modifying attributes
    public void modifyAttributes(int str, int wis, int con, int ini){
        strength += str;
        wisdom += wis;
        constitution += con;
        initiative += ini;
    }


    //Display character data
    public void displayCharacterData(){
        System.out.println("-------------CHARACTER SHEET-------------");
        System.out.println("|                                       |");
        System.out.println("|    Name: " + name + "                      |");
        System.out.println("|    Class: " + charClass.type + "                        |");
        System.out.println("|    Race: " + charRace.type + "                          |");
        System.out.println("|                                       |");
        System.out.println("|               ATTRIBUTES              |");
        System.out.println("|                                       |");
        System.out.println("|    Strength: " + strength + "                        |");
        System.out.println("|    Wisdom: " + wisdom + "                         |");
        System.out.println("|    Constitution: " + constitution + "                    |");
        System.out.println("|    Initiative: " + initiative + "                     |");
        System.out.println("|                                       |");
        System.out.println("-----------------------------------------");
        System.out.println("");
        System.out.println("");
    }

}