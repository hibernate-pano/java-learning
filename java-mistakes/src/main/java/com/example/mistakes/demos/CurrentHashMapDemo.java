package com.example.mistakes.demos;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.TimeUnit;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.LongStream;

/**
 * @author pano
 * @date 2022/5/7
 **/
@Slf4j
@RestController
@RequestMapping("current_hash_map")
public class CurrentHashMapDemo {

    //线程个数
    private static final int THREAD_COUNT = 10;
    //总元素数量
    private static final int ITEM_COUNT = 1000;

    //帮助方法，用来获得一个指定元素数量模拟数据的ConcurrentHashMap
    private ConcurrentHashMap<String, Long> getData(int count) {
        return LongStream.rangeClosed(1, count)
                .boxed()
                .collect(
                        Collectors.toConcurrentMap(
                                i -> UUID.randomUUID().toString(),
                                Function.identity(),
                                (o1, o2) -> o1, ConcurrentHashMap::new)
                );
    }

    @GetMapping("wrong")
    public String wrong() throws InterruptedException {
        ConcurrentHashMap<String, Long> concurrentHashMap = getData(ITEM_COUNT - 100);
        //初始900个元素
        log.info("init size:{}", concurrentHashMap.size());

        ForkJoinPool forkJoinPool = new ForkJoinPool(THREAD_COUNT);
        //使用线程池并发处理逻辑
        forkJoinPool.execute(
                () ->
                        IntStream
                                .rangeClosed(1, 10)
                                .parallel()
                                .forEach(i -> {
                                            // 此处不是线程安全的，CurrentHashMap本身安全不代表此处获取size再put数据也是线程安全的
                                            // 所以加上 synchronized 关键字
                                            synchronized (this) {
                                                //查询还需要补充多少个元素
                                                int gap = ITEM_COUNT - concurrentHashMap.size();
                                                log.info("gap size:{}", gap);
                                                //补充元素
                                                concurrentHashMap.putAll(getData(gap));
                                            }
                                        }
                                )
        );
        //等待所有任务完成
        forkJoinPool.shutdown();
        forkJoinPool.awaitTermination(1, TimeUnit.HOURS);
        //最后元素个数会是1000吗？
        log.info("finish size:{}", concurrentHashMap.size());
        return "OK";
    }

}
