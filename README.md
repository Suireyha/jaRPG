# jaRPG
Major Assignment for Comp1010, MQ University

## Team:
**Marvin Kelly, Caleb Chew, RJ, Cong**

## Project Outline:

jaRPG is a terminal based RPG where the user can create their own party of heroes, each with their own class, weapons, armour, race etc. The user's party will face up against enemy parties in a FIGHT TO THE DEATH!!!! Upgrade your weapons and kill as many as you can.

Combat actions are determined as succesfull or unsiccesfull by a dice roll plus some modifier. Each action will have its own threshold that must be met in order for the action to be successful. For example, to attack a goblin with a sword, a dice roll of 10 might be required and thus if the user rolls 8 and has an attack modifier (likely strength in this case) of +3, they pass the check and attack the goblin since their total was 11, as 11 > 10.

For now, the player wins if their party can defeat the opponent party so as to not broaden the scope of this project too much initially.

Players interface with the game via the terminal, giving text commands for their actions.

## Project 'Problem'

This application is *being* designed to create an enjoyable text-based RPG that includes the fundemental features of an RPG, which we consider:
* Character System (Race, class, attributes, etc)
* Item System (Weapons, armour, etc)
* Combat System with table top esque calculations
* An Objective
* A way to lose

## How to run the program
After executing, the user should be greeted with a list of avaliable commands. This list can be recalled by typing HELP

## How to play
When you start the game, you will see a list of commands you can use. Here’s how each of them works:

HELP - Shows the list of available commands.
Use this if you ever need to remember the list of commands during the game.


CREATE - Starts the character creation process.

This is the first thing you should do when starting the game.
You will be prompted to choose your character’s name, race, class.


SELECT - Choose an existing character to control.

If you have multiple characters, this lets you pick which one you want to play or modify.


SHOW INV - Displays the inventory of the currently selected character.

View all items the character is carrying. You can see weapons, armour, and potions.


SHOW STATS - Shows the character’s stat sheet.

Use this to see your character’s detailed information and attributes, including strength, wisdom, constitution, and initiative.


EQUIP - Equips an item from the inventory.

Select an item from your inventory to equip. For example, you might equip a sword, daggers, or staffs to boost your combat abilities.


START - Begins combat.

Use this command to initiate combat. Make sure your character is selected, prepared and equipped before starting a fight.


ATTACK - Attack an enemy during combat.

When it’s your character’s turn, you can choose to attack an opponent. Your success will depend on your character’s stats and equipment.


USE - Use an item from your inventory during or outside combat.

For example, you can use a health potion to restore HP.


QUIT - Ends the program.

Use this command when you want to exit the game. 

## Tips for playing
###Create Your Character Wisely: 
When making your character, select a race and class that match your playstyle. For example, if you prefer close combat, consider becoming a Fighter or Barbarian. If you like spells, choose a Mage.

###Manage your inventory: 
Keep track of what you collect. Equip your character with top-tier equipment and keep some healing items on hand for tough battles.

###Plan Your Combat Moves: 
Because the game is turn-based, you should anticipate and plan your actions. Sometimes defending or using an item is more effective than attacking!

## Project Roadmap (IMPORTANT!!)

### Bug Fixes....
We need to fix a lot.

### Levels + Random Enemy Generation
We can add multiple levels if we want to. Random enemy generation would be good too so that the enemies don't get stale

### Additional Content
Add additional races, classes, items, levels, etc.

### Interface (UNLIKELY)
Graduate from the text based interface

## Contribution Estimates
Marvin Kelly -> 40%
Caleb Chew   -> 20%
RJ           -> 20%
Kong         -> 20%


