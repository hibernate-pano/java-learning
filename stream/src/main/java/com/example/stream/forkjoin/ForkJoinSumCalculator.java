package com.example.stream.forkjoin;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveTask;
import java.util.stream.LongStream;

/**
 * fork and join 框架，用以计算求和
 *
 * @author pano
 * @date 2022/11/1
 **/
public class ForkJoinSumCalculator extends RecursiveTask<Long> {

    /**
     * 终止位置
     */
    public static final long THRESHOLD = 10;
    /**
     * 数组
     */
    private final long[] numbers;
    /**
     * 起始位置
     */
    private final int start;
    /**
     * 结束位置
     */
    private final int end;


    public ForkJoinSumCalculator(long[] numbers, int start, int end) {
        this.numbers = numbers;
        this.start = start;
        this.end = end;
    }

    public ForkJoinSumCalculator(long[] numbers) {
        this(numbers, 0, numbers.length);
    }

    public static void main(String[] args) {
        long[] numbers = LongStream.rangeClosed(1, 100).toArray();
        ForkJoinTask<Long> task = new ForkJoinSumCalculator(numbers);
        System.out.println(new ForkJoinPool().invoke(task));
    }

    /**
     * The main computation performed by this task.
     *
     * @return the result of the computation
     */
    @Override
    protected Long compute() {
        int length = end - start;
        // 如果剩余的长度《=门槛长度，则不可再分
        if (length <= THRESHOLD) {
            return computeSequentially();
        }
        // 分成左右两份，进行fork
        ForkJoinSumCalculator left = new ForkJoinSumCalculator(numbers, start, start + length / 2);
        left.fork();
        ForkJoinSumCalculator right = new ForkJoinSumCalculator(numbers, start + length / 2, end);
        Long rightResult = right.compute();
        Long leftResult = left.join();
        return leftResult + rightResult;
    }

    private Long computeSequentially() {
        return Arrays.stream(numbers).skip(start).limit(end - start).sum();
    }
}
