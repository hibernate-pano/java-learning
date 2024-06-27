package com.example.concurrency.level1;

import java.util.LinkedList;

/**
 * @author pano
 * @date 2022/11/21
 **/
public class ProducerAndConsumerDemo {

    /**
     * 野怪活动的野区
     */
    private static final LinkedList<String> WILD_MONSTER_AREA = new LinkedList<String>();

    public static void main(String[] args) {
        Thread wildMonsterProducerThread = new Thread(new WildMonsterProducer());
        Thread lanLingWangThread = new Thread(new LanLingWang());

        wildMonsterProducerThread.start();
        lanLingWangThread.start();
    }

    /**
     * 野怪投放【生产者】
     */
    static class WildMonsterProducer implements Runnable {
        public void run() {
            try {
                createWildMonster();
            } catch (InterruptedException e) {
                System.out.println("野怪投放被中断");
            }
        }

        //投放野怪，每1秒检查一次
        public void createWildMonster() throws InterruptedException {
            for (int i = 0; i < 10; i++) {
                synchronized (WILD_MONSTER_AREA) {
                    if (WILD_MONSTER_AREA.size() == 0) {
                        WILD_MONSTER_AREA.add("野怪" + i);
                        System.out.println(WILD_MONSTER_AREA.getLast());
                        WILD_MONSTER_AREA.notify();
                    }
                }
                Thread.sleep(1000);
            }
        }
    }

    /**
     * 兰陵王，打野英雄
     */
    static class LanLingWang implements Runnable {
        public void run() {
            try {
                attackWildMonster();
            } catch (InterruptedException e) {
                System.out.println("兰陵王打野被中断");
            }
        }

        // 打野，如果没有则进行等待
        public void attackWildMonster() throws InterruptedException {
            while (true) {
                synchronized (WILD_MONSTER_AREA) {
                    if (WILD_MONSTER_AREA.size() == 0) {
                        System.out.println("LLW等待");
                        WILD_MONSTER_AREA.wait();
                    }
                    String wildMonster = WILD_MONSTER_AREA.getLast();
                    WILD_MONSTER_AREA.remove(wildMonster);
                    System.out.println("收获野怪：" + wildMonster);
                }
            }
        }
    }
}
