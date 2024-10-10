public class Class{
    //Starting attributes for all classes should sum to 40

    public Class(String preset){

    }

    public Class(){

    }

    class Barbarian {
        private Barbarian(Character caller) {
            System.out.println("BARBARIAN CLASS CONSTRUCTED");
            setAttributes(caller, 15, 5, 15, 5);
        }
    }

    class Fighter {
        private Fighter(Character caller) {
            System.out.println("ASSASSIN CLASS CONSTRUCTED");
            setAttributes(caller, 15, 5, 5, 15);
        }
    }

    class Mage {
        private Mage(Character caller) {
            System.out.println("MAGE CLASS CONSTRUCTED");
            setAttributes(caller, 5, 15, 5, 15);
        }
    }

    class Assassin {
        private Assassin(Character caller) {
            System.out.println("ASSASSIN CLASS CONSTRUCTED");
            setAttributes(caller, 15, 5, 5, 15);
        }
    }

    private void setAttributes(Character caller, int strength, int wisdom, int constitution, int initiative){
        caller.strength += strength;
        caller.wisdom += wisdom;
        caller.constitution += constitution;
        caller.initiative += initiative;
    }

}