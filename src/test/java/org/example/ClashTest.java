package org.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import java.util.*;

public class ClashTest {

    @Test
    void testPlayerScoreRange() {
        Clash.Player player = new Clash.Player("Test Player");
        Random random = new Random();
        player.playMatch(random);

        assertTrue(player.score >= 0 && player.score <= 100,
                "Wynik gracza powinien być w zakresie 0–100");
    }

    @Test
    void testSortingDescending() {
        List<Clash.Player> players = new ArrayList<>();
        players.add(new Clash.Player("A"));
        players.add(new Clash.Player("B"));
        players.add(new Clash.Player("C"));

        // ręcznie przypisane punkty
        players.get(0).score = 50;
        players.get(1).score = 80;
        players.get(2).score = 30;

        // sortowanie malejące
        players.sort((a, b) -> Integer.compare(b.score, a.score));

        assertEquals("B", players.get(0).name, "Gracz z najwyższym wynikiem powinien być pierwszy");
        assertEquals("C", players.get(2).name, "Gracz z najniższym wynikiem powinien być ostatni");
    }

    @Test
    void testMedalAssignment() {
        List<Clash.Player> players = new ArrayList<>();
        players.add(new Clash.Player("Gold"));
        players.add(new Clash.Player("Silver"));
        players.add(new Clash.Player("Bronze"));

        // przydziel punkty
        players.get(0).score = 90;
        players.get(1).score = 80;
        players.get(2).score = 70;

        players.sort((a, b) -> Integer.compare(b.score, a.score));

        assertEquals("Gold", players.get(0).name);
        assertEquals("Silver", players.get(1).name);
        assertEquals("Bronze", players.get(2).name);
    }
}

