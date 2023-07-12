package com.example.mistakes.demos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.util.Assert;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadLocalRandom;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.LongAdder;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

/**
 * @author pano
 * @date 2022/5/7
 **/
@Slf4j
@RestController
@RequestMapping("current_hash_map")
public class CurrentHashMapDemo2 {

    /**
     * 循环次数
     */
    private static final int LOOP_COUNT = 10000000;
    /**
     * 线程数量
     */
    private static final int THREAD_COUNT = 10;
    /**
     * 元素数量
     */
    private static final int ITEM_COUNT = 10;

    private Map<String, Long> normalUse() throws InterruptedException {
        ConcurrentHashMap<String, Long> freq = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(
                () -> IntStream.rangeClosed(1, LOOP_COUNT)
                        .parallel()
                        .forEach(i -> {
                                    //获得一个随机的Key
                                    String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                                    synchronized (freq) {
                                        if (freq.containsKey(key)) {
                                            //Key 存在则+1
                                            freq.put(key, freq.get(key) + 1);
                                        } else {
                                            //Key 不存在则初始化为1
                                            freq.put(key, 1L);
                                        }
                                    }
                                }
                        ));
        // 关闭链接池
        forkJoinPool.shutdown();
        // 等待时长
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        return freq;
    }

    private Map<String, Long> goodUse() throws InterruptedException {
        ConcurrentHashMap<String, LongAdder> freq = new ConcurrentHashMap<>(ITEM_COUNT);
        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        forkJoinPool.execute(
                () -> IntStream.rangeClosed(1, LOOP_COUNT)
                        .parallel()
                        .forEach(i -> {
                                    String key = "item" + ThreadLocalRandom.current().nextInt(ITEM_COUNT);
                                    //利用computeIfAbsent()方法来实例化LongAdder，然后利用LongAdder来进行线程安全计数
                                    freq.computeIfAbsent(key, k -> new LongAdder()).increment();
                                }
                        ));
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);

        //因为我们的Value是LongAdder而不是Long，所以需要做一次转换才能返回
        return freq.entrySet().stream()
                .collect(Collectors.toMap(Map.Entry::getKey, e -> e.getValue().longValue()));
    }

    @GetMapping("good")
    public String good() throws InterruptedException {
        StopWatch stopWatch = new StopWatch();
        stopWatch.start("normalUse");
        Map<String, Long> normalUse = normalUse();
        stopWatch.stop();
        //校验元素数量
        Assert.isTrue(normalUse.size() == ITEM_COUNT, "normalUse size error");
        //校验累计总数
        Assert.isTrue(normalUse.values().stream().mapToLong(aLong -> aLong).reduce(0, Long::sum) == LOOP_COUNT, "normalUse count error");
        stopWatch.start("goodUse");
        Map<String, Long> goodUse = goodUse();
        stopWatch.stop();
        Assert.isTrue(goodUse.size() == ITEM_COUNT, "goodUse size error");
        Assert.isTrue(goodUse.values().stream().mapToLong(aLong -> aLong).reduce(0, Long::sum) == LOOP_COUNT, "goodUse count error");
        log.info(stopWatch.prettyPrint());
        return "OK";
    }
}
