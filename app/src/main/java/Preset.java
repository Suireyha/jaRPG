public class Preset{
    String name;
    String race;
    String pClass; //couldn't call this just class for obvious reasons :(

    boolean player; //If it's a player or an enemy

    public Preset(String preName, String preRace, String preClass, boolean plr){
        name = preName;
        race = preRace;
        pClass = preClass;

        player = plr;
    }
}