/* 
public class Race{
    enum Type{
        HUMAN,
        ELF,
        ORC
    }
    
    Type type;

    public Race(String selection){
        //If this function was called with a race in mind
        setRace(selection, true); //Yes, I'm aware that this statement will resolve to a true/false value. It doesn't matter. 
        
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
        
    }

    public void displayRace(Character caller, String race){
        System.out.println(caller.name + " is " + caller.charRace.type);
    }

    private boolean setRace(String uInput, boolean systemCall){
        boolean valid = false;
        switch(uInput){
            case "HUMAN":
                type = Type.HUMAN;
                valid = !valid; //Valid is true, since HUMAN is a valid Race
                break;
            case "ELF":
                type = Type.ELF;
                valid = !valid; //Valid is true, since ELF is a valid Race
                break;
            case "ORC":
                type = Type.ORC;
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

    private void modifyAttribute(Character caller){
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

        caller.strength += attributes[0];
        caller.wisdom += attributes[1];
        caller.constitution += attributes[2];
        caller.initiative += attributes[3];
    }

}
*/