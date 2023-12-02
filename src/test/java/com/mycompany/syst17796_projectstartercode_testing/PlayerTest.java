/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.syst17796_projectstartercode_testing;

import java.util.ArrayList;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author aryan
 */
public class PlayerTest {
    
private Player player;

    @BeforeEach
    void setUp() {
        player = new Player("Alice") {
            @Override
            public void play() {
                // Implementation not needed for these tests
            }
        };
    }

    @Test
    void testAddCard() {
        // Good case: Adding a card to the player's hand
        player.addCard(new BlackjackCard("Ace", "11"));
        assertEquals(1, player.getHand().size());
        assertEquals("Ace", player.getHand().get(0).getRank());
    }

    @Test
    void testAddNullCard() {
        // Bad case: Trying to add a null card to the player's hand
        assertThrows(IllegalArgumentException.class, () -> player.addCard(null));
    }

    @Test
    void testAddCardWhenHandIsFull() {
        // Boundary case: Adding a card when the player's hand is already full
        for (int i = 0; i < 52; i++) {
            player.addCard(new BlackjackCard("Spades", "2"));
        }
        assertThrows(IllegalStateException.class, () -> player.addCard(new BlackjackCard("Spades", "Ace")));
    }
    
}
