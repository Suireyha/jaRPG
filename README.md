# jaRPG
Major Assignment for Comp1010, MQ University

## Team:
**Marvin Kelly, Caleb Chew, RJ, Kong**

## Project Outline:

As for writing this, the goal for this project is to develop a text-based RPG where a Character can create a small party of Heros, each of which belongs to it's own class (Barbarian, Wizard, etc), it's own race (Elf, Dwarf, etc), has certain equiptment (Iron sword, wooden shield, etc) to battle a computer generated or pre-defined party (to be determined) in order to win.

Actions- especially combat actions- will be determined as succesfull or unsiccesfull by a dice roll plus some modifier. Each action will have its own threshold that must be met in order for the action to be successful. For example, to attack a goblin with a sword, a dice roll of 10 might be required and thus if the user rolls 8 and has an attack modifier (likely strength in this case) of +3, they pass the check and attack the goblin since their total was 11, as 11 > 10.

For now, the player wins if their party can defeat the opponent party so as to not broaden the scope of this project too much initially.

Players will interface with the game via the terminal, giving text commands for their actions.

## Project 'Problem'

This application is *being* designed to create an enjoyable text-based RPG that includes the fundemental features of an RPG, which we consider:
* Character System (Race, class, attributes, etc)
* Item System (Weapons, armour, etc)
* Combat System with table top esque calculations
* An Objective
* A way to lose

## How to run the program

To be determined :)



## Project Roadmap (IMPORTANT!!)

### Attribute System
Along side characters, we need to build an Attribute System to calculate actions.

### Character System
Build the infrastructure to create characters with unique names, races, classes, attributes etc. Characters should be able to store, equip and use items (after they've been implemented). The Character System needs to be modular such that both player characters and non-player characters can be made with the same methods.

### Combat System
Develop a system for actually playing through combat scenarios- making actions, getting hit, etc

### Item System
Build the infrastructure to create and use items. After this, we can add a few items.

### Win/Loss Handling
Handle what happens if the player completes their objective or dies trying.


