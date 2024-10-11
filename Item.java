public class Item{
    /*Okay if anyone works on this while I'm not looking, PLEASE be careful-
     * I think to handle items properly we can't use an enumerator. We might have
     * to make another java file called ItemType.java or smth and that will contain 
     * a MELEE, RANGED, POTION, & EQUIPABLE class. Then we can give them each an enum 
     * called Type which holds the type of MELEE weapon it is for example- like an Axe or 
     * a Sword.
     * 
     * Look long story short implementing the items is going to be a nightmare so be careful
     * For now, I'm just going to go with something less modular to test and build other systems like combat
     */
    enum Type{
        MELEE,
        RANGED,
        POTION,
        EQUIPABLE
    }

    /*Just gonna write my rationale for the simple names here for markers.
     * I get that having many variables called 'name' could get confusing,
     * but when calling these it'll always look simple like:
     * print(player1.inventory.items[4].name)
     * Look how well that reads- it doesn't get cleaner than that.
     * I would actually argue that the opposite would make it more confusing:
     * print(player1.inventory.items[4].itemName);
     */
    String name;
    String description;
    Type type;

    //Effects
    int strength;
    int wisdom;
    int constitution;
    int initiative;

    //Consumable Stats
    int healMod; //Mod means Modifier
    int damageMod;

    public Item(Type itemType, String itemName, String itemDescription, int str, int wis, int con, int ini){
        type = itemType;
        name = itemName;
        description = itemDescription;
        strength = str;
        wisdom = wis;
        constitution = con;
        initiative = ini;
    }

    public Item(Type itemType, String itemName, String itemDescription, int hp, int dmg){
        type = itemType;
        name = itemName;
        description = itemDescription;
        strength = str;
        wisdom = wis;
        constitution = con;
        initiative = ini;
    }
    
}