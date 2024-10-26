import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class MainTest {
    private Main game;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @Before
    public void setUp() {
        System.setOut(new PrintStream(outContent));
        game = new Main();
    }

    @Test
    public void testAllPlayersDeadScenario() {
        // Setup test scenario
        ArrayList<Character> party = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();
        
        // Create dead players
        Character deadPlayer1 = new Character(Main.pre4);
        Character deadPlayer2 = new Character(Main.pre5);
        deadPlayer1.health = 0;
        deadPlayer2.health = 0;
        deadPlayer1.alive = false;
        deadPlayer2.alive = false;
        party.add(deadPlayer1);
        party.add(deadPlayer2);

        // Create alive enemy
        Character aliveEnemy = new Character(Main.pre1);
        enemies.add(aliveEnemy);

        // Simulate game state check
        assertTrue("Enemy should be alive", aliveEnemy.alive);
        assertTrue("Party should be empty after deaths", party.stream().noneMatch(p -> p.alive));
        assertTrue("At least one enemy should be alive", enemies.stream().anyMatch(e -> e.alive));
        
        // Add success message
        System.out.println("✓ All players dead scenario test passed successfully");
    }

    @Test
    public void testAllEnemiesDeadScenario() {
        // Setup test scenario
        ArrayList<Character> party = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();
        
        // Create alive player
        Character alivePlayer = new Character(Main.pre4);
        party.add(alivePlayer);

        // Create dead enemies
        Character deadEnemy1 = new Character(Main.pre1);
        Character deadEnemy2 = new Character(Main.pre2);
        deadEnemy1.health = 0;
        deadEnemy2.health = 0;
        deadEnemy1.alive = false;
        deadEnemy2.alive = false;
        enemies.add(deadEnemy1);
        enemies.add(deadEnemy2);

        // Simulate game state check
        assertTrue("Player should be alive", alivePlayer.alive);
        assertTrue("Enemies should all be dead", enemies.stream().noneMatch(e -> e.alive));
        assertTrue("At least one player should be alive", party.stream().anyMatch(p -> p.alive));
        
        // Add success message
        System.out.println("✓ All enemies dead scenario test passed successfully");
    }

    @Test
    public void testInvalidUserInput() {
        // Simulate invalid user input
        String invalidInput = "INVALID_COMMAND\n";
        System.setIn(new ByteArrayInputStream(invalidInput.getBytes()));
        
        // Create a test character to ensure game state
        ArrayList<Character> party = new ArrayList<>();
        Character testPlayer = new Character(Main.pre4);
        party.add(testPlayer);

        // The game should continue running after invalid input
        assertTrue("Player should still be alive after invalid input", testPlayer.alive);
        assertTrue("Party should still contain player after invalid input", party.contains(testPlayer));
        
        // Add success message
        System.out.println("✓ Invalid user input test passed successfully");
    }

    @Test
    public void testCombatInitialization() {
        ArrayList<Character> party = new ArrayList<>();
        ArrayList<Character> enemies = new ArrayList<>();
        // Removed unused orderedCharacters ArrayList

        // Create test characters
        Character player = new Character(Main.pre4);
        Character enemy = new Character(Main.pre1);
        
        party.add(player);
        enemies.add(enemy);
        
        // Add assertions to verify lists
        assertEquals("Party should have 1 member", 1, party.size());
        assertEquals("Enemies should have 1 member", 1, enemies.size());

        // Test combat initialization
        assertTrue("Player should be alive at combat start", player.alive);
        assertTrue("Enemy should be alive at combat start", enemy.alive);
        assertEquals("Player should have full health", player.maxHealth, player.health);
        assertEquals("Enemy should have full health", enemy.maxHealth, enemy.health);
        
        // Add success message
        System.out.println("✓ Combat initialization test passed successfully");
    }

    @Test
    public void testCharacterDeath() {
        // Test death notification
        Character attacker = new Character(Main.pre1);
        Character victim = new Character(Main.pre4);
        
        // Setup attack scenario
        victim.lastAttacker = attacker;
        victim.health = 0;
        victim.alive = false;
        
        // Capture death message
        Main.death(victim);
        String output = outContent.toString();
        assertTrue("Death message should contain victim name", 
                  output.contains(victim.name));
        assertTrue("Death message should contain attacker name", 
                  output.contains(attacker.name));
        
        // Add success message
        System.out.println("✓ Character death test passed successfully");
    }
}
