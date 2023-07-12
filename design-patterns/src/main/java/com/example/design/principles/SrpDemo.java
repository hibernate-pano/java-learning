package com.example.design.principles;

/**
 * SrpDemo
 * 单一职责原则
 *
 * @author Panbo
 * @create_time 2023/6/5 22:36
 */
public class SrpDemo {

    public static void main(String[] args) {
        SrpDemo demo = new SrpDemo();
        demo.test();
    }

    public void test() {
        Bird bird = new Bird();
        bird.mainMoveMode("大雁");
        bird.mainMoveMode("鸵鸟");
        bird.mainMoveMode("企鹅");
    }

    static class Bird {
        public void mainMoveMode(String birdName) {
            if ("鸵鸟".equals(birdName)) {
                System.out.println(birdName + "用脚走");
            } else {
                System.out.println(birdName + "用翅膀飞");
            }
        }
    }
}
