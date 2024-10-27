public class Level{
    private int currentLevel;
    private int experience;
    private int xpForNextLevel;

    public Level() {
        this.currentLevel = 1; 
        this.experience = 0; 
        this.xpForNextLevel = 100; 
    }

    public void gainExperience(int xp) {
        this.experience += xp;
        checkLevelUp();
    }

    // Check if the character can level up
    private void checkLevelUp() {
        while (this.experience >= this.xpForNextLevel) {
            this.currentLevel++;
            this.experience -= this.xpForNextLevel;
            this.xpForNextLevel = nextLevelXP();
            System.out.println("Level up! Now at level " + currentLevel);
        }
    }

    // Calculate the XP needed for the next level
    private int nextLevelXP() {
        return this.xpForNextLevel + 50 * this.currentLevel; // Increase by 50 XP per level
    }
    // Getters
    public int getCurrentLevel() {
        return this.currentLevel;
    }

    public int getExperience() {
        return this.experience;
    }

    public int getXpForNextLevel() {
        return this.xpForNextLevel;
    }

}
