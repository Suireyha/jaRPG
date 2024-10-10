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
            //If this function was called with a race in mind
            setRace(preset, true); //Yes, I'm aware that this statement will resolve to a true/false value. It doesn't matter. 
            modifyAttribute();
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
            modifyAttribute();
        }
    
        public void displayRace(Character caller, String race){
            System.out.println(caller.name + " is " + caller.charRace.type);
        }
    
        private boolean setRace(String uInput, boolean systemCall){
            boolean valid = false;
            switch(uInput){
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
                    System.out.println("ERROR: PASSED INVALID ARGUMENT TO"); //One of us has made a mistake if we ever see this
                }
                else{
                    System.out.println("Select valid race (spelling/capitalisation must match examples!)"); //User passed an invalid string argument for their race
                }
                break;
            }
            return valid;
        }
    
        private void modifyAttribute(){
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
            if(preset == "MAGE"){
                type = ClassType.MAGE;
                modifyAttributes(5, 15, 5, 15);
            }
        }

        public Class(){

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