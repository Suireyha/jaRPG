import java.util.Scanner; 

public class Main{

    public static void main(String[] args){
        Preset pre = new Preset("Phil Tok", "HUMAN", "BARBARIAN");
        Preset pre2 = new Preset("Orculus", "ORC", "MAGE");
        
        Character xo = new Character(pre);
        xo.displayCharacterData();

        Character xx = new Character(pre2);
        xx.displayCharacterData();

        Character ox = new Character();
        ox.displayCharacterData();
        //Note that since the Character class is unfinished, these are all unstable and own't work if Class != MAGE

    }

    public static String cin(){
        Scanner term = new Scanner(System.in);  // Create a Scanner object
        String uInput = term.nextLine();  // Read user input
        //term.close(); //Avoid a memory leak lmao
        return uInput;
    }

}