package com.example.concurrency.level2;

/**
 * @author pano
 */
public class WildMonster {
    public synchronized void killWildMonster() {
        while (true) {
            String playerName = Thread.currentThread().getName();
            System.out.println(playerName + "斩获野怪！");
            try {
                Thread.sleep(500);
//                wait(500);
            } catch (InterruptedException e) {
                System.out.println("打野中断");
            }
        }
    }
}