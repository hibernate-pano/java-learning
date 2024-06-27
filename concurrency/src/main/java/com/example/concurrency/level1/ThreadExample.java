package com.example.concurrency.level1;

/**
 * 这个方法中，我们创建了两个 ThreadExample 对象，并调用了 run 方法和 start 方法。
 * 这两个方法的区别在于：run 方法是直接调用，而 start 方法是将线程放入线程池中等待执行。
 * 因此，run 方法和 start 方法的区别在于：
 * 1. run 方法是直接调用，而 start 方法是将线程放入线程池中等待执行。
 * 2. run 方法是直接调用，因此如果 run 方法中出现异常，则会导致线程终止。
 * 3. run 方法是在当前线程中执行，而 start 方法是在线程池中执行（线程池中的线程会从线程池中取出，并执行 run 方法）。
 * <p>
 * <p>
 * 从输出的内容中可以清晰的看到，上述的区别：
 * 1. run 方法的输出顺序是：
 * main - 0
 * main - 1
 * main - 2
 * main - 3
 * main - 4
 * main - 0
 * main - 1
 * main - 2
 * main - 3
 * main - 4
 * 2. start 方法的输出顺序是：
 * Thread-0 - 0
 * Thread-1 - 0
 * Thread-0 - 1
 * Thread-1 - 1
 * Thread-0 - 2
 * Thread-1 - 2
 * Thread-0 - 3
 * Thread-1 - 3
 * Thread-0 - 4
 * Thread-1 - 4
 * <p>
 * run 方法因为在当前线程执行，所有有序依次执行；
 * start 方法因为将线程放入线程池中等待执行，因此输出的顺序是交替的。
 *
 * @author panbo
 */
public class ThreadExample extends Thread {
    public static void main(String[] args) {
        ThreadExample thread1 = new ThreadExample();
        ThreadExample thread2 = new ThreadExample();

        // 直接调用 run 方法
        thread1.run();
        thread2.run();

        // 调用 start 方法
        thread1.start();
        thread2.start();
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(Thread.currentThread().getName() + " - " + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}