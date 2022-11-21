package com.example.concurrency.gold;

/**
 * @author pano
 */
public class StarvationExample {

    public static void main(String[] args) {

        final WildMonster wildMonster = new WildMonster();
        String[] players = {
                "哪吒",
                "兰陵王",
                "铠",
                "典韦"
        };
        for (String player : players) {
            Thread playerThread = new Thread(wildMonster::killWildMonster);
            playerThread.setName(player);
            playerThread.start();
        }
    }
}
