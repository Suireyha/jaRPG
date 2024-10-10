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
    
        public Race(String selection){
            //If this function was called with a race in mind
            setRace(selection, true); //Yes, I'm aware that this statement will resolve to a true/false value. It doesn't matter. 
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
            int[] attributes = {0, 0, 0, 0};
            switch(type){
                case HUMAN:
                //Human race should not change anything, so just leave all values as zero by breaking
                break;
                case ELF:
                //Elves should get improved wisdom and initiative at the cost of strength and constitution
                attributes[0] =  -3; //Strength -3
                attributes[1] =  3; //Wisdom +3
                attributes[2] =  -2; //Constitution -2;
                attributes[3] =  2; // Initiative +2;
                break;
                case ORC:
                //Orcs should have increased strength and constitution at the cost of wisdom and initiative
                attributes[0] =  3; //Strength +3
                attributes[1] =  -2; //Wisdom -2
                attributes[2] =  2; //Constitution 2;
                attributes[3] =  -3; // Initiative -3;
                break;
            }
    
            strength += attributes[0];
            wisdom += attributes[1];
            constitution += attributes[2];
            initiative += attributes[3];
        }
    
    }

}