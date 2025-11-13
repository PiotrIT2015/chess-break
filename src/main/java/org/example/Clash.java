package org.example;

import java.util.*;

public class Clash {

    static class Player {
        String name;
        int score;

        Player(String name) {
            this.name = name;
            this.score = 0;
        }

        // losowo generuje wynik w zakresie 0–100
        void playMatch(Random random) {
            this.score = random.nextInt(101);
        }
    }

    public static void main(String[] args) {
        Random random = new Random();

        // lista zawodników
        List<Player> players = new ArrayList<>();
        players.add(new Player("Hikaru Nakamura"));
        players.add(new Player("Magnus Carlsen"));
        players.add(new Player("WWP"));
        

        // symulacja — każdy zawodnik gra i dostaje punkty
        for (Player p : players) {
            p.playMatch(random);
        }

        // sortowanie po wyniku malejąco
        players.sort((a, b) -> Integer.compare(b.score, a.score));

        // przyznanie medali
        System.out.println("🏆 Klasyfikacja medalowa:");
        if (players.size() >= 1) System.out.println("🥇 Gold: " + players.get(0).name + " (" + players.get(0).score + " pkt)");
        if (players.size() >= 2) System.out.println("🥈 Silver: " + players.get(1).name + " (" + players.get(1).score + " pkt)");
        if (players.size() >= 3) System.out.println("🥉 Bronze: " + players.get(2).name + " (" + players.get(2).score + " pkt)");

        // pełna tabela wyników
        System.out.println("\n=== Wyniki końcowe ===");
        for (int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).name + " — " + players.get(i).score + " pkt");
        }
    }
}
