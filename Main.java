import java.util.Scanner; 

public class Main{

    public static void main(String[] args){



    }

    public static String cin(){
        Scanner term = new Scanner(System.in);  // Create a Scanner object
        String uInput = term.nextLine();  // Read user input
        term.close(); //Avoid a memory leak lmao
        return uInput;
    }

}