package com.example.concurrency.bronze;

/**
 * @author pano
 */
public class Master01 {
    /**
     * 主宰的初始血量
     */
    private int blood = 100000000;

    public static void main(String[] args) {
        final Master01 master = new Master01();

        Thread lanLingWangThread = new Thread(() -> {
            while (master.isAlive()) {
                try {
                    int remainBlood = master.decreaseBlood();
                    if (remainBlood == 0) {
                        System.out.println("兰陵王击败了主宰！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        Thread neZhaAttachThread = new Thread(() -> {
            while (master.isAlive()) {
                try {
                    int remainBlood = master.decreaseBlood();
                    if (remainBlood == 0) {
                        System.out.println("哪吒击败了主宰！");
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });

        lanLingWangThread.start();
        neZhaAttachThread.start();
    }

    /**
     * 每次被击打后血量减5
     */
    public synchronized int decreaseBlood() {
        blood = blood - 5;
        return blood;
    }

    /**
     * 通过血量判断主宰是否还存活
     */
    public boolean isAlive() {
        return blood > 0;
    }
}